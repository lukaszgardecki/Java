package game;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    static int marginX = 10;
    static int marginY = 10;

    static int mainPanelWidth = BoardPanel.boardPanelWidth + (2 * marginX);
    static int mainPanelHeight = ScoreTimePanel.scoreTimePanelHeight + BoardPanel.boardPanelHeight + (3*marginY);
    ScoreTimePanel scoreTimePanel;
    BoardPanel boardPanel;

    MainPanel() {

        boardPanel = new BoardPanel();
        scoreTimePanel = new ScoreTimePanel();

        setBounds(0, 30, mainPanelWidth, mainPanelHeight);
        //setBackground(new Color(190, 190, 190));
        setBackground(Color.RED);
        setLayout(null);

        add(scoreTimePanel);
        add(boardPanel);
    }
}
