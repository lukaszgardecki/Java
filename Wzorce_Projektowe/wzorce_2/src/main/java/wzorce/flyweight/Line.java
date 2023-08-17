package wzorce.flyweight;

import java.awt.*;

public class Line implements Shape {

    public Line() {
        System.out.println("Creating Line object");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void draw(Graphics line, int x1, int y1, int x2, int y2, Color color) {
        line.setColor(color);
        line.setClip(x1, y1, x2, y2);
    }
}
