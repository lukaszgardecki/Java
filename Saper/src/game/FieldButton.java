package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FieldButton extends JButton implements MouseListener {

    static int fieldWidth = 40;
    static int fieldHeight = 40;
    static ImageIcon flag = new ImageIcon("src/game/flag.png");
    ImageIcon questionMark = new ImageIcon("src/game/question-mark.png");

    FieldButton() {
        setSize(fieldWidth, fieldHeight);
        setBackground(new Color(123, 210, 253));
        addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            if (questionMark.equals(this.getIcon())) {
                this.setIcon(null);
            } else if (flag.equals(this.getIcon())) {
                this.setIcon(questionMark);
                ScoreTimePanel.bombCounter.setText(String.valueOf(++ScoreTimePanel.remainingBombs));
            } else if (ScoreTimePanel.remainingBombs > 0) {
                this.setIcon(flag);
                ScoreTimePanel.bombCounter.setText(String.valueOf(--ScoreTimePanel.remainingBombs));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
