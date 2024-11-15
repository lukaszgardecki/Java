package game;

import javax.swing.*;

public class MainFrameSaper extends JFrame {
    static MainContainer container;
    ImageIcon mine = new ImageIcon("src/main/java/game/images/mine.png");

    MainFrameSaper() {
        container = new MainContainer();
        add(container);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(mine.getImage());
        setTitle("Saper");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void changeSize() {
        pack();
        setLocationRelativeTo(null);
    }
}
