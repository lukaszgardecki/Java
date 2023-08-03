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

    MainContainer() {
        setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
        setLayout(null);
        setBackground(Color.RED);

        add(menu);
        add(mainPanel);
    }

    void changeSize() {
        setPreferredSize(new Dimension(
                FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10),
                FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + MainContainer.menu.getMenuHeight() + (3 * 10)));
    }

    static void changeSizeOfElements() {
        menu.changeSize();
        mainPanel.changeSize();
    }
}
