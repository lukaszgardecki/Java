package calculator;

import javax.swing.*;

public class Calculator extends JFrame {
    public static final int CALC_WIDTH = 400;
    public static final int CALC_HEIGHT = 500;

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(CALC_WIDTH, CALC_HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        ResultPanel resultPanel = new ResultPanel();
        add(resultPanel);

        KeyPanel keyPanel = new KeyPanel();
        add(keyPanel);

        setVisible(true);
    }

}
