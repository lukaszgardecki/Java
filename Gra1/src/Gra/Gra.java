package Gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gra extends JPanel implements KeyListener, ActionListener {

    private int x = 300;
    private Timer time;
    private int speed = 20;

    public Gra() {
        time = new Timer(10, this);
        time.start();

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);

    }

    public void paint(Graphics g) {
        //wype³nienie kolorem ca³ego okna:
        g.setColor(Color.black);
        g.fillRect(0,0,700,600);

        //Stworzenie gracza (kwadrat):
        g.setColor(Color.CYAN);
        g.fillRect(x,475,75,75);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        //przerysuj kiedy wykryjesz akcjê
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //po naciœniêciu klawisz przesuñ kwadrat, tzn przerysuj (repaint()):
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= speed;
        } else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += speed;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
