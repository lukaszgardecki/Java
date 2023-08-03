package pl.am.oop.farma;

public abstract class Zwierze {
    protected double masa;

    public Zwierze(double masa) {
        this.masa = masa;
    }

    public abstract void dajGlos();
}
