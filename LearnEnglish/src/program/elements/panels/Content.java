package program.elements.panels;

import program.settings.MyColor;

import javax.swing.*;

public class Content extends JPanel {
    public static final int X = 0;
    public static final int Y = 0;
    public static final int WIDTH = 684;
    public static final int HEIGHT = 361;
    public static MainPanel mainPanel;
    public static MenuPanel menuPanel;

    public Content() {
        setBounds(X, Y, WIDTH, HEIGHT);
        setBackground(MyColor.BLUE);
        setLayout(null);

        mainPanel = new MainPanel();
        add(mainPanel);

        menuPanel = new MenuPanel();
        add(menuPanel);
    }
}
