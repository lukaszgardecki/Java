package pl.am.oop.zadanie1;

public class Prostokat {
    private double a;
    private double b;

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

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double obliczPole() {
        return this.a * this.b;
    }

    public double obliczObwod() {
        return 2 * (this.a + this.b);
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
