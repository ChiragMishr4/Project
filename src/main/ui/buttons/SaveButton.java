package ui.buttons;

import model.*;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SaveButton extends JButton implements ActionListener {
    private static final String json_book = "./data/recipes.json";
    private JsonWriter jsonWriter;
    private RecipeBooks recipeBook;

    public SaveButton(RecipeBooks r) {
        this.recipeBook = r;
        jsonWriter = new JsonWriter(json_book);
        this.addActionListener(this);
        setText("Save Recipes");
        setFocusable(false);
        setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            jsonWriter.open();
            jsonWriter.write(recipeBook);
            jsonWriter.close();
            System.out.println("Saved Everything");
        } catch (FileNotFoundException c) {
            System.out.println("Unable to write to file");
        }
    }
}
