package game;

import javax.swing.*;
import java.awt.*;

public class MainContainer extends JPanel {

    MenuSaper menu;
    MainPanel mainPanel;
    private int mainContainerWidth = MainPanel.mainPanelWidth;
    private int mainContainerHeight = MainPanel.mainPanelHeight + MenuSaper.menuHeight;

    MainContainer() {
        setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
        //setBackground(Color.RED);
        setLayout(null);

        menu = new MenuSaper();
        mainPanel = new MainPanel();

        add(menu);
        add(mainPanel);



    }
}
