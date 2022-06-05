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

    //FPS:
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    //Thread jest czymœ co mo¿na rozpocz¹æ i zakoñczyæ:
    Thread gameThread;


    //Ustawienie domyœlnej pozycji gracza
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;


    //Konstruktor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    //METODA PIERWSZA: metoda z usypianiem
//    @Override
//    public void run() {
//
//        double drawInterval = 1000000000/FPS; // 0.01666 sekund
//        double nextDrawTime = System.nanoTime() + drawInterval;
//
//        while (gameThread != null) {
//            //.nanoTime() jest bardziej dok³adny ni¿ currentTimeMillis()
//            long currentTime = System.nanoTime(); // j
//            //long currentTime2 = System.currentTimeMillis();
//
//            // 1.Aktualizacja: aktualizuj informacje takie jak pozycja postaci
//            update();
//
//            //2.Rysunek: Rysuj ekran z aktualymi informacjami
//            repaint();
//
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//
//                Thread.sleep((long) remainingTime);
//
//                nextDrawTime += drawInterval;
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            //gdyby nie diza³a³o to wy¿ej:
////            try {
////                Thread.sleep((long) remainingTime);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
//        }
//    }

    //METODA DRUGA: z delt¹
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            playerY -= playerSpeed;
        } else if (keyH.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //rzutowanie! konwertowanie zamiana itp..Zamieniamy zwyk³e Graphics na Graphics2D poniewa¿ ma ona wiêcej fukcji:
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);

        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}
