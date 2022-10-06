package game;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JLayeredPane {

    private static int marginX = 10;
    private static int marginY = 10;

    static ScoreTimePanel scoreTimePanel;

    private int mainPanelWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * marginX);
    private int mainPanelHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + (3 * marginY);

    static BoardButtonsPanel boardButtonsPanel;
    static BoardLabelPanel boardLabelPanel;

    MainPanel() {
        scoreTimePanel = new ScoreTimePanel();
        boardLabelPanel = new BoardLabelPanel();
        boardButtonsPanel = new BoardButtonsPanel();

        setBounds(0, MainContainer.menu.getMenuHeight(), mainPanelWidth, mainPanelHeight);
        setOpaque(true);
        setBackground(new Color(2, 58, 112));
//        setLayout(null);

        add(scoreTimePanel, JLayeredPane.DEFAULT_LAYER);
        add(boardButtonsPanel, JLayeredPane.PALETTE_LAYER);
        add(boardLabelPanel, JLayeredPane.DEFAULT_LAYER);
    }

    void changeSize() {
        MainContainer.mainPanel.setBounds(0,
                MainContainer.menu.getMenuHeight(),
                FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * getMarginX()),
                FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + (3 * getMarginY()));
    }

    static void refresh() {
        changeSizeOfElements();
        resetElements();
    }

    static void changeSizeOfElements() {
        scoreTimePanel.changeSize();
        boardLabelPanel.changeSize();
        boardButtonsPanel.changeSize();
    }

    static void resetElements() {
        scoreTimePanel.resetPanel();
        boardLabelPanel.setNewBoard();
        boardButtonsPanel.setNewBoard();
    }


    public static int getMarginX() {
        return marginX;
    }

    public static int getMarginY() {
        return marginY;
    }
}
