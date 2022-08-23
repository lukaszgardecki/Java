package program.elements.text_fields;

import program.Main;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class EnglishWordTextArea extends JTextArea {
    public EnglishWordTextArea() {
        setText(Main.loadWord().get(4));
        setBounds(55, 30, 450, 80);
        setLineWrap(true);
        setWrapStyleWord(true);
        setEditable(false);
        setBackground(null);
        setForeground(MyColor.BLACK);
        setFont(new Font("Courier", Font.BOLD, 30));
    }
}
