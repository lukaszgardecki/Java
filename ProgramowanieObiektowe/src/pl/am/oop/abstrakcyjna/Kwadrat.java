package pl.am.oop.abstrakcyjna;

public class Kwadrat extends Prostokat {

    public Kwadrat(double bok) {
        super(bok, bok); // <----super musi by� pierwszym wywo�aniem, musi by� na pocz�tku!
    }

    public double getBok() {
        return a;
    }

    @Override // <-- to jest adnotacja i odnosi si� do metody toString
    public String toString() {
        return "Kwadrat{" +
                "bok=" + a +
                ", pole=" + obliczPole() +
                ", obw�d=" + obliczObwod() +
                '}';
    }
}
