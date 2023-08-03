package program.elements.text_fields;

import program.Main;
import program.elements.panels.MainPanel;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class EnglishWordTextArea extends JTextArea {
    final int WIDTH = 450;
    final int HEIGHT = 180;
    final int X = (MainPanel.WIDTH - WIDTH)/2;
    final int Y = 130;
    final String[] word = Main.memoBox.getCurrentWord();
    final String polishWord = word[6];
    final String numOfGroup = word[1];


    public EnglishWordTextArea() {
        setText(polishWord);
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
        //setBounds(55, 30, 450, 130);
        setMyBorder(numOfGroup);

        setLineWrap(true);
        setWrapStyleWord(true);
        setEditable(false);
        //setBackground(null);
        setBackground(Color.WHITE);
        setForeground(MyColor.BLACK);
        setFont(new Font("Courier", Font.BOLD, 30));
    }


    public void setMyBorder(String num) {
        int numberOfGroup = Integer.parseInt(num);
        if (numberOfGroup == 0) this.setBorder(BorderFactory.createLineBorder(MyColor.BLUE1_DARK, 4));
        else if (numberOfGroup == 1) this.setBorder(BorderFactory.createLineBorder(MyColor.RED_DARK, 4));
        else if (numberOfGroup == 2) this.setBorder(BorderFactory.createLineBorder(MyColor.ORANGE1_DARK, 4));
        else if (numberOfGroup == 3) this.setBorder(BorderFactory.createLineBorder(MyColor.ORANGE2_DARK, 4));
        else if (numberOfGroup == 4) this.setBorder(BorderFactory.createLineBorder(MyColor.YELLOW_DARK, 4));
        else if (numberOfGroup == 5) this.setBorder(BorderFactory.createLineBorder(MyColor.GREEN_DARK, 4));
        else if (numberOfGroup == 6) this.setBorder(BorderFactory.createLineBorder(MyColor.GRAY, 4));
    }
}
