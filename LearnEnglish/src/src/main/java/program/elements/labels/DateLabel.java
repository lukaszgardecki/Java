package program.elements.labels;

import program.Main;
import program.elements.panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class DateLabel extends JLabel {

    final int WIDTH = 450;
    final int HEIGHT = 20;
    final int X = (MainPanel.WIDTH - WIDTH)/2;
    final int Y = 315;

    public DateLabel() {

        setText("Ostatnia powtórka: " + Main.getDate());
        setHorizontalAlignment(RIGHT);
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
        setFont(new Font("Courier", Font.PLAIN, 12));
        //setOpaque(true);
        //setBackground(Color.GREEN);

    }
}
