package game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BoardLabelPanel extends JPanel {

    private static int boardSizeX = Main.game.getGameWidth();
    private static int boardSizeY = Main.game.getGameHeight();
    static FieldLabel[][] labels;
    static Random random = new Random();

    static int boardPanelWidth = boardSizeX * FieldButton.fieldWidth;
    static int boardPanelHeight = boardSizeY * FieldButton.fieldHeight;

    private int x = MainPanel.getMarginX();
    private int y = ScoreTimePanel.getScoreTimePanelHeight() + 2 * MainPanel.getMarginY();

    BoardLabelPanel() {
        setBounds(x, y, boardPanelWidth, boardPanelHeight);
        setOpaque(false);
        setLayout(new GridLayout(boardSizeY, boardSizeX, 2, 2));

        fillBoard();
        insertBombs(Main.game.getBombs());
    }

    void fillBoard() {
        labels = new FieldLabel[Main.game.getGameHeight()][Main.game.getGameWidth()];

        for (int row = 0; row < Main.game.getGameHeight(); row++) {
            for (int col = 0; col < Main.game.getGameWidth(); col++) {
                FieldLabel fieldLabel = new FieldLabel();
                fieldLabel.setRow(row);
                fieldLabel.setCol(col);
                labels[row][col] = fieldLabel;
                add(fieldLabel);
            }
        }
    }

    static void insertBombs(int numOfBombs) {
        int maxAmountOfBombs = Main.game.getGameWidth() * Main.game.getGameHeight();
        if(numOfBombs > maxAmountOfBombs) numOfBombs = maxAmountOfBombs;

        for (int i = 0; i < numOfBombs; i++) {
            int bombX;
            int bombY;

            do {
                bombX = random.nextInt(Main.game.getGameHeight());
                bombY = random.nextInt(Main.game.getGameWidth());
            } while (labels[bombX][bombY].hasBomb);

            labels[bombX][bombY].setBomb();
            setNumbers(bombX, bombY);
        }
    }

    private static void setNumbers(int bombX, int bombY) {
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

    static void setFontColor(JLabel label, int num) {
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

    void refresh() {
        changeSize();
        setNewBoard();
    }

    void changeSize() {
        MainPanel.boardLabelPanel.setBounds(MainPanel.getMarginX(),
                ScoreTimePanel.getScoreTimePanelHeight() + 2 * MainPanel.getMarginY(),
                Main.game.getGameWidth() * FieldButton.fieldWidth,
                Main.game.getGameHeight() * FieldButton.fieldHeight);

        MainPanel.boardLabelPanel.setLayout(new GridLayout(
                Main.game.getGameHeight(),
                Main.game.getGameWidth(),
                2,
                2));
    }

    void setNewBoard() {
        MainPanel.boardLabelPanel.removeAll();
        MainPanel.boardLabelPanel.fillBoard();
        BoardLabelPanel.insertBombs(Main.game.getBombs());
    }

    /*private*/static void displayBoardInConsole() {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {

//                if (labels[i][j].hasBomb) {
//                    System.out.print("B ");
//                    continue;
//                }
//                if (labels[i][j].getText().equals("")) {
//                    System.out.print("_ ");
//                    continue;
//                }

                if (labels[i][j].isVisible()) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }

                //System.out.print(labels[i][j].getText()+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
