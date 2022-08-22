package program.elements.text_fields;

import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {
     public TextField() {
         setSize(300, 30);
         setFont(new Font("Courier", Font.PLAIN, 18));
         setBackground(MyColor.BLUE_LIGHT);
         setBorder(BorderFactory.createEmptyBorder());
     }
}
