package ShapesAbstractTest;

import java.text.Format;
import java.text.NumberFormat;

public class Triangle extends Shape{

    private  double base;
    private double height;

    public Triangle(double a, double h) {
        base  = a;
        height = h;
    }



    @Override
    protected void countArea() {
        super.area  = 0.5 * base * height;
    }

    public String toString() {
        return super.toString() + ", type: triangle";
    }

    public static void main(String[] args) {
        Triangle a = new Triangle(4.1, 5.6);
        System.out.println(a.toString());

    }
}
