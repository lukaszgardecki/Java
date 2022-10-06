package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import static game.BoardButtonsPanel.getNumOfFlags;
import static game.BoardLabelPanel.labels;

public class FieldLabel extends JLabel {
    static int fieldWidth = 40;
    static int fieldHeight = 40;
    boolean hasBomb = false;
    int surroundingBombs = 0;
    int row = 0;
    int col = 0;
    static ImageIcon bombIcon = new ImageIcon("src/game/bomb.png");

    FieldLabel() {
        setSize(fieldWidth, fieldHeight);
        setBorder(BorderFactory.createLineBorder(new Color(129, 129, 129), 1));
        setHorizontalAlignment(CENTER);
        setFont(new Font("Courier", Font.BOLD, 22));
        setOpaque(true);
        setBackground(Color.white);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = getRow();
                int col = getCol();

                String labelText = labels[row][col].getText();
                int numOfSurroundingBombs = !Objects.equals(labelText, "") ? Integer.parseInt(labelText) : 0;
                int numOfFlags = getNumOfFlags(row, col);
                boolean numOfFlagsIsOK = numOfSurroundingBombs == numOfFlags;
                boolean arePressedBothBtns = e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK + MouseEvent.BUTTON1_DOWN_MASK;
                boolean isPressedWheel = e.getButton() == MouseEvent.BUTTON2;

                if (numOfFlagsIsOK && (arePressedBothBtns || isPressedWheel)) {
                    BoardButtonsPanel.displaySurroundingField(row, col);
                }

                if (BoardButtonsPanel.areAllFieldsDiscovered()) Game.winGame();
            }
        });
        setVisible(false);
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

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public static int getFieldWidth() {
        return fieldWidth;
    }

    public static int getFieldHeight() {
        return fieldHeight;
    }
}
