package calculator;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.RIGHT;

public class ResultPanel extends JPanel {
    public static JLabel resultLabel;
    public static JLabel equationLabel;

    public ResultPanel() {
        setBounds(0, 0, 400, 150);
        //setBackground(Color.BLUE);
        setLayout(null);

        resultLabel = new JLabel();
        resultLabel.setBounds(45, 35, 300, 80);
        resultLabel.setText("0");
        resultLabel.setName("ResultLabel");
        //resultLabel.setBackground(Color.PINK);
        resultLabel.setHorizontalAlignment(RIGHT);
        resultLabel.setFont(new Font("Courier", Font.BOLD, 50));
        add(resultLabel);

        equationLabel = new JLabel();
        equationLabel.setBounds(45, 115, 300, 35);
        equationLabel.setName("EquationLabel");
        //equationLabel.setBackground(Color.BLACK);
        equationLabel.setHorizontalAlignment(RIGHT);
        equationLabel.setFont(new Font("Courier", Font.BOLD, 18));
        equationLabel.setForeground(Color.GREEN.darker());
        add(equationLabel);


    }
}
