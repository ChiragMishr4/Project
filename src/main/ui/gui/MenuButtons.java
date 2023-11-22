package ui.gui;

import model.*;
import ui.DigitalRecipeBookApp;
import ui.buttons.*;

import javax.swing.*;
import java.awt.*;


public class MenuButtons extends JPanel {

    private RecipeBook recipeBook;
    private DigitalRecipeBookAppGUI digitalRecipeBookAppGUI;

    public MenuButtons(RecipeBook r, DigitalRecipeBookAppGUI drB) {
        this.recipeBook = r;
        this.digitalRecipeBookAppGUI = drB;
        initializeButtons();
        initializePanel();
    }

    private void initializePanel() {
        setPreferredSize(new Dimension(110, 45));
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        setVisible(true);
        setBackground(new Color(023047));
    }

    private void initializeButtons() {
        add(new LoadButton(this.recipeBook, this.digitalRecipeBookAppGUI));
        add(new AddButton(this.recipeBook, this.digitalRecipeBookAppGUI));
        add(new RemoveButton(this.recipeBook, this.digitalRecipeBookAppGUI));
        add(new SaveButton(this.recipeBook));
    }
}
