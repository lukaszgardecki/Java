package Zad_46_Ksztalty.model;

public class Rectangle implements Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return 2 * (a + b);
    }

    double getA() {
        return a;
    }

    double getB() {
        return b;
    }

    @Override
    public String toString() {
        return String.format("Prostok¹t o bokach %.2f i %.2f:%n- pole: %.2f%n- obwód: %.2f%n", a, b, getArea(), getPerimeter());
    }
}
