package program.elements.text_fields;

import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class CorrectAnswerTextArea extends JTextArea {
    public CorrectAnswerTextArea() {
        setBackground(null);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBounds(55, 185, 450, 30);
        setFont(new Font("Courier", Font.BOLD, 24));
        setForeground(MyColor.GREEN);
    }
}
