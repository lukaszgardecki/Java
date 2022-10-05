package game;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JLayeredPane {



    private static int marginX = 10;
    private static int marginY = 10;

    static ScoreTimePanel scoreTimePanel;


//    static int mainPanelWidth = BoardButtonsPanel.boardPanelWidth + (2 * marginX);
    private int mainPanelWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * marginX);

//    static int mainPanelHeight = ScoreTimePanel.scoreTimePanelHeight +
//                                BoardButtonsPanel.boardPanelHeight + (3 * marginY);
    private int mainPanelHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + (3 * marginY);



//    static BoardButtonsPanel boardButtonsPanel;
//    static BoardLabelPanel boardLabelPanel;
//
    MainPanel() {
        scoreTimePanel = new ScoreTimePanel();
//        boardLabelPanel = new BoardLabelPanel();
//        boardButtonsPanel = new BoardButtonsPanel();
//
////        setPreferredSize(new Dimension(mainPanelWidth, mainPanelHeight));
////        setLocation(0, 30);
//
        setBounds(0, MainContainer.menu.getMenuHeight(), mainPanelWidth, mainPanelHeight);
        setOpaque(true);
        setBackground(new Color(2, 58, 112));

//        setLayout(null);

        add(scoreTimePanel, JLayeredPane.DEFAULT_LAYER);
//        //add(, JLayeredPane.DEFAULT_LAYER);
//        add(boardButtonsPanel, JLayeredPane.PALETTE_LAYER);
//        //add(new BoardLabelPanel(), JLayeredPane.PALETTE_LAYER);
//        add(boardLabelPanel, JLayeredPane.DEFAULT_LAYER);
//        //add(new BoardButtonsPanel(), JLayeredPane.DEFAULT_LAYER);
//
    }

//    public void setMainPanelWidth(int width) {
//        mainPanelWidth = width;
//    }

//    public void setMainPanelHeight(int height) {
//        mainPanelHeight = height;
//    }


    public static int getMarginX() {
        return marginX;
    }

    public static int getMarginY() {
        return marginY;
    }
}
