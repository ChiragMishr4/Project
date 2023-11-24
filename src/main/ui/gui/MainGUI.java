package ui.gui;

import ui.buttons.AddButton;
import ui.buttons.LoadButton;
import ui.buttons.RemoveButton;
import ui.buttons.SaveButton;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainGUI {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException {
        try {

            // Here you can select the selected theme class name in JTatt
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        } catch (InstantiationException ex) {
            Logger.getLogger(AddButton.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(RemoveButton.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(LoadButton.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(SaveButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AddButton.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(RemoveButton.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(LoadButton.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(SaveButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        run();
    }

    public static void run() {
        new DigitalRecipeBookAppGUI();
    }
}
