package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardButtonsPanel extends JPanel implements ActionListener {

    private static int boardSizeX = 10;
    private static int boardSizeY = 10;
    private FieldButton[][] buttons = new FieldButton[boardSizeX][boardSizeY];

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
        for (int rows = 0; rows < boardSizeX; rows++) {
            for (int cols = 0; cols < boardSizeY; cols++) {
                FieldButton fieldButton = new FieldButton();
                fieldButton.addActionListener(this);
                fieldButton.setActionCommand("" + rows + "." + cols);

                buttons[rows][cols] = fieldButton;
                add(fieldButton);
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
        buttons[row][col].setVisible(false);
    }
}
