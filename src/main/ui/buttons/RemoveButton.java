package ui.buttons;

import model.*;
import ui.gui.DigitalRecipeBookAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Represents the "Remove" button on the JFrame.
public class RemoveButton extends JButton implements ActionListener {
    private static final String json_book = "./data/recipes.json";
    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookAppGUI;
    private ArrayList<Recipe> recipes;


    //MODIFIES: this
    //EFFECTS: Creates the Remove button and adds it to panel.
    public RemoveButton(RecipeBook r, DigitalRecipeBookAppGUI drB) {
        this.digitalRecipeBookAppGUI = drB;
        recipes = new ArrayList<>();
        this.recipeBook = r;
        this.addActionListener(this);
        setText("Remove Recipe");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 18));
    }

    //MODIFIES: this
    //EFFECTS: Removes Recipes from the panel.
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
