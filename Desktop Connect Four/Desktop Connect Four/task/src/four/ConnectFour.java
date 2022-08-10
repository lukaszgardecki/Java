package four;

import javax.swing.*;

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
        setLayout(null);
        setResizable(false);

        Board board = new Board();
        add(board);

        Feet feet = new Feet();
        add(feet);

        ButtonReset br = new ButtonReset();
        br.setText("Reset");
        feet.add(br);

        setVisible(true);
    }
}