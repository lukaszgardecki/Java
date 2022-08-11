package calculator;

import javax.swing.*;

public class ResultPanel extends JPanel {
    public static JTextField txtF;

    public ResultPanel() {
        setBounds(0, 0, 400, 100);
        //setBackground(Color.BLUE);
        setLayout(null);

        txtF = new JTextField();
        txtF.setBounds(45, 35, 300, 35);
        txtF.setName("EquationTextField");
        add(txtF);

    }
}
