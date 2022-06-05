package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Ustawienia ekranu
    final int originalTileSize = 16; //kafelka 16x16 px
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //kafelka 48x48 px
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //768px
    final int screenHeight = tileSize * maxScreenRow; //576px

    //Thread jest czymœ co mo¿na rozpocz¹æ i zakoñczyæ:
    Thread gameThread;

    //Konstruktor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            //System.out.println("The game loop is running");

            // 1.Aktualizacja: aktualizuj informacje takie jak pozycja postaci
            update();

            //2.Rysunek: Rysuj ekran z aktualymi informacjami
            repaint();
        }
    }

    public void update() {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //rzutowanie! konwertowanie zamiana itp..Zamieniamy zwyk³e Graphics na Graphics2D poniewa¿ ma ona wiêcej fukcji:
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }
}
