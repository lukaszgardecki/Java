package program.elements.labels;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {
    public TitleLabel(String text) {
        setText(text);
        setForeground(Color.BLACK);
        setFont(new Font("Courier", Font.BOLD, 20));
        setBackground(null);
        setSize(300, 25);
    }
}
