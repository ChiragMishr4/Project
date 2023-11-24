package ui.gui;

import model.*;
import ui.DigitalRecipeBookApp;
import ui.buttons.*;

import javax.swing.*;
import java.awt.*;


public class MenuButtons extends JPanel {

    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookAppGUI;
    private RecipeBooks recipeBooks;

    public MenuButtons(RecipeBook r, RecipeBooks recipeBooks,  DigitalRecipeBookAppGUI drB) {
        this.recipeBook = r;
        this.recipeBooks = recipeBooks;
        this.digitalRecipeBookAppGUI = drB;
        initializeButtons();
        initializePanel();
    }

    private void initializePanel() {
        setPreferredSize(new Dimension(110, 45));
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        setVisible(true);
        setBackground(new Color(69, 80, 59));
    }

    private void initializeButtons() {
        add(new LoadButton(recipeBook, recipeBooks,  digitalRecipeBookAppGUI));
        add(new AddButton(recipeBook, digitalRecipeBookAppGUI));
        add(new RemoveButton(recipeBook, digitalRecipeBookAppGUI));
        add(new SaveButton(recipeBooks));
    }
}
