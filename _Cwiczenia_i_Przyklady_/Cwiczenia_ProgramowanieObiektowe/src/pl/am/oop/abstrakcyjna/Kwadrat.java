package pl.am.oop.abstrakcyjna;

public class Kwadrat extends Prostokat {

    public Kwadrat(double bok) {
        super(bok, bok); // <----super musi byæ pierwszym wywo³aniem, musi byæ na pocz¹tku!
    }

    public double getBok() {
        return a;
    }

    @Override // <-- to jest adnotacja i odnosi siê do metody toString
    public String toString() {
        return "Kwadrat{" +
                "bok=" + a +
                ", pole=" + obliczPole() +
                ", obwód=" + obliczObwod() +
                '}';
    }
}
