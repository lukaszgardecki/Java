package Zad_46_Ksztalty.model;

public class Circle implements Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * r * r;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
        return String.format("Ko³o o promieniu %.2f:%n- pole: %.2f%n- obwód: %.2f%n", r, getArea(), getPerimeter());
    }
}
