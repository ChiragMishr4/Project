package ui.buttons;

import model.*;
import ui.gui.DigitalRecipeBookAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoveButton extends JButton implements ActionListener {
    private static final String json_book = "./data/recipes.json";
    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookAppGUI;
    private ArrayList<Recipe> recipes;

    public RemoveButton(RecipeBook r, DigitalRecipeBookAppGUI drB) {
        this.digitalRecipeBookAppGUI = drB;
        this.recipeBook = r;
        this.addActionListener(this);
        setText("Remove Recipe");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = JOptionPane.showInputDialog("Enter the name of the recipe you would like to remove");
        recipes = recipeBook.getRecipes();
        for (Recipe r : recipes) {
            if (r.getName().equals(s)) {
                System.out.println(r.getName());
                recipes.remove(r);
                System.out.println(recipes);
                digitalRecipeBookAppGUI.updatePanel(recipes);
            }
        }
    }
}
