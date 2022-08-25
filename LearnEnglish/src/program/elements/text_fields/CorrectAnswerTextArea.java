package program.elements.text_fields;

import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class CorrectAnswerTextArea extends JTextArea {
    public CorrectAnswerTextArea() {
        setBackground(null);
        setOpaque(false);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBounds(55, 145, 450, 100);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        setForeground(MyColor.GREEN);
    }

}
