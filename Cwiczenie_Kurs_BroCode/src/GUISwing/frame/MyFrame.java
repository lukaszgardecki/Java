package GUISwing.frame;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {
        this.setSize(420, 420);
        this.setTitle("Nowy Jinstagram");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        ImageIcon mojelogo = new ImageIcon("src/GUISwing/logo.png");
        this.setIconImage(mojelogo.getImage());

        //t³o OKNA:
        this.getContentPane().setBackground(new Color(123, 50, 150));

        this.setVisible(true);
    }
}
