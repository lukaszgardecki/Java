package program.elements.panels;

import program.elements.main_frame.Window;
import program.settings.MyColor;

import javax.swing.*;

public class Content extends JPanel {
    public static final int X = 0;
    public static final int Y = 0;
    public static final int WIDTH = Window.WIDTH-16;
    public static final int HEIGHT = Window.HEIGHT-39;
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
