package game;

import javax.swing.*;

public class MainFrameSaper extends JFrame {

    static MainContainer container;

    MainFrameSaper() {
        container = new MainContainer();
        add(container);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
