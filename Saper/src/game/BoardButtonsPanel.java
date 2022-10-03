package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static game.BoardLabelPanel.labels;

public class BoardButtonsPanel extends JPanel implements ActionListener {

    private static int boardSizeX = Game.GAME_BOARD_WIDTH;
    private static int boardSizeY = Game.GAME_BOARD_HEIGHT;
    private FieldButton[][] buttons = new FieldButton[boardSizeY][boardSizeX];

    static int horizontalMargin = 10;
    static int verticalMargin = 10;

    static int boardPanelWidth = boardSizeX * FieldButton.fieldWidth;
    static int boardPanelHeight = boardSizeY * FieldButton.fieldHeight;

    private int x = horizontalMargin;
    private int y = ScoreTimePanel.scoreTimePanelHeight + 2 * verticalMargin;


    BoardButtonsPanel() {
        setBounds(x, y, boardPanelWidth, boardPanelHeight);
        //setBackground(new Color(190, 190, 190));
        setOpaque(false);
        //setBorder(new LineBorder(new Color(129, 129, 129), 2));
        setLayout(new GridLayout(boardSizeY, boardSizeX, 2, 2));

        fillBoard();
    }



    void fillBoard() {
        for (int row = 0; row < boardSizeY; row++) {
            for (int col = 0; col < boardSizeX; col++) {
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
        //System.out.println(labels[row][col].getText());

        hideField(row, col);

        if (checkIsBomb(row, col)) {
            System.out.println("BOMBAAAAAA!!!!!!!!!!!");
        }
    }

    private void hideField(int row, int col) {
        buttons[row][col].setVisible(false);
    }

    private boolean checkIsBomb(int row, int col) {
        return labels[row][col].hasBomb;
    }
}
