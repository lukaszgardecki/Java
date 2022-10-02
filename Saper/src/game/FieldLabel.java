package game;

import javax.swing.*;
import java.awt.*;

public class FieldLabel extends JLabel {

    static int fieldWidth = 40;
    static int fieldHeight = 40;
    boolean hasBomb = false;
    int surroundingBombs = 0;
    ImageIcon bombIcon = new ImageIcon("src/game/bomb.png");

    FieldLabel() {
        setSize(fieldWidth, fieldHeight);
        setBorder(BorderFactory.createLineBorder(new Color(129, 129, 129), 1));
        setHorizontalAlignment(CENTER);
        setFont(new Font("Courier", Font.BOLD, 22));
        setOpaque(true);
        setBackground(Color.white);


    }

    public void setBomb() {
        this.hasBomb = true;
        setIcon(bombIcon);
    }

    public void addOneBomb() {
        this.surroundingBombs++;
    }

    public int getSurroundingBombs() {
        return surroundingBombs;
    }

}
