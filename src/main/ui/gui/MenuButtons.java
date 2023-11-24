package ui.gui;

import model.*;
import ui.DigitalRecipeBookApp;
import ui.buttons.*;

import javax.swing.*;
import java.awt.*;


//Represents the Bottom row of the Panel.
public class MenuButtons extends JPanel {

    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookAppGUI;
    private RecipeBooks recipeBooks;

    //EFFECTS: Adds buttons to the Panel.
    public MenuButtons(RecipeBook r, RecipeBooks recipeBooks,  DigitalRecipeBookAppGUI drB) {
        this.recipeBook = r;
        this.recipeBooks = recipeBooks;
        this.digitalRecipeBookAppGUI = drB;
        initializeButtons();
        initializePanel();
    }

    //EFFECTS: Initializes the panel.
    private void initializePanel() {
        setPreferredSize(new Dimension(110, 45));
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        setVisible(true);
        setBackground(new Color(69, 80, 59));
    }

    //EFFECTS: Initializes and adds the buttons to the panel.
    private void initializeButtons() {
        add(new LoadButton(recipeBook, recipeBooks,  digitalRecipeBookAppGUI));
        add(new AddButton(recipeBook, digitalRecipeBookAppGUI));
        add(new RemoveButton(recipeBook, digitalRecipeBookAppGUI));
        add(new SaveButton(recipeBooks));
    }
}
