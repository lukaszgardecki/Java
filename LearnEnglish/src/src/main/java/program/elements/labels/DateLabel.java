package program.elements.labels;

import program.Main;

import javax.swing.*;
import java.awt.*;

public class DateLabel extends JLabel {

    public DateLabel() {
        setText("Ostatnia powtórka: " + Main.getDate());
        setBounds(280, 160, 300, 20);
        setFont(new Font("Courier", Font.PLAIN, 12));
    }
}
