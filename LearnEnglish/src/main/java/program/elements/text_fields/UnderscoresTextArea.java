package program.elements.text_fields;

import program.Main;
import program.elements.panels.MainPanel;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

import static program.Main.correctAns;
import static program.Main.memoBox;


public class UnderscoresTextArea extends JTextArea {

    final int WIDTH = 450;
    final int HEIGHT = 100;
    final int X = (MainPanel.WIDTH - WIDTH)/2;
    final int Y = 345;
    String[] word = memoBox.getCurrentWord();

    public UnderscoresTextArea() {
        setBackground(null);
        setOpaque(false);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setBounds(X, Y, WIDTH, HEIGHT);
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
        setForeground(MyColor.BLACK);
        setUnderscores(word);

    }

    public void setUnderscores(String[] word) {
        String englishWord = word[7];
        StringBuilder undersc = new StringBuilder();
        correctAns = new StringBuilder();

        for (int i = 0; i < englishWord.length(); i++) {
            String sign = Character.toString(englishWord.charAt(i));
            if (sign.matches("\\w")) {
                undersc.append("_").append("\u00A0");
                correctAns.append(sign).append("\u00A0");
            } else if (sign.matches("\\s+")) {
                undersc.append("  ");
                correctAns.append("  ");
            } else {
                undersc.append(sign);
                correctAns.append(sign);
            }
        }

        setText(String.valueOf(undersc));
    }
}
