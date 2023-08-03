package graKatalog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Gra extends JPanel implements KeyListener, ActionListener {

    private int x = 300;
    private int punkty = 0;
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
        //wype�nienie kolorem ca�ego okna:
        g.setColor(Color.black);
        g.fillRect(0,0,700,600);

        //Stworzenie gracza (kwadrat):
        g.setColor(Color.CYAN);
        g.fillRect(x,475,75,75);

        //Stworzenie wroga:
        g.setColor(Color.red);
        g.fillRect(enemyX1, ey, 100,100);
        g.fillRect(enemyX2, ey, 100, 100);

        //Punkty:
        g.setColor(Color.white);
        g.setFont( new Font("serif", Font.BOLD, 20));
        g.drawString("Punkty: " + punkty, 570, 20);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        //przerysuj kiedy wykryjesz akcj�
        repaint();

        //przesuwanie si� wroga w pionie (tempo):
        ey+=2;

        //ponowne generowanie wroga. Za ka�dym razem, gdy wr�g przejdzie w pionie plansz�, wygeneruj nowych wrog�w i dodaj punkt do licznika punkt�w:
        if (ey == 580) {
            ey = 10;
            punkty++;
            enemyX1 = liczbaLos.nextInt(6)*100;
            enemyX2 = liczbaLos.nextInt(6)*100;
        }


        //same stworzone kwadraty, kt�re s� przerysowywane nie wystarcz� bo one s� tylko grafik�, potrzebujemy OBIEKT�W, kt�re b�d� na siebie reagowa�. W tym celu tworzymy obiekty: gracza i dw�ch wrog�w:
        Rectangle player = new Rectangle(x, 475, 75, 75);
        Rectangle en1 = new Rectangle(enemyX1, ey, 100,100);
        Rectangle en2 = new Rectangle(enemyX2, ey, 100,100);

        //  wykrywanie kolizji:
        if (player.intersects(en1) || player.intersects(en2)) {
            time.stop();
        }
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }





    @Override
    public void keyPressed(KeyEvent e) {
//        switch (e.getKeyCode()) {
//
//            //po naci�ni�ciu klawisza "A" lub strza�ki przesu� kwadrat, tzn przerysuj (repaint()):
//            case KeyEvent.VK_A:
//            case KeyEvent.VK_LEFT:
//                //zablokowanie �eby kwadrat nie wychodzi� poza ramk�
//                if (x == 0) {
//                    x = 0;
//                } else {
//                    x -= speed;
//                }
//
//
//                //po naci�ni�ciu klawisz "D" lub strza�ki przesu� kwadrat, tzn. przerysuj (repaint()):
//            case KeyEvent.VK_D:
//            case KeyEvent.VK_RIGHT:
//                //zablokowanie zeby kwadrat nie wychodzi� poza ramk�
//                if (x == 600) {
//                    x = 600;
//                } else {
//                    x += speed;
//                }
//
//
//                //po naci�ni�ciu klawisza ENTER zresetuj gre:
//            case KeyEvent.VK_ENTER:
//                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                    reset();
//                }
//        }






        //po naci�ni�ciu klawisza "A" lub strza�ki przesu� kwadrat, tzn przerysuj (repaint()):
        if (e.getKeyCode() == KeyEvent.VK_A) {
            //zablokowanie �eby kwadrat nie wychodzi� poza ramk�
            if (x == 0) {
                x = 0;
            } else {
                x -= speed;
            }
        }

        //po naci�ni�ciu klawisz "D" lub strza�ki przesu� kwadrat, tzn. przerysuj (repaint()):
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //zablokowanie zeby kwadrat nie wychodzi� poza ramk�
            if (x == 600) {
                x = 600;
            } else {
                x += speed;
            }
        }

        //po naci�ni�ciu klawisza ENTER zresetuj gre:
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            reset();
        }
    }

    //Po naci�ni�ciu wykonaj reset, tzn. instrukcje poni�ej:
    private void reset() {
        ey = 10;
        enemyX1 = liczbaLos.nextInt(6)*100;
        enemyX2 = liczbaLos.nextInt(6)*100;
        x = 300;
        time.start();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
