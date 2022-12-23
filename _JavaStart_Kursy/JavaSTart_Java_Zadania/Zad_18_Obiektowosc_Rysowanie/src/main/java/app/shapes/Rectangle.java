package app.shapes;

import app.Drawable;

public class Rectangle implements Drawable {
    private int a;
    private int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw() {
        for (int i = 0; i < b; i++) {
            System.out.println(Drawable.SIGN.repeat(a));
        }
    }
}
