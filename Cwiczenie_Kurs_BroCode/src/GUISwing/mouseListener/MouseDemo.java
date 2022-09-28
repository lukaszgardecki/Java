package GUISwing.mouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseDemo extends JFrame implements MouseListener {

    JLabel label;
    ImageIcon smile = new ImageIcon("src/GUISwing/mouseListener/smile.png");
    ImageIcon nervous = new ImageIcon("src/GUISwing/mouseListener/nervous.png");
    ImageIcon pain = new ImageIcon("src/GUISwing/mouseListener/pain.png");
    ImageIcon angry = new ImageIcon("src/GUISwing/mouseListener/angry.png");


    MouseDemo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        label = new JLabel();
        label.setIcon(smile);
        label.addMouseListener(this);

        this.add(label);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setIcon(pain);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setIcon(angry);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setIcon(nervous);
    }

    @Override
    public void mouseExited(MouseEvent e) {
       label.setIcon(smile);
    }
}
