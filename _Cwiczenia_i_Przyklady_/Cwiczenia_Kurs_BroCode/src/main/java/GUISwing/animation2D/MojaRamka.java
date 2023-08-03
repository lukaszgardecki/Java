package GUISwing.animation2D;

import javax.swing.*;

public class MojaRamka extends JFrame {

    MojPanel panel;

    MojaRamka() {

        panel = new MojPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.add(panel);

        this.pack();
        this.setVisible(true);
    }
}
