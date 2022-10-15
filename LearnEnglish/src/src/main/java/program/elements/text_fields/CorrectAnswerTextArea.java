package program.elements.text_fields;

import program.elements.panels.MainPanel;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class CorrectAnswerTextArea extends JTextArea {
    final int WIDTH = 450;
    final int HEIGHT = 100;
    final int X = (MainPanel.WIDTH - WIDTH)/2;
    final int Y = 345;


    public CorrectAnswerTextArea() {
        setBackground(null);
        //setBackground(Color.orange);
        setOpaque(false);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBounds(X, Y, WIDTH, HEIGHT);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        setForeground(MyColor.GREEN);

    }

}
