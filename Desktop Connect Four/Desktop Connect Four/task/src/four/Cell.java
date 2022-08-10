package four;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import static four.Board.BOARD_HEIGHT;
import static four.Board.BOARD_WIDTH;
import static four.ConnectFour.COLS;
import static four.ConnectFour.ROWS;

public class Cell extends JButton implements ActionListener {
    private static final Font FONT = new Font("Courier", Font.BOLD, 40);
    static final Color WIN_COLOR = Color.CYAN;
    static final Color DEFAULT_COLOR = Color.GRAY;
    private static String currentSign = "X";
    static Map<String, Cell> map = new LinkedHashMap<>();

    public Cell (String label) {
        //super(label);
        setActionCommand("clicked");
        addActionListener(this);
        setName("Button" + label);
        setText(" ");
        setFont(FONT);
        setFocusPainted(false);
        setBackground(DEFAULT_COLOR);
        setSize(BOARD_WIDTH/COLS,BOARD_HEIGHT/ROWS);
        setBorder(new LineBorder(Color.LIGHT_GRAY));
        //setVisible(false);

    }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String a = actionEvent.getActionCommand();
        if (a.equals("clicked")) {

            if (isFull()) clearBoard();

            String column = getName().substring(6,7); // -> num of column

            for (int i = 1; i <= 6; i++) {
                Cell cellInCol = map.get(column+i);
                String text = cellInCol.getText();
                if (text.equals(" ")) {
                    cellInCol.setText(currentSign);
                    if(isWinner()) blockCells();

                    if (currentSign.equals("X")) {
                        setCurrentSign("O");
                    } else {
                        setCurrentSign("X");
                    }
                    break;
                }
            }
        }
    }

    public static void setCurrentSign(String currentSign) {
        Cell.currentSign = currentSign;
    }

    public static void clearBoard() {
        for (int i = ROWS; i >= 1; i--) {
            for (int j = 'A'; j < 'A' + COLS; j++) {
                Cell eachCell = map.get(Character.toString(j)+i);
                eachCell.setText(" ");
                eachCell.setBackground(DEFAULT_COLOR);
                eachCell.setEnabled(true);
            }
        }
    }
    public static boolean isFull() {
        boolean isFullGrid = true;
        for (int i = ROWS; i >= 1; i--) {
            for (int j = 'A'; j < 'A' + COLS; j++) {
                Cell eachCell = map.get(Character.toString(j)+i);
                String text = eachCell.getText();
                if (text.equals(" ")) {
                    isFullGrid = false;
                    break;
                }
            }
        }
        return isFullGrid;
    }

    public static boolean isWinner() {
        boolean w1 = false;
        boolean w2 = false;
        boolean w3 = false;

        for (int i = 1; i <= ROWS-3; i++) {
            for (int j = 'A'; j < 'A' + COLS; j++) {
                Cell c1 = map.get(Character.toString(j)+i);
                Cell c2 = map.get(Character.toString(j)+(i+1));
                Cell c3 = map.get(Character.toString(j)+(i+2));
                Cell c4 = map.get(Character.toString(j)+(i+3));
                String text = c1.getText() + c2.getText() + c3.getText() + c4.getText();
                if (text.equals("XXXX") || text.equals("OOOO")) {
                    w1 = true;
                    c1.setBackground(WIN_COLOR);
                    c2.setBackground(WIN_COLOR);
                    c3.setBackground(WIN_COLOR);
                    c4.setBackground(WIN_COLOR);
                }
            }
        }
        for (int j = 'A'; j < 'A' + COLS-3; j++) {
            for (int i = 1; i <= ROWS; i++) {
                Cell c1 = map.get(Character.toString(j)+i);
                Cell c2 = map.get(Character.toString(j+1)+i);
                Cell c3 = map.get(Character.toString(j+2)+i);
                Cell c4 = map.get(Character.toString(j+3)+i);
                String text = c1.getText() + c2.getText() + c3.getText() + c4.getText();
                if (text.equals("XXXX") || text.equals("OOOO")) {
                    w2 = true;
                    c1.setBackground(WIN_COLOR);
                    c2.setBackground(WIN_COLOR);
                    c3.setBackground(WIN_COLOR);
                    c4.setBackground(WIN_COLOR);
                }
            }
        }
        for (int i = 1; i <= ROWS-3; i++) {
            for (int j = 'A'; j < 'A' + COLS-3; j++) {
                Cell c1 = map.get(Character.toString(j)+i);
                Cell c2 = map.get(Character.toString(j+1)+(i+1));
                Cell c3 = map.get(Character.toString(j+2)+(i+2));
                Cell c4 = map.get(Character.toString(j+3)+(i+3));
                String text = c1.getText() + c2.getText() + c3.getText() + c4.getText();
                if (text.equals("XXXX") || text.equals("OOOO")) {
                    w3 = true;
                    c1.setBackground(WIN_COLOR);
                    c2.setBackground(WIN_COLOR);
                    c3.setBackground(WIN_COLOR);
                    c4.setBackground(WIN_COLOR);
                }
            }
        }
        for (int i = ROWS; i >= 4; i--) {
            for (int j = 'A'; j < 'A' + COLS-3; j++) {
                Cell c1 = map.get(Character.toString(j)+i);
                Cell c2 = map.get(Character.toString(j+1)+(i-1));
                Cell c3 = map.get(Character.toString(j+2)+(i-2));
                Cell c4 = map.get(Character.toString(j+3)+(i-3));
                String text = c1.getText() + c2.getText() + c3.getText() + c4.getText();
                if (text.equals("XXXX") || text.equals("OOOO")) {
                    w3 = true;
                    c1.setBackground(WIN_COLOR);
                    c2.setBackground(WIN_COLOR);
                    c3.setBackground(WIN_COLOR);
                    c4.setBackground(WIN_COLOR);
                }
            }
        }
        return w1 || w2 || w3;
    }

    public static void blockCells() {
        for (int i = ROWS; i >= 1; i--) {
            for (int j = 'A'; j < 'A' + COLS; j++) {
                Cell eachCell = map.get(Character.toString(j)+i);
                eachCell.setEnabled(false);
            }
        }
    }


}
