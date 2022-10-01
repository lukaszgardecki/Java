package game;

import javax.swing.*;
import java.awt.*;

public class ScoreTimePanel extends JPanel {

    private int scoreTimePanelWidth = 400;
    private int scoreTimePanelHeight = 100;


    ScoreTimePanel() {

        setBounds(0, 0, scoreTimePanelWidth, scoreTimePanelHeight);
        setBackground(Color.orange);

    }
}
