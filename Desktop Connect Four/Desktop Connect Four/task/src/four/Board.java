package four;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Board extends JPanel {
    static final int ROWS = 6;
    static final int COLS = 7;
    static final int BOARD_WIDTH = 700;
    static final int BOARD_HEIGHT = 700;

    public Board () {
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setLayout(new GridLayout(ROWS, COLS));
        setBorder(new LineBorder(Color.BLACK));

        for (int i = ROWS; i >= 1; i--) {
            for (int j = 'A'; j < 'A' + COLS; j++) {
                Cell.map.put(Character.toString(j) + i, (Cell) add(new Cell(Character.toString(j) + i)));
            }
        }
    }
}
