package pl.am.projects.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMenuTest extends JFrame implements ActionListener {

    public JMenuTest() {
        setSize(800, 800);
        setTitle("Demonstracja JMenuBar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        JMenuTest appMenu = new JMenuTest();
        appMenu.setVisible(true);
    }
}
