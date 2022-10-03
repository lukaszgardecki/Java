package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class BoardLabelPanel extends JPanel implements MouseListener {

    private static int boardSizeX = Game.GAME_BOARD_WIDTH;
    private static int boardSizeY = Game.GAME_BOARD_HEIGHT;
    private int numOfBombs = Game.BOMBS;
    static FieldLabel[][] labels = new FieldLabel[boardSizeY][boardSizeX];
    Random random = new Random();

    static int horizontalMargin = 10;
    static int verticalMargin = 10;

    static int boardPanelWidth = boardSizeX * FieldButton.fieldWidth;
    static int boardPanelHeight = boardSizeY * FieldButton.fieldHeight;

    private int x = horizontalMargin;
    private int y = ScoreTimePanel.scoreTimePanelHeight + 2 * verticalMargin;

    BoardLabelPanel() {
        setBounds(x, y, boardPanelWidth, boardPanelHeight);
        setOpaque(false);
        //setBorder(new LineBorder(new Color(129, 129, 129), 2));
        setLayout(new GridLayout(boardSizeY, boardSizeX, 2, 2));

        fillBoard();
        insertBombs(numOfBombs);


        displayBoardInConsole();

    }

    private void fillBoard() {
        for (int row = 0; row < boardSizeY; row++) {
            for (int col = 0; col < boardSizeX; col++) {
                FieldLabel fieldLabel = new FieldLabel();
                labels[row][col] = fieldLabel;
                add(fieldLabel);
            }
        }
    }

    private void insertBombs(int numOfBombs) {
        int maxAmountOfBombs = boardSizeX * boardSizeY;
        if(numOfBombs > maxAmountOfBombs) numOfBombs = maxAmountOfBombs;

        for (int i = 0; i < numOfBombs; i++) {
            int bombX;
            int bombY;

            do {
                bombX = random.nextInt(boardSizeY);
                bombY = random.nextInt(boardSizeX);
            } while (labels[bombX][bombY].hasBomb);

            labels[bombX][bombY].setBomb();
            setNumbers(bombX, bombY);
        }
    }

    private void setNumbers(int bombX, int bombY) {
        int startX = bombX - 1;
        int startY = bombY - 1;
        labels[bombX][bombY].setText("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextX = startX+i;
                int nextY = startY+j;

                try {
                    FieldLabel field = labels[nextX][nextY];
                    if (nextX == bombX && nextY == bombY) continue;
                    if (labels[nextX][nextY].hasBomb) continue;
                    field.addOneBomb();
                    field.setText("" + field.getSurroundingBombs());
                    setFontColor(field, field.getSurroundingBombs());
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    private void setFontColor(JLabel label, int num) {
        switch (num) {
            case 1 -> label.setForeground(new Color(25, 187, 223));
            case 2 -> label.setForeground(new Color(112, 147, 25));
            case 3 -> label.setForeground(new Color(217, 26, 101));
            case 4 -> label.setForeground(new Color(32, 93, 203));
            case 5 -> label.setForeground(new Color(186, 41, 41));
            case 6 -> label.setForeground(new Color(26, 141, 55));
            case 7 -> label.setForeground(new Color(120, 25, 120));
            case 8 -> label.setForeground(new Color(249, 103, 30));
        }
    }

    private void displayBoardInConsole() {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {

                if (labels[i][j].hasBomb) {
                    System.out.print("B ");
                    continue;
                }
                if (labels[i][j].getText().equals("")) {
                    System.out.print("_ ");
                    continue;
                }
                System.out.print(labels[i][j].getText()+ " ");
            }
            System.out.println();
        }
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
