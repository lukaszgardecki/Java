package game;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class BoardPanel extends JPanel implements ActionListener {

    private static int boardSizeX = 10;
    private static int boardSizeY = 10;
    private Field[][] board = new Field[boardSizeX][boardSizeY];

    static int horizontalMargin = 10;
    static int verticalMargin = 10;

    static int boardPanelWidth = boardSizeX * Field.fieldWidth;
    static int boardPanelHeight = boardSizeY * Field.fieldHeight;

    private int x = horizontalMargin;
    private int y = ScoreTimePanel.scoreTimePanelHeight + 2 * verticalMargin;





    BoardPanel() {
        setBounds(x, y, boardPanelWidth, boardPanelHeight);
        setBackground(new Color(190, 190, 190));
        setBorder(new LineBorder(new Color(129, 129, 129), 2));
        setLayout(new GridLayout(boardSizeY, boardSizeX));

        fillBoard();
    }



    void fillBoard() {
        for (int rows = 0; rows < boardSizeX; rows++) {
            for (int cols = 0; cols < boardSizeY; cols++) {
                Field field = new Field();
                field.addActionListener(this);
                field.setActionCommand("" + rows + "." + cols);

                board[rows][cols] = field;
                add(field);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        int row = Integer.parseInt(cmd.substring(0, cmd.indexOf(".")));
        int col = Integer.parseInt(cmd.substring(cmd.indexOf(".")+1));

        hideField(row, col);
    }

    private void hideField(int row, int col) {
        board[row][col].setVisible(false);
    }
}
