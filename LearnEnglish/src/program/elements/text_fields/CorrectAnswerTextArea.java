package program.elements.text_fields;

import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class CorrectAnswerTextArea extends JTextArea {

    public CorrectAnswerTextArea() {
        setBackground(MyColor.BLUE);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBounds(55, 185, 450, 27);
        setFont(new Font("Courier", Font.PLAIN, 22));
        setForeground(MyColor.GREEN);
    }

}
