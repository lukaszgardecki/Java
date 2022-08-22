package program.elements.panels;

import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {
    public static final int X = Content.X;
    public static final int Y = Content.Y;
    public static final int WIDTH = Content.WIDTH - MenuPanel.WIDTH;
    public static final int HEIGHT = Content.HEIGHT;

    public MainPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        //setBackground(MyColor.BLUE);
        setLayout(null);

        MainView view1 = new MainView();
        StatsView view2 = new StatsView();

        add(view1);
        add(view2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
