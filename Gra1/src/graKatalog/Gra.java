package graKatalog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Gra extends JPanel implements KeyListener, ActionListener {

    private int x = 300;
    private Timer time;
    private int speed = 20;
    private int ey = 10;
    private Random liczbaLos = new Random();
    private int enemyX1 = liczbaLos.nextInt(6)*100;
    private int enemyX2 = liczbaLos.nextInt(6)*100;

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

        //Stworzenie wroga:
        g.setColor(Color.red);
        g.fillRect(enemyX1, ey, 100,100);
        g.fillRect(enemyX2, ey, 100, 100);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        //przerysuj kiedy wykryjesz akcjê
        repaint();

        //przesuwanie siê wroga w pionie:
        ey+=2;

        //same stworzone kwadraty, które s¹ przerysowywane nie wystarcz¹ bo one s¹ tylko grafik¹, potrzebujemy OBIEKTÓW, które bêd¹ na siebie reagowaæ. W tym celu tworzymy obiekty: gracza i dwóch wrogów:
        Rectangle player = new Rectangle(x, 475, 75, 75);
        Rectangle en1 = new Rectangle(enemyX1, ey, 100,100);
        Rectangle en2 = new Rectangle(enemyX2, ey, 100,100);

        if (player.intersects(en1) || player.intersects(en2)) {
            System.out.println("kolizja");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //po naciœniêciu klawisza "A" lub strza³ki przesuñ kwadrat, tzn przerysuj (repaint()):
        if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            //zablokowanie ¿eby kwadrat nie wychodzi³ poza ramkê
            if (x == 0) {
                x = 0;
            } else {
                x -= speed;
            }


        }

        //po naciœniêciu klawisz "D" lub strza³ki przesuñ kwadrat, tzn. przerysuj (repaint()):
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //zablokowanie zeby kjwadrat nie wychodzi³ poza ramkê
            if (x == 600) {
                x = 600;
            } else {
                x += speed;
            }


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
