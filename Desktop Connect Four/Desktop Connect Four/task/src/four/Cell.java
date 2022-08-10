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
        setBackground(Color.GRAY);
        setSize(BOARD_WIDTH/COLS,BOARD_HEIGHT/ROWS);
        setBorder(new LineBorder(Color.DARK_GRAY));
        setVisible(false);

    }

    public static void setCurrentSign(String currentSign) {
        Cell.currentSign = currentSign;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String a = actionEvent.getActionCommand();
        if (a.equals("clicked")) {

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

            //clear the board if is full
            if (isFullGrid) {
                for (int i = ROWS; i >= 1; i--) {
                    for (int j = 'A'; j < 'A' + COLS; j++) {
                        Cell eachCell = map.get(Character.toString(j)+i);
                        eachCell.setText(" ");
                    }
                }
            }



            String column = getName().substring(6,7); // -> num of column

            for (int i = 1; i <= 6; i++) {
                Cell cellInCol = map.get(column+i);
                String text = cellInCol.getText();
                if (text.equals(" ")) {
                    cellInCol.setText(currentSign);
                    break;
                }
            }

            if (currentSign.equals("X")) {
                setCurrentSign("O");
            } else {
                setCurrentSign("X");
            }


        }
    }


}
