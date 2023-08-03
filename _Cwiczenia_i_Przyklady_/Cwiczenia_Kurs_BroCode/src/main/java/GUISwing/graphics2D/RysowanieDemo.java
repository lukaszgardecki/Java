package GUISwing.graphics2D;

import javax.swing.*;
import java.awt.*;

public class RysowanieDemo extends JFrame {

    MyPanel panel;

    RysowanieDemo() {

        panel = new MyPanel();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


        this.add(panel);

        this.pack();
        this.setVisible(true);
    }




}
