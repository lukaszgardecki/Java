package pl.am.oop.farma3;

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
