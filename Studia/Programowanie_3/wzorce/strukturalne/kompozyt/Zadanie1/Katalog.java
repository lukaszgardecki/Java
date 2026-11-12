package wzorce.strukturalne.kompozyt.Zadanie1;

import java.util.ArrayList;
import java.util.List;

public class Katalog implements ElementSystemuPlikow {
    private String nazwa;
    private final List<ElementSystemuPlikow> elementy = new ArrayList<>();

    public Katalog(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodaj(ElementSystemuPlikow plik) {
        elementy.add(plik);
    }

    @Override
    public String pobierzNazwe() {
        return nazwa;
    }

    @Override
    public int pobierzRozmiar() {
        return elementy.stream().mapToInt(ElementSystemuPlikow::pobierzRozmiar).sum();
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "+ " + nazwa);
        elementy.forEach(e -> e.wypisz(wciecie));
    }
}
