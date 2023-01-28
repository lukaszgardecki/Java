package program.elements.main_frame;

import program.elements.panels.Content;
import program.Main;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    public Window() {
        setTitle("Learn English");
        //setLayout(null);
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Main.saveData();
            }
        });
        add(new Content());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
