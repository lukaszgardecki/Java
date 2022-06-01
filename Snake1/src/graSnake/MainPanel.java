package graSnake;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {

        //ustawienie preferowanego rozmiaru
        setPreferredSize(new Dimension(Board.MAX_X, Board.MAX_Y));
    }

    //musimy nadpisa� metod� paintComponent, dzi�ki niej b�dziemy rysowa�
    @Override
    protected void paintComponent(Graphics g) {
        Board.draw(g);
    }
}
