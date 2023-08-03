package program.elements.text_fields;

import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField extends JTextField implements FocusListener {
    String name;

     public TextField(String name) {
         super(name);
         this.name = name;
         setSize(300, 30);
         setFont(new Font("Courier", Font.PLAIN, 18));
         setBackground(MyColor.BLUE_LIGHT);
         setForeground(Color.GRAY);

         setBorder(BorderFactory.createEmptyBorder());
         addFocusListener(this);


     }
     @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(name)) {
            setText("");
            setForeground(Color.BLACK);
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setForeground(Color.GRAY);
            setText(name);
        }
    }
}
