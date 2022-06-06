package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Ustawienia ekranu
    final int originalTileSize = 16; //kafelka 16x16 px
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //kafelka 48x48 px
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768px
    public final int screenHeight = tileSize * maxScreenRow; //576px

    //FPS:
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    //Thread jest czym� co mo�na rozpocz�� i zako�czy�:
    Thread gameThread;
    Player player = new Player(this, keyH);



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
//            //.nanoTime() jest bardziej dok�adny ni� currentTimeMillis()
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
//            //gdyby nie diza�a�o to wy�ej:
////            try {
////                Thread.sleep((long) remainingTime);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
//        }
//    }

    //METODA DRUGA: z delt�
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
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //rzutowanie! konwertowanie zamiana itp..Zamieniamy zwyk�e Graphics na Graphics2D poniewa� ma ona wi�cej fukcji:
        Graphics2D g2 = (Graphics2D)g;

        //uwaga! p�ytki maj� by� rysowane PRZED graczem. najpierw p�ytki potem gracz
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
