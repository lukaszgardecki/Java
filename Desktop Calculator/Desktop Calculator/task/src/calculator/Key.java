package calculator;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class Key extends JButton {
    public static final Font KEY_FONT = new Font("Courier", Font.PLAIN, 20);
    Border emptyBorder = BorderFactory.createEmptyBorder();

    public Key(String text, String name, ActionListener actionListener) {
        setFont(KEY_FONT);
        setBackground(Color.WHITE);
        setText(text);
        setName(name);
        setActionCommand(name);
        addActionListener(actionListener);
        setBorder(emptyBorder);
    }
}
