package ui.buttons;

import model.*;
import persistence.JsonReader;
import ui.gui.DigitalRecipeBookAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoadButton extends JButton implements ActionListener {

    private static final String json_book = "./data/recipes.json";
    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookGUI;
    private RecipeBooks recipeBooks;
    private JsonReader jsonReader;
    private List<RecipeBook> recipesList = new ArrayList<>();

    public LoadButton(RecipeBook r, RecipeBooks recipeBooks, DigitalRecipeBookAppGUI drB) {
        this.digitalRecipeBookGUI = drB;
        this.recipeBook = r;
        this.recipeBooks = recipeBooks;
        jsonReader = new JsonReader(json_book);
        this.addActionListener(this);
        setText("Load Previous Recipes");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            recipeBooks = jsonReader.read();
            System.out.println("Loaded everything");
            recipesList = recipeBooks.getRecipeBooks();
            for (RecipeBook r : recipesList) {
                for (Recipe i : r.getRecipes()) {
                    recipeBook.addRecipe(i);
                }
                digitalRecipeBookGUI.updatePanel(r.getRecipes());
            }
        } catch (IOException c) {
            System.out.println("Unable to read from file");
        }
    }
}
