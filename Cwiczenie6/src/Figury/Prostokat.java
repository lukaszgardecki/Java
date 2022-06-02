package Figury;

public class Prostokat extends Kszta³ty {
    private double a;
    private double b;

    public Prostokat(double bokA, double bokB) {
        this.a = bokA;
        this.b = bokB;
    }

    public double obliczPole() {
        double pole = a * b;
        return pole;
    }

    public double obliczObwod() {
        double obwod = (2 * a) + (2 * b);
        return obwod;
    }

    public double obliczPrzekatna() {
        double przekatna = Math.sqrt(a * a + b * b);
        return przekatna;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

}
