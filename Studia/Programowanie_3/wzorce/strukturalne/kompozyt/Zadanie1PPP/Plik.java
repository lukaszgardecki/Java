package wzorce.strukturalne.kompozyt.Zadanie1PPP;

public class Plik implements Element {
    private final float rozmiar;
    private String nazwa;

    public Plik(String nazwa, float rozmiar) {
        this.rozmiar = rozmiar;
        this.nazwa = nazwa;
    }

    @Override
    public float pobierzRozmiar() {
        return rozmiar;
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "- " + nazwa + " (" +  rozmiar + ")");
    }
}
