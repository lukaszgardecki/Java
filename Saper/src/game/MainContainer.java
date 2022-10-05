package game;

import javax.swing.*;
import java.awt.*;

public class MainContainer extends JPanel {
    static MenuSaper menu = new MenuSaper();
    static MainPanel mainPanel = new MainPanel();
//    static int marginX = 10;
//    static int marginY = 10;
//    static int mainContainerWidth = FieldLabel.fieldWidth*Main.game.getGameWidth() + (2 * marginX);
//    static int mainContainerHeight = ScoreTimePanel.scoreTimePanelHeight +
//            FieldLabel.fieldHeight * Main.game.getGameHeight() + (3 * marginY) + MenuSaper.menuHeight;

    int mainContainerWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10);;
    int mainContainerHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + menu.getMenuHeight() + (3 * 10);
//
    MainContainer() {
       // mainPanel = new MainPanel();


//        setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
        setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
       //setBounds(0, 0, 400, 400);
//        menu = new MenuSaper();

        setLayout(null);
        setBackground(Color.RED);


        add(menu);
//        //add(new MenuSaper());
        add(mainPanel);
//        //add(new MainPanel());
    }

    public void setMainContainerWidth(int width) {
        mainContainerWidth = width;
    }

    public void setMainContainerHeight(int height) {
        mainContainerHeight = height;
    }

    public int getMainContainerWidth() {
        return mainContainerWidth;
    }

    public int getMainContainerHeight() {
        return mainContainerHeight;
    }
}
