package game;

import javax.swing.*;
import java.awt.*;

public class MainContainer extends JPanel {
    static MenuSaper menu;
    static MainPanel mainPanel;
    static int mainContainerWidth = MainPanel.mainPanelWidth;
    static int mainContainerHeight = MainPanel.mainPanelHeight + MenuSaper.menuHeight;

    MainContainer() {
        mainPanel = new MainPanel();
        menu = new MenuSaper();

       setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));

        setLayout(null);

        add(menu);
        add(mainPanel);
    }

    public void setMainContainerWidth(int width) {
        mainContainerWidth = width;
    }

    public void setMainContainerHeight(int height) {
        mainContainerHeight = height;
    }
}
