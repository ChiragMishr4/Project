package ui.buttons;

import model.*;
import persistence.JsonReader;
import ui.gui.DigitalRecipeBookAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


public class LoadButton extends JButton implements ActionListener {

    private static final String json_book = "./data/recipes.json";
    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookGUI;
    private JsonReader jsonReader;
    private List<Recipe> recipesList;

    public LoadButton(RecipeBook r, DigitalRecipeBookAppGUI drB) {
        this.digitalRecipeBookGUI = drB;
        this.recipeBook = r;
        jsonReader = new JsonReader(json_book);
        this.addActionListener(this);
        setText("Load Previous Recipes");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            recipeBook = jsonReader.read();
            System.out.println("Loaded everything");
            digitalRecipeBookGUI.updatePanel(recipeBook.getRecipes());
        } catch (IOException c) {
            System.out.println("Unable to read from file");
        }
    }
}
