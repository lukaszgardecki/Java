package game;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class ScoreTimePanel extends JPanel {

    int horizontalMargin = BoardButtonsPanel.horizontalMargin;
    int verticalMargin = BoardButtonsPanel.verticalMargin;

    int scoreTimePanelWidth = BoardButtonsPanel.boardPanelWidth;
    static int scoreTimePanelHeight = 50;

    BevelBorder myBorder = new BevelBorder(BevelBorder.LOWERED, Color.white, new Color(129, 129, 129));



    ScoreTimePanel() {

        setBounds(horizontalMargin, verticalMargin, scoreTimePanelWidth, scoreTimePanelHeight);
        setBackground(new Color(190, 190, 190));
        setBorder(BorderFactory.createCompoundBorder(myBorder, null));

    }
}
