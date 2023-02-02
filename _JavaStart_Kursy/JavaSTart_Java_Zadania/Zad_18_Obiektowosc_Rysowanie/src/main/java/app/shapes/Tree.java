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
            System.out.println(
                    new StringBuffer(" ".repeat(height - 1 - i))
                    .append(Drawable.SIGN.repeat(2 * i + 1))
                    .append(" ".repeat(height - 1 - i))
            );
        }
    }
}
