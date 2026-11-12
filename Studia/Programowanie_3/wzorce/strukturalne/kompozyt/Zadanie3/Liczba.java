package wzorce.strukturalne.kompozyt.Zadanie3;

public class Liczba implements Wyrazenie {
    private int wartosc;

    public Liczba(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public int oblicz() {
        return wartosc;
    }
}
