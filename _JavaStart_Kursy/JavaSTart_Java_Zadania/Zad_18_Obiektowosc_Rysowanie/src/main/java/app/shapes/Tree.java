package app.shapes;

import app.Drawable;

public class Tree implements Drawable {
    private int height;

    public Tree(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        for (int i = 0; i < height; i++) {
            System.out.println(" ".repeat(height - 1 - i) + Drawable.SIGN.repeat(2 * i + 1) + " ".repeat(height - 1 - i));
        }
    }
}
