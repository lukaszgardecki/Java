package program.elements.panels;

import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;
import program.elements.panels.views.View;

import javax.swing.*;

public class MainPanel extends JPanel {
    public static final int X = Content.X;
    public static final int Y = Content.Y;
    public static final int WIDTH = Content.WIDTH - MenuPanel.WIDTH;
    public static final int HEIGHT = Content.HEIGHT;
    public static View mainView;
    public static View statsView;
    public static View addRemoveView;

    public MainPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        setBackground(null);
        setLayout(null);

        mainView = new MainView();
        add(mainView);

        statsView = new StatsView();
        add(statsView);

        addRemoveView = new AddOrRemoveView();
        add(addRemoveView);

        setVisible(true);
    }
}
