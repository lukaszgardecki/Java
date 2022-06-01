package graSnake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    //stworzenie snake:
    private Snake snake = new Snake();

    public MainPanel() {

        //ustawienie preferowanego rozmiaru
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));

        //ustawienie zegara:
        MainTimer timer = new MainTimer();
        timer.start();
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
}
