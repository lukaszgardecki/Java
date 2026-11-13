package wzorce.strukturalne.kompozyt.Zadanie1PPP;

import java.util.ArrayList;
import java.util.List;

public class Katalog implements Element {
    private final List<Element> elementy = new ArrayList<>();
    private String nazwa;

    public Katalog(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodaj(Element element) {
        elementy.add(element);
    }

    @Override
    public float pobierzRozmiar() {
        return elementy.stream().map(Element::pobierzRozmiar).reduce(0.0f, Float::sum);
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "+ " + nazwa);
        elementy.forEach(el -> el.wypisz(wciecie));
    }
}
