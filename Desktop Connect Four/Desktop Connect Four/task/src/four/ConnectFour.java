package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    static final int ROWS = 6;
    static final int COLS = 7;
    static final int WIND_WIDTH = 715;
    static final int WIND_HEIGHT = 800;


    public ConnectFour() {
        super("Connect Four");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIND_WIDTH, WIND_HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(0,0));
        setResizable(false);

        Board board = new Board();
        add(board);

        Feet feet = new Feet();
        add(feet);



//        for (int i = ROWS; i >= 1; i--) {
//            for (int j = 'A'; j < 'A' + COLS; j++) {
//
//                Cell.map.put(Character.toString(j) + i, (Cell) add(new Cell(Character.toString(j) + i)));
//            }
//        }

        setVisible(true);
    }
}