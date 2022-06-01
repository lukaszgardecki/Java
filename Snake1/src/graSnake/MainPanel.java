package graSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {

    //stworzenie snake:
    private Snake snake = new Snake();

    public MainPanel() {

        //ustawienie preferowanego rozmiaru
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));

        //ustawienie zegara:
        MainTimer timer = new MainTimer();
        timer.start();

        //trzeba ustawiæ fokus, ¿eby nas³uchiwacz dzia³a³:
        setFocusable(true);

        //trzeba dodaæ nas³uchiwacza:
        addKeyListener(new MyKeyAdapter());
    }

    //musimy nadpisaæ metodê paintComponent, dziêki niej bêdziemy rysowaæ
    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
        snake.draw(g);
    }


    private class MainTimer extends Timer {
        public static final int DELAY = 100;

        public MainTimer() {
            super(DELAY, e -> {
                snake.move();
                repaint();
            });
        }
    }


    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                //po klikniêciu w lewo zmieniamy kierunek na lewy
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (snake.getDirection() != Direction.R) {
                        snake.setDirection(Direction.L);
                    }
                    break;
                //po klikniêciu w prawo zmieniamy kierunek na prawy
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (snake.getDirection() != Direction.L) {
                        snake.setDirection(Direction.R);
                    }
                    break;
                //po klikniêciu w do³ zmieniamy kierunek na dolny
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (snake.getDirection() != Direction.U) {
                        snake.setDirection(Direction.D);
                    }
                    break;
                //po klikniêciu w górê zmieniamy kierunek na górny
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (snake.getDirection() != Direction.D) {
                        snake.setDirection(Direction.U);
                    }
                    break;
            }
        }
    }
}
