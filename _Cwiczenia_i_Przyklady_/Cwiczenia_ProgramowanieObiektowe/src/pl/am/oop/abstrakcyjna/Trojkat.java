package pl.am.oop.abstrakcyjna;

public class Trojkat extends Figura {
    private final double podstawa;
    private final double wysokosc;

    public Trojkat(double podstawa, double wysokosc) {
        this.podstawa = podstawa;
        this.wysokosc = wysokosc;
    }

    @Override
    public double obliczPole() {
        return 0.5 * podstawa * wysokosc;
    }

    @Override
    public String toString() {
        return "Trojkat{" +
                "podstawa=" + podstawa +
                ", wysokosc=" + wysokosc +
                ", pole=" + obliczPole() +
                '}';
    }
}
