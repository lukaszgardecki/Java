package program.elements.labels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class GroupVol extends JLabel {
    public static final int WIDTH = 110;
    public static final int HEIGHT = 30;

    public GroupVol(String name) {
        super(name);
        setText(name);
        setSize(WIDTH, HEIGHT);
        setHorizontalAlignment(CENTER);
    }

    protected void paintComponent(Graphics g) {
        if (getColorModel().hasAlpha()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        super.paintComponent(g);
    }

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 20, 20);
        }
        return shape.contains(x, y);
    }
}
