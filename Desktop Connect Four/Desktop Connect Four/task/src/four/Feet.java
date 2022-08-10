package four;

import javax.swing.*;
import java.awt.*;

import static four.Board.BOARD_WIDTH;

public class Feet extends JPanel {

    static final int FEET_WIDTH = BOARD_WIDTH;
    static final int FEET_HEIGHT = 100;



    public Feet() {
        setBounds(20, 500, 200, FEET_HEIGHT);
        setBackground(Color.CYAN);
        //setVisible(false);

//        JButton reset = new JButton("Reset");
//        reset.setBounds(600, 600, 50, 20);
//        reset.setBackground(Color.BLUE);
//        add(reset);
//        setVisible(true);

    }
}
