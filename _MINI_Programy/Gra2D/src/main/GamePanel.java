package main;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //USTAWIENIA EKRANU
    final int originalTileSize = 16; //kafelka 16x16 px
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //kafelka 48x48 px
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //768px
    public final int screenHeight = tileSize * maxScreenRow; //576px

    //USTAWIENIA ŒWIATA
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;


    //FPS:
    int FPS = 60;

    //SYSTEM:
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound se = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;      //-> Thread jest czymœ co mo¿na rozpocz¹æ i zakoñczyæ

    // ENTITY AND OBJECT
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];


    //STAN GRY
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;


    //Konstruktor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setObject();
        aSetter.setNPC();
        playMusic(0);   //->odtwórz muzykê BlueBoyAdventure

        gameState = playState;
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
        if (gameState == playState) {
            //Player
            player.update();
            //NPC
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }
        }
        if (gameState == pauseState) {
            //nothing
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //rzutowanie! konwertowanie zamiana itp..Zamieniamy zwyk³e Graphics na Graphics2D poniewa¿ ma ona wiêcej fukcji:
        Graphics2D g2 = (Graphics2D)g;

        //uwaga! p³ytki maj¹ byæ rysowane PRZED graczem. najpierw p³ytki potem gracz !

        //DEBUG
        long drawStart = 0;
        if (keyH.checkDrawTime == true) {
            drawStart = System.nanoTime();
        }

        // P£YTKA
        tileM.draw(g2);

        //OBJEKT
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }

        //NPC
        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2);
            }
        }

            //GRACZ
            player.draw(g2);

        // UI - zebrane klucze:
        ui.draw(g2);

        //DEBUG
        if (keyH.checkDrawTime) {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }



        g2.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);   //ustaw muzyczkê
        music.play();       //odwtórz
        music.loop();       //zapêtlij
    }

    public void stopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }
}
