package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    private static final int ROWS = 6;
    private static final int COLS = 7;


    public ConnectFour() {
        super("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(ROWS, COLS));

        for (int i = ROWS; i >= 1; i--) {
            for (int j = 'A'; j < 'A' + COLS; j++) {

                Cell.map.put(Character.toString(j) + i, (Cell) add(new Cell(Character.toString(j) + i)));
            }
        }

        setVisible(true);
    }
}