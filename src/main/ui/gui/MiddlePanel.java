package ui.gui;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class MiddlePanel extends JPanel {

    public MiddlePanel() {
        super();
    }

    public void setLabel(String s) {
        String p = "";
        this.add(new JLabel(s + p));
    }
}
