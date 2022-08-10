package four;

import javax.swing.*;
import java.awt.*;
import static four.Board.BOARD_WIDTH;

public class Feet extends JPanel {
    static final int FEET_WIDTH = BOARD_WIDTH;
    static final int FEET_HEIGHT = 100;

    public Feet() {
        setBounds(0, FEET_WIDTH, FEET_WIDTH, FEET_HEIGHT);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
    }
}
