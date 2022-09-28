package GUISwing.keyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Raketa extends JFrame implements KeyListener {

    JLabel label;
    ImageIcon icon = new ImageIcon("src/GUISwing/keyListener/rocket.png");

    Raketa() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setSize(500, 500);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setIcon(icon);
//        label.setBackground(Color.RED);
//        label.setOpaque(true);

        this.add(label);
        this.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
            int speed = 5;

        switch (e.getKeyChar()) {
            case 'a':
                label.setLocation(label.getX()-speed, label.getY());
                break;
            case 'w':
                label.setLocation(label.getX(), label.getY()-speed);
                break;
            case 's':
                label.setLocation(label.getX(), label.getY()+speed);
                break;
            case 'd':
                label.setLocation(label.getX()+speed, label.getY());
                break;

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int speed = 5;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                label.setLocation(label.getX()-speed, label.getY());
                break;
            case KeyEvent.VK_UP:
                label.setLocation(label.getX(), label.getY()-speed);
                break;
            case KeyEvent.VK_DOWN:
                label.setLocation(label.getX(), label.getY()+speed);
                break;
            case KeyEvent.VK_RIGHT:
                label.setLocation(label.getX()+speed, label.getY());
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
