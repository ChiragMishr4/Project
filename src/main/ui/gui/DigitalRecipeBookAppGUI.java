package ui.gui;

import model.*;
import model.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


//Represents the DigitalRecipeBookApp Interface.
public class DigitalRecipeBookAppGUI extends JFrame {

    private RecipeBook recipeBook;
    private RecipeBooks recipeBooks;
    private DigitalRecipeBookAppGUI drB;
    private JPanel head = new JPanel();
    private JLabel header = new JLabel("Digital Recipe Book");
    private MiddlePanel panel;


    //EFFECTS: Runs the DigitalRecipeBook application.
    public DigitalRecipeBookAppGUI() {
        super("Digital Recipe Book");
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        String s = "Digital Recipe Book";
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                handleClosing();
            }
        });
        recipeBook = new RecipeBook(s);
        recipeBooks = new RecipeBooks();
        recipeBooks.addRecipeBook(recipeBook);
        add(new MenuButtons(recipeBook, recipeBooks,this), BorderLayout.SOUTH);
        initializeMiddlePanel();
    }

    //MODIFIES: this
    //EFFECTS: Creates the middle panel of the Frame.
    public void initializeMiddlePanel() {
        panel = new MiddlePanel();
        panel.setBackground(Color.darkGray);
        panel.add(new JLabel(""));
        panel.setLayout(new GridLayout(3,3,20,25));
        panel.setBackground(new Color(194, 197, 187));
        add(panel, BorderLayout.CENTER);
        head.setBackground(new Color(129,52,5));
        add(head, BorderLayout.NORTH);
        header.setFont(new Font("Sans-serif", Font.BOLD, 25));
        ImageIcon logo = new ImageIcon("./data/meal.png");
        header.setIcon(logo);
        head.add(header);
        setVisible(true);
    }

    private void handleClosing() {
        EventLog eventLog = EventLog.getInstance();
        for (Event e : eventLog) {
            System.out.println(e.getDescription());
        }
        System.exit(0);
    }


    //MODIFIES: this
    //EFFECTS: Updates the panel when a new action is performed.
    public void updatePanel(List<Recipe> recipes) {
        panel.removeAll();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Recipe f : recipes) {
            JButton detailsButton = new JButton("View Recipe");
            JLabel name = new JLabel(f.getName());
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailsButton.setFocusable(false);
            panel.add(name);
            panel.add(detailsButton);
            detailsButton.addActionListener(evt -> {
                showDetails(f);
            });
            panel.add(Box.createVerticalStrut(10));
        }
        panel.revalidate();
        panel.repaint();
        setVisible(true);
    }

    //EFFECTS: Displays the information of the Recipe on the Panel.
    private void showDetails(Recipe r) {
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.add(new JLabel(String.format("Name : %s", r.getName())));
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(new JLabel((String.format("Cuisine : %s", r.getCuisine()))));
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(new JLabel((String.format("Ingredients : %s", r.getIngredients()))));
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(new JLabel((String.format("Cooking Instructions : "))));
        for (CookingInstructions i : r.getCookingInstructions()) {
            JLabel label = new JLabel(i.getInstruction());
            detailsPanel.add(label);
        }
        detailsPanel.add(Box.createVerticalStrut(5));
        JOptionPane.showConfirmDialog(null, detailsPanel, "Details", JOptionPane.PLAIN_MESSAGE);
    }

}
