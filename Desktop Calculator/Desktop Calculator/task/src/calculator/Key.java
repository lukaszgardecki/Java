package calculator;

import javax.swing.*;
import java.awt.*;

public class Key extends JButton {
    public static final Font KEY_FONT = new Font("Courier", Font.BOLD, 20);

    public Key() {
        setFont(KEY_FONT);
        //setBounds(0,0,30,30);
        setBackground(Color.WHITE);



    }
}
