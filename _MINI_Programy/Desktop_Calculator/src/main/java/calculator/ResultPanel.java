package calculator;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.RIGHT;

public class ResultPanel extends JPanel {
    public static JLabel resultLabel;
    public static JLabel equationLabel;

    public ResultPanel() {
        setBounds(5, 0, 341, 175);
        setBackground(Calculator.backgroundColor);
        setLayout(null);

        resultLabel = new JLabel();
        resultLabel.setBounds(10, 0, 321, 80);
        resultLabel.setText("0");
        resultLabel.setName("ResultLabel");
        //resultLabel.setBackground(Calculator.backgroundColor);
        resultLabel.setHorizontalAlignment(RIGHT);
        resultLabel.setFont(new Font("Courier", Font.BOLD, 50));
        add(resultLabel);

        equationLabel = new JLabel();
        equationLabel.setBounds(10, 90, 321, 35);
        equationLabel.setName("EquationLabel");
        //equationLabel.setBackground(Calculator.backgroundColor);
        equationLabel.setHorizontalAlignment(RIGHT);
        equationLabel.setFont(new Font("Courier", Font.BOLD, 18));
        equationLabel.setForeground(Color.GREEN.darker());
        add(equationLabel);


    }
}
