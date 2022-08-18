package calculator;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    public static final int CALC_WIDTH = 366;
    public static final int CALC_HEIGHT = 650;
    public static final Color backgroundColor = new Color(210, 210, 210);

    public Calculator() {
        super("Calculator");

        ResultPanel resultPanel = new ResultPanel();
        add(resultPanel);

        KeyPanel keyPanel = new KeyPanel();
        add(keyPanel);

        setSize(CALC_WIDTH, CALC_HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(backgroundColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
