package ui.buttons;

import model.*;
import ui.gui.DigitalRecipeBookAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class AddButton extends JButton implements ActionListener {
    private RecipeBook recipeBook;
    private List<String> ingredients;
    private List<String> instructions;
    private String cuisine;
    private String name;
    private DigitalRecipeBookAppGUI digitalRecipeBook;
    private boolean keepGoing;
    int idGen = 0;

    public AddButton(RecipeBook r, DigitalRecipeBookAppGUI drB) {
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
        this.digitalRecipeBook = drB;
        this.recipeBook = r;
        this.addActionListener(this);
        setText("Add a Recipe");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = JOptionPane.showInputDialog("Enter the name of your dish!");
        name = s;
        String c = JOptionPane.showInputDialog("Enter the cuisine of this dish!");
        cuisine = c;
        int f = JOptionPane.showConfirmDialog(null,
                "Would you like to add the required ingredients?",
                "", JOptionPane.YES_NO_OPTION);
        if (f == 0) {
            keepGoing = true;
            addIngredients();
        }
        int j = JOptionPane.showConfirmDialog(null,
                "Would you like to add Cooking Instructions?",
                "", JOptionPane.YES_NO_OPTION);
        if (j == 0) {
            addCookingInstructions();
        }
        recipeCreator();
    }

    public void addIngredients() {
        do {
            String i = JOptionPane.showInputDialog("Enter the name of the ingredient: ");
            ingredients.add(i);
            int f = JOptionPane.showConfirmDialog(null,
                    "Would you like to add another ingredient?",
                    "", JOptionPane.YES_NO_OPTION);
            if (f == 1) {
                keepGoing = false;
            }
        } while (keepGoing);
    }

    public void addCookingInstructions() {
        boolean keepGoing1 = true;
        do {
            String c = JOptionPane.showInputDialog("Enter the cooking instruction: ");
            instructions.add(c);
            int f = JOptionPane.showConfirmDialog(null,
                    "Would you like to add another Cooking Instruction?",
                    "", JOptionPane.YES_NO_OPTION);
            if (f == 1) {
                keepGoing1 = false;
            }
        } while (keepGoing1);
    }

    public void recipeCreator() {
        Recipe r = new Recipe(name, cuisine);
        for (String s : ingredients) {
            r.addIngredient(s);
        }
        for (String i : instructions) {
            r.addCookingInstruction(i, idGen);
            idGen += 1;
        }
        recipeBook.addRecipe(r);
        digitalRecipeBook.updatePanel(recipeBook.getRecipes());
    }
}
