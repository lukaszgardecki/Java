//package game;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import static game.BoardLabelPanel.labels;
//
//public class BoardButtonsPanel extends JPanel implements ActionListener {
//
//    private static int boardSizeX = Main.game.getGameWidth();
//    private static int boardSizeY = Main.game.getGameHeight();
//    private static FieldButton[][] buttons;
//
//    static int horizontalMargin = 10;
//    static int verticalMargin = 10;
//
//    static int boardPanelWidth = boardSizeX * FieldButton.fieldWidth;
//    static int boardPanelHeight = boardSizeY * FieldButton.fieldHeight;
//
//    private int x = horizontalMargin;
//    private int y = ScoreTimePanel.getScoreTimePanelHeight() + 2 * verticalMargin;
//
//    BoardButtonsPanel() {
//        setBounds(x, y, boardPanelWidth, boardPanelHeight);
//        setOpaque(false);
//        setLayout(new GridLayout(boardSizeY, boardSizeX, 2, 2));
//
//        fillBoard();
//    }
//
//    void fillBoard() {
//        buttons = new FieldButton[boardSizeY][boardSizeX];
//
//        for (int row = 0; row < boardSizeY; row++) {
//            for (int col = 0; col < boardSizeX; col++) {
//                FieldButton fieldButton = new FieldButton();
//                fieldButton.addActionListener(this);
//                fieldButton.setActionCommand("" + row + "." + col);
//
//
//                buttons[row][col] = fieldButton;
//                add(fieldButton);
//            }
//        }
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        String cmd = e.getActionCommand();
//        int row = Integer.parseInt(cmd.substring(0, cmd.indexOf(".")));
//        int col = Integer.parseInt(cmd.substring(cmd.indexOf(".")+1));
//        FieldLabel fieldLabel = labels[row][col];
//        boolean isEmptyField = fieldLabel.getText().equals("") && !fieldLabel.hasBomb;
//        boolean isBombExploded = checkIsBomb(row, col);
//
//        if (isFirstFieldInBoard()) ScoreTimePanel.startTimer();
//
//        discoverField(row, col);
//
//        if (isBombExploded) {
//            fieldLabel.setBackground(Color.RED);
//            Game.endGame();
//        }
//
//        if (isEmptyField) displaySurroundingField(row, col);
//
//
//    }
//
//    private boolean isFirstFieldInBoard() {
//        boolean areAllFieldsCovered = true;
//
//        loop:
//        for (FieldButton[] button : buttons) {
//            for (FieldButton fieldButton : button) {
//                if (!fieldButton.isVisible()) {
//                    areAllFieldsCovered = false;
//                    break loop;
//                }
//            }
//        }
//        return areAllFieldsCovered;
//    }
//
//    static int getNumOfFlags(int row, int col) {
//        int startX = row - 1;
//        int startY = col - 1;
//        int numOfFlags = 0;
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                int nextX = startX + i;
//                int nextY = startY + j;
//
//                try {
//                    FieldButton button = buttons[nextX][nextY];
//
//                    if (button.getIcon() == FieldButton.flag) {
//                        numOfFlags++;
//                    }
//                } catch (ArrayIndexOutOfBoundsException ignored) {
//                }
//            }
//        }
//        return numOfFlags;
//    }
//
//
//    static void displaySurroundingField(int row, int col) {
//        int startX = row - 1;
//        int startY = col - 1;
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                int nextX = startX + i;
//                int nextY = startY + j;
//
//                try {
//                    FieldLabel field = labels[nextX][nextY];
//                    FieldButton button = buttons[nextX][nextY];
//
//                    if (field.isVisible()) continue;
//                    if (button.getIcon() == FieldButton.flag) continue;
//
//                    discoverField(nextX, nextY);
//
//                    if (field.hasBomb) Game.endGame();
//
//                    if (field.getText().equals("")) {
//                        displaySurroundingField(nextX, nextY);
//                    }
//                } catch (ArrayIndexOutOfBoundsException ignored) {
//                }
//            }
//        }
//    }
//
//    private static void discoverField(int row, int col) {
//        buttons[row][col].setVisible(false);
//        labels[row][col].setVisible(true);
//    }
//
//    private boolean checkIsBomb(int row, int col) {
//        return labels[row][col].hasBomb;
//    }
//
//    static void showAllUnflaggedBombs() {
//        for (int row = 0; row < boardSizeY; row++) {
//            for (int col = 0; col < boardSizeX; col++) {
//                FieldButton fieldButton = buttons[row][col];
//                FieldLabel fieldLabel = labels[row][col];
//                boolean hasFieldFlag = fieldButton.getIcon() == FieldButton.flag;
//
//                if (fieldLabel.hasBomb && !hasFieldFlag) {
//                    fieldButton.setVisible(false);
//                    fieldLabel.setVisible(true);
//                    fieldLabel.setBackground(Color.RED);
//                }
//            }
//        }
//    }
//
//    static void blockAllFields() {
//        for (int row = 0; row < boardSizeY; row++) {
//            for (int col = 0; col < boardSizeX; col++) {
//                FieldButton fieldButton = buttons[row][col];
//                FieldLabel fieldLabel = labels[row][col];
//
//                fieldButton.removeMouseListener(fieldButton);
//                fieldButton.setEnabled(false);
//                fieldLabel.removeMouseListener(fieldLabel);
//            }
//        }
//    }
//
//    public void setBoardPanelWidth(int width) {
//        boardPanelWidth = width;
//    }
//
//    public void setBoardPanelHeight(int height) {
//        boardPanelHeight = height;
//    }
//
//    public static void setBoardSizeX(int width) {
//        boardSizeX = width;
//    }
//
//    public static void setBoardSizeY(int height) {
//        boardSizeY = height;
//    }
//
//
//}
