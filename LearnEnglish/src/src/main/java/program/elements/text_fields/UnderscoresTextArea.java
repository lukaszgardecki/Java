package program.elements.text_fields;

import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class UnderscoresTextArea extends JTextArea {
    public UnderscoresTextArea() {
        setBackground(null);
        setOpaque(false);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBounds(55, 195, 450, 100);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        setForeground(MyColor.BLACK);
    }
}
