package wzorce.strukturalne.kompozyt.Zadanie1;

public class Plik implements ElementSystemuPlikow {
    private String nazwa;
    private int rozmiar;

    public Plik(String nazwa, int rozmiar) {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
    }

    @Override
    public String pobierzNazwe() {
        return nazwa;
    }

    @Override
    public int pobierzRozmiar() {
        return rozmiar;
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "- " + nazwa + " (" + rozmiar + " KB)");
    }
}
