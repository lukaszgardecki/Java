package pl.am.oop.interfejsy;

public abstract class Zwierze {
    protected double masa;

    public Zwierze(double masa) {
        this.masa = masa;
    }

    public abstract void dajGlos();

    public double getMasa() {
        return masa;
    }
}
