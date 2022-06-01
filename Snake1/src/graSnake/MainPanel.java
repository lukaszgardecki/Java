package graSnake;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {

        //ustawienie preferowanego rozmiaru
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
    }

    //musimy nadpisaæ metodê paintComponent, dziêki niej bêdziemy rysowaæ
    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
    }
}
