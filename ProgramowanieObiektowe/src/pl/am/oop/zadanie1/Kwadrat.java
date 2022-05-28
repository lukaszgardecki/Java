package pl.am.oop.zadanie1;

public class Kwadrat {
    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    public double getBok() {
        return bok;
    }

    public void setBok(double bok) {
        this.bok = bok;
    }

    public double obliczPole() {
        return this.bok * this.bok;
    }

    public double obliczObwod() {
        return 4 * this.bok;
    }

    @Override
    public String toString() {
        return "Kwadrat{" +
                "bok=" + bok +
                ", pole=" + obliczPole() +
                ", obwód=" + obliczObwod() +
                '}';
    }
}
