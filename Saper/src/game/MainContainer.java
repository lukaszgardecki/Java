package game;

import javax.swing.*;
import java.awt.*;

public class MainContainer extends JPanel {

    MenuSaper menu;
    MainPanel mainPanel;

    MainContainer() {
        setPreferredSize(new Dimension(400, 450));
        setBackground(Color.RED);
        setLayout(null);

        menu = new MenuSaper();
        mainPanel = new MainPanel();

        add(menu);
        add(mainPanel);



    }
}
