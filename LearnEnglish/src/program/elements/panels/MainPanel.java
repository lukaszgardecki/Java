package program.elements.panels;

import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;
import program.elements.panels.views.View;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    public static final int X = Content.X;
    public static final int Y = Content.Y;
    public static final int WIDTH = Content.WIDTH - MenuPanel.WIDTH;
    public static final int HEIGHT = Content.HEIGHT;
    static View mainView;
    static View statsView;

    public MainPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        //setBackground(Color.green);
        setBackground(null);
        setLayout(null);

        mainView = new MainView();
        add(mainView);

        statsView = new StatsView();
        add(statsView);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
