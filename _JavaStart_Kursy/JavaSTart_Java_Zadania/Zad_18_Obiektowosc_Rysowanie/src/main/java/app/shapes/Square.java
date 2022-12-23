package app.shapes;

import app.Drawable;

public class Square implements Drawable {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public void draw() {
        for (int i = 0; i < a; i++) {
            System.out.println(Drawable.SIGN.repeat(a));
        }
    }
}
