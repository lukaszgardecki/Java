package program.settings;

import program.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static program.elements.panels.views.MainView.*;
import static program.elements.panels.views.MainView.inputTextF;

public class KeyPress implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isAnswerWrong) {
                wordLabel.setForeground(MyColor.BLACK);
                wordLabel.setText(Main.loadWord().get(4));
                correctAnswer.setText("");
                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
                isAnswerWrong = false;
            } else {
                check.doClick();
            }

            if (!isAnswerWrong) {
                wordLabel.setText(Main.loadWord().get(4));
                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            inputTextF.setText("");
            inputTextF.setForeground(Color.BLACK);
        }
    }
}
