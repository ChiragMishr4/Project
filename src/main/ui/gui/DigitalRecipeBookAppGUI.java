package ui.gui;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class DigitalRecipeBookAppGUI extends JFrame{

    private RecipeBook recipeBook;
    private JPanel head = new JPanel();
    private JPanel header = new JPanel();
    private MiddlePanel panel;


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

}
