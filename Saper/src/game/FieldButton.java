package game;

import javax.swing.*;
import java.awt.*;

public class FieldButton extends JButton {

    static int fieldWidth = 40;
    static int fieldHeight = 40;


    FieldButton() {
        setSize(fieldWidth, fieldHeight);
        setBackground(new Color(123, 210, 253));
        //setVisible(false);
    }


}
