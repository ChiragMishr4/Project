package ui.gui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class DigitalRecipeBookAppGUI extends JFrame {

    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI drB;
    private JPanel head = new JPanel();
    private JLabel header = new JLabel("Digital Recipe Book");
    private MiddlePanel panel;

    public DigitalRecipeBookAppGUI() {
        super("Digital Recipe Book");
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        setLayout(new BorderLayout());
        recipeBook = new RecipeBook();
        add(new MenuButtons(recipeBook, this), BorderLayout.SOUTH);
        initializeMiddlePanel();
    }

    public void initializeMiddlePanel() {
        panel = new MiddlePanel();
        panel.setBackground(Color.darkGray);
        panel.add(new JLabel(""));
        panel.setBackground(new Color(232, 93, 4));
        add(panel, BorderLayout.CENTER);
        head.setBackground(new Color(220, 47, 2));
        add(head, BorderLayout.NORTH);
        header.setFont(new Font("Sans-serif", Font.BOLD, 25));
        ImageIcon logo = new ImageIcon("./data/newLogo.png");
        header.setIcon(logo);
        head.add(header);
        setVisible(true);
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
