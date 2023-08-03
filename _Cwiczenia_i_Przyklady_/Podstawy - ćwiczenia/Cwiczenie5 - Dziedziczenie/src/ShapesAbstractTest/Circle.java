package ShapesAbstractTest;

import java.text.Format;

public class Circle extends Shape {

    private double ray;

    public Circle(double ray) {
        this.ray = ray;
    }



    @Override
    protected void countArea() {
        super.area = Math.PI * ray * ray;
    }

    public String toString() {
        return super.toString() + ", type: circle";
    }

    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println(c.toString());
    }
}
