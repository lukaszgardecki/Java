package graSnake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Point> body;
    private Direction direction;

    public Snake() {
        direction = Direction.D;
        body = new ArrayList<>();

        body.add(new Point(2, 5));
        body.add(new Point(2, 4));
        body.add(new Point(2, 3));
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);

        for (Point point : getTail()) {
            g.fillRect(point.x*Board.SIZE, point.y*Board.SIZE, Board.SIZE, Board.SIZE);
        }

        g.setColor(new Color(55, 63,227 ));
        g.fillOval(getHead().x*Board.SIZE, getHead().y*Board.SIZE, Board.SIZE, Board.SIZE);

    }

    private Point getHead() {
        return body.get(0);
    }

    private List<Point> getTail() {
        return body.subList(1, body.size());
    }

    //metoda umo¿liwiaj¹ca siê poruaszanie ( jest wywo³ywana w ka¿dym cyklu zegara)
    public void move() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setLocation(body.get(i-1));
        }

        //musimy sprawdziæ w którym kierunku porusza siê w¹¿:
        switch (direction) {
            case D -> getHead().y++;
            case U -> getHead().y--;
            case R -> getHead().x++;
            case L -> getHead().x--;
        }
    }



}
