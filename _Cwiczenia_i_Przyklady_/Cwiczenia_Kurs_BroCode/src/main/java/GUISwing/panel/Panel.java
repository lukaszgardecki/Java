package GUISwing.panel;

import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main(String[] args) {



        JLabel label = new JLabel();
        label.setText("Hi");
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.RIGHT);

        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0, 250, 250);
        redPanel.setLayout(new BorderLayout());
        redPanel.add(label);

        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0, 250, 250);

        JPanel greenPanel = new JPanel();
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0,250, 500, 250);
        greenPanel.setLayout(new BorderLayout());


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);

    }
}
