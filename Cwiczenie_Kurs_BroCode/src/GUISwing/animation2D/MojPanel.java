package GUISwing.animation2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MojPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    final int SPEED = 4;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 2*SPEED;
    int yVelocity = 1*SPEED;
    int x = 0;
    int y = 0;

    MojPanel() {

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        enemy = new ImageIcon("src/GUISwing/animation2D/enemy.png").getImage();
        backgroundImage = new ImageIcon("src/GUISwing/animation2D/space.png").getImage();
        timer = new Timer(1, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g); // --> czarne t³o panelu
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(enemy, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // jeœli potworek dotknie prawej lub lewej œcianki to odbij go
        if (x >= PANEL_WIDTH - enemy.getWidth(null) ||
            x < 0) {
            xVelocity *= -1;
        }

        // jeœli potworek dotknie dolnej lub górnej œcianki to odbij go
        if (y >= PANEL_HEIGHT - enemy.getHeight(null) ||
            y < 0) {
            yVelocity *= -1;
        }

        // zmieñ wspó³rzêdne potworka
        y += yVelocity;
        x += xVelocity;

        // przerysuj potworka
        repaint();
    }
}
