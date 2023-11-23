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
    private String cuisine;
    private String name;
    private DigitalRecipeBookAppGUI digitalRecipeBook;
    private List<RecipeBook> recipeBooksList = new ArrayList<>();
    private boolean keepGoing;
    int idGen = 0;

    public AddButton(RecipeBook r, DigitalRecipeBookAppGUI drB) {
        this.digitalRecipeBook = drB;
        this.recipeBook = r;
        this.addActionListener(this);
        setText("Add a Recipe");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = JOptionPane.showInputDialog("Enter the name of your dish!");
        name = s;
        String c = JOptionPane.showInputDialog("Enter the cuisine of this dish!");
        cuisine = c;
        Recipe r = new Recipe(name, cuisine);
        int f = JOptionPane.showConfirmDialog(null,
                "Would you like to add the required ingredients?",
                "", JOptionPane.YES_NO_OPTION);
        if (f == 0) {
            keepGoing = true;
            addIngredients(r);
        }
        int j = JOptionPane.showConfirmDialog(null,
                "Would you like to add Cooking Instructions?",
                "", JOptionPane.YES_NO_OPTION);
        if (j == 0) {
            addCookingInstructions(r);
        }
        recipeCreator(r);
    }

    public void addIngredients(Recipe r) {
        do {
            String i = JOptionPane.showInputDialog("Enter the name of the ingredient: ");
            r.addIngredient(i);
            int f = JOptionPane.showConfirmDialog(null,
                    "Would you like to add another ingredient?",
                    "", JOptionPane.YES_NO_OPTION);
            if (f == 1) {
                keepGoing = false;
            }
        } while (keepGoing);
    }

    public void addCookingInstructions(Recipe r) {
        boolean keepGoing1 = true;
        do {
            String c = JOptionPane.showInputDialog("Enter the cooking instruction: ");
            idGen += 1;
            r.addCookingInstruction(c, idGen);
            int f = JOptionPane.showConfirmDialog(null,
                    "Would you like to add another Cooking Instruction?",
                    "", JOptionPane.YES_NO_OPTION);
            if (f == 1) {
                keepGoing1 = false;
            }
        } while (keepGoing1);
    }

    public void recipeCreator(Recipe r) {
        recipeBook.addRecipe(r);
        recipeBooksList.add(recipeBook);
        digitalRecipeBook.updatePanel(recipeBook.getRecipes());
    }
}
