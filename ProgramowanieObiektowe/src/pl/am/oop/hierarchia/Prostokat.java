package pl.am.oop.hierarchia;

public class Prostokat extends Figura {
    protected final double a;
    protected final double b;

    public Prostokat(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double obliczPole() {
        return a * b;
    }

    public double obliczObwod() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        return "Prostokat{" +
                "a=" + a +
                ", b=" + b +
                ", pole=" + obliczPole() +
                ", obwód=" + obliczObwod() +
                '}';
    }
}
