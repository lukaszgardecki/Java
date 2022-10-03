package game;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JLayeredPane {

    static int marginX = 10;
    static int marginY = 10;

    static int mainPanelWidth = BoardButtonsPanel.boardPanelWidth + (2 * marginX);
    static int mainPanelHeight = ScoreTimePanel.scoreTimePanelHeight + BoardButtonsPanel.boardPanelHeight + (3*marginY);
    ScoreTimePanel scoreTimePanel;
    BoardButtonsPanel boardButtonsPanel;
    BoardLabelPanel boardLabelPanel;

    MainPanel() {
        scoreTimePanel = new ScoreTimePanel();
        boardLabelPanel = new BoardLabelPanel();

        boardButtonsPanel = new BoardButtonsPanel();

        setBounds(0, 30, mainPanelWidth, mainPanelHeight);
        setOpaque(true);
        setBackground(new Color(190, 190, 190));
        //setBackground(Color.RED);
        setLayout(null);

        add(scoreTimePanel, JLayeredPane.DEFAULT_LAYER);
        add(boardButtonsPanel, JLayeredPane.PALETTE_LAYER);
        add(boardLabelPanel, JLayeredPane.DEFAULT_LAYER);

    }
}
