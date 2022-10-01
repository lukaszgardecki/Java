package game;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private int mainPanelWidth = 400;
    private int mainPanelHeight = 400;
    ScoreTimePanel scoreTimePanel;
    BoardPanel boardPanel;

    MainPanel() {

        scoreTimePanel = new ScoreTimePanel();

        setBounds(0, 50, mainPanelWidth, mainPanelHeight);
        setBackground(Color.BLUE);
        setLayout(null);

        add(scoreTimePanel);
        //add(boardPanel);
    }
}
