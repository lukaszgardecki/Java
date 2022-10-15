package program.elements.panels;

import program.elements.main_frame.Window;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    public static final int X = 0;
    public static final int Y = 0;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static MainPanel mainPanel;
    public static MenuPanel menuPanel;

    public Content() {
        setLocation(X, Y);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(MyColor.BLUE);
        setLayout(null);

        mainPanel = new MainPanel();
        add(mainPanel);

        menuPanel = new MenuPanel();
        add(menuPanel);
    }
}
