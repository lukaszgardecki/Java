package game;

import javax.swing.*;

public class MainFrameSaper extends JFrame {

    MainContainer container;

    MainFrameSaper() {
        container = new MainContainer();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(container);

        pack();
        setVisible(true);
    }
}
