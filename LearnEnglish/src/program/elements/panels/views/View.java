package program.elements.panels.views;

import program.elements.panels.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JPanel implements ActionListener {
    public static final int X = MainPanel.X;
    public static final int Y = MainPanel.Y;
    public static final int WIDTH = MainPanel.WIDTH;
    public static final int HEIGHT = MainPanel.HEIGHT;

    public View() {
        setBounds(X, Y, WIDTH, HEIGHT);
        setBackground(null);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
