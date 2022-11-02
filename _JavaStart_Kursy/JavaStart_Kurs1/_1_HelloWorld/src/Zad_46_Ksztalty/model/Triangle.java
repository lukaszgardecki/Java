package Zad_46_Ksztalty.model;

public class Triangle implements Shape {
    private double a;
    private double b;
    private double c;
    private double p;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = (a + b + c) / 2;
    }

    @Override
    public double getArea() {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return String.format("Trójk¹t o bokach %.2f,%.2f,%.2f:%n- pole: %.2f%n- obwód: %.2f%n", a, b, c, getArea(), getPerimeter());
    }

}
