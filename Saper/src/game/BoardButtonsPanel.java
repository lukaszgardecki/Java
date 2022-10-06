package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.BoardLabelPanel.labels;

public class BoardButtonsPanel extends JPanel implements ActionListener {

    private static int boardSizeX = Main.game.getGameWidth();
    private static int boardSizeY = Main.game.getGameHeight();
    static int amountOfAllFields = boardSizeX * boardSizeY;
    static int amountOfDiscoveredFields = 0;
    private static FieldButton[][] buttons;

    static int boardPanelWidth = boardSizeX * FieldButton.fieldWidth;
    static int boardPanelHeight = boardSizeY * FieldButton.fieldHeight;

    private int x = MainPanel.getMarginX();
    private int y = ScoreTimePanel.getScoreTimePanelHeight() + 2 * MainPanel.getMarginY();

    BoardButtonsPanel() {
        setBounds(x, y, boardPanelWidth, boardPanelHeight);
        setOpaque(false);
        setLayout(new GridLayout(boardSizeY, boardSizeX, 2, 2));

        fillBoard();
    }

    void fillBoard() {
        buttons = new FieldButton[Main.game.getGameHeight()][Main.game.getGameWidth()];

        for (int row = 0; row < Main.game.getGameHeight(); row++) {
            for (int col = 0; col < Main.game.getGameWidth(); col++) {
                FieldButton fieldButton = new FieldButton();
                fieldButton.addActionListener(this);
                fieldButton.setActionCommand("" + row + "." + col);

                buttons[row][col] = fieldButton;
                add(fieldButton);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        int row = Integer.parseInt(cmd.substring(0, cmd.indexOf(".")));
        int col = Integer.parseInt(cmd.substring(cmd.indexOf(".")+1));
        FieldLabel fieldLabel = labels[row][col];
        boolean isEmptyField = fieldLabel.getText().equals("") && !fieldLabel.hasBomb;
        boolean isBombExploded = checkIsBomb(row, col);

        if (isFirstFieldInBoard()) ScoreTimePanel.startTimer();

        discoverField(row, col);

        if (isBombExploded) {
            ScoreTimePanel.resetBtn.setIcon(ScoreTimePanel.dead);
            Game.endGame();
            fieldLabel.setBackground(Color.RED);
        }

        if (isEmptyField) displaySurroundingField(row, col);

        if (areAllFieldsDiscovered()) {
            ScoreTimePanel.resetBtn.setIcon(ScoreTimePanel.cool);
            Game.winGame();
        }
    }

    static boolean areAllFieldsDiscovered() {
        return amountOfAllFields - amountOfDiscoveredFields == Main.game.getBombs();
    }

    private boolean isFirstFieldInBoard() {
        boolean areAllFieldsCovered = true;

        loop:
        for (FieldButton[] button : buttons) {
            for (FieldButton fieldButton : button) {
                if (!fieldButton.isVisible()) {
                    areAllFieldsCovered = false;
                    break loop;
                }
            }
        }
        return areAllFieldsCovered;
    }

    static int getNumOfFlags(int row, int col) {
        int startX = row - 1;
        int startY = col - 1;
        int numOfFlags = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextX = startX + i;
                int nextY = startY + j;

                try {
                    FieldButton button = buttons[nextX][nextY];

                    if (button.getIcon() == FieldButton.flag) {
                        numOfFlags++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return numOfFlags;
    }

    static void displaySurroundingField(int row, int col) {
        int startX = row - 1;
        int startY = col - 1;
        boolean isDiscoveredBombField = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextX = startX + i;
                int nextY = startY + j;

                try {
                    FieldLabel field = labels[nextX][nextY];
                    FieldButton button = buttons[nextX][nextY];

                    if (field.isVisible()) continue;
                    if(button.getIcon() == FieldButton.flag && field.hasBomb) continue;

                    if (button.getIcon() == FieldButton.flag) {
                        button.setBackground(Color.white);
                        button.setOpaque(true);
                        button.setIcon(FieldButton.xSign);
                        continue;
                    }

                    discoverField(nextX, nextY);

                   if (field.hasBomb) {
                       field.setBackground(Color.red);
                        isDiscoveredBombField = true;
                        continue;
                    }

                   if (field.getText().equals("")) {
                        displaySurroundingField(nextX, nextY);
                   }

                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }

        if (isDiscoveredBombField) {
            ScoreTimePanel.resetBtn.setIcon(ScoreTimePanel.dead);
            Game.endGame();
        }
    }

    private static void discoverField(int row, int col) {
        buttons[row][col].setVisible(false);
        labels[row][col].setVisible(true);
        amountOfDiscoveredFields++;
    }

    private boolean checkIsBomb(int row, int col) {
        return labels[row][col].hasBomb;
    }

    static void showAllUnflaggedBombs() {
        for (int row = 0; row < Main.game.getGameHeight(); row++) {
            for (int col = 0; col < Main.game.getGameWidth(); col++) {
                FieldButton fieldButton = buttons[row][col];
                FieldLabel fieldLabel = labels[row][col];
                boolean hasFieldFlag = fieldButton.getIcon() == FieldButton.flag;

                if (fieldLabel.hasBomb && !hasFieldFlag) {
                    fieldButton.setVisible(false);
                    fieldLabel.setVisible(true);

                    if (fieldLabel.getBackground() == Color.red) continue;
                    fieldLabel.setBackground(new Color(123, 210, 253));
                }
            }
        }
    }

    static void blockAllFields() {
        for (int row = 0; row < Main.game.getGameHeight(); row++) {
            for (int col = 0; col < Main.game.getGameWidth(); col++) {
                FieldButton fieldButton = buttons[row][col];
                FieldLabel fieldLabel = labels[row][col];

                fieldButton.removeMouseListener(fieldButton.getMouseListeners()[0]);
                fieldButton.removeMouseListener(fieldButton.getMouseListeners()[0]);
                fieldLabel.removeMouseListener(fieldLabel.getMouseListeners()[0]);
            }
        }
    }

    void refresh() {
        changeSize();
        setNewBoard();
    }

    void setNewBoard() {
        createNewBoard();
        resetAmountOfDiscoveredFields();
        setAmountOfAllFields();
    }

    void changeSize() {
        MainPanel.boardButtonsPanel.setBounds(MainPanel.getMarginX(),
                ScoreTimePanel.getScoreTimePanelHeight() + 2 * MainPanel.getMarginY(),
                Main.game.getGameWidth() * FieldButton.fieldWidth,
                Main.game.getGameHeight() * FieldButton.fieldHeight);
        MainPanel.boardButtonsPanel.setLayout(new GridLayout(
                Main.game.getGameHeight(),
                Main.game.getGameWidth(),
                2,
                2));
    }

    private void createNewBoard() {
        MainPanel.boardButtonsPanel.removeAll();
        MainPanel.boardButtonsPanel.fillBoard();
    }

    private void resetAmountOfDiscoveredFields() {
        amountOfDiscoveredFields = 0;
    }

    private void setAmountOfAllFields() {
        amountOfAllFields = Main.game.getGameWidth() * Main.game.getGameHeight();
    }
}
