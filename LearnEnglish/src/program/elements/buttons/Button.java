package program.elements.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Button extends JButton implements ActionListener {
    public static final int WIDTH = 110;
    public static final int HEIGHT = 30;

    public Button(String name) {
        super(name);
        setSize(WIDTH, HEIGHT);
        //Dimension size = getPreferredSize();
        //size.width = size.height = Math.max(size.width, size.height);
        //setPreferredSize(size);
        addActionListener(this);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 25, 25);
    }
    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 25, 25);
        }
        return shape.contains(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
