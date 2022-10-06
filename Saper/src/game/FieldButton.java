package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FieldButton extends JButton {
    static int fieldWidth = 40;
    static int fieldHeight = 40;
    static ImageIcon flag = new ImageIcon("src/game/images/flag.png");
    ImageIcon questionMark = new ImageIcon("src/game/images/question-mark.png");
    static ImageIcon xSign = new ImageIcon("src/game/images/x.png");

    FieldButton() {
        setSize(fieldWidth, fieldHeight);
        setBackground(new Color(123, 210, 253));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    if (questionMark.equals(getIcon())) {
                        setIcon(null);
                    } else if (flag.equals(getIcon())) {
                        setIcon(questionMark);
                        MainPanel.scoreTimePanel.bombCounter.setText(String.valueOf(++ScoreTimePanel.remainingBombs));
                    } else if (ScoreTimePanel.remainingBombs > 0) {
                        setIcon(flag);
                        MainPanel.scoreTimePanel.bombCounter.setText(String.valueOf(--ScoreTimePanel.remainingBombs));
                    }
                }
                ScoreTimePanel.resetBtn.setIcon(ScoreTimePanel.shocked);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(!Game.isFailure) ScoreTimePanel.resetBtn.setIcon(ScoreTimePanel.happy);
            }
        });
    }
}
