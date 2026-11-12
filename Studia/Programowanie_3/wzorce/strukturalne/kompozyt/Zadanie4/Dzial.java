package wzorce.strukturalne.kompozyt.Zadanie4;

import java.util.ArrayList;
import java.util.List;

public class Dzial implements  ElementOrganizacji {
    private String nazwa;
    private final List<ElementOrganizacji> czlonkowie = new ArrayList<>();

    public Dzial(String nazwa) {
        this.nazwa = nazwa;
    }

    public void dodaj(ElementOrganizacji el) {
        czlonkowie.add(el);
    }

    @Override
    public double pobierzPensje() {
        return czlonkowie.stream().mapToDouble(ElementOrganizacji::pobierzPensje).sum();
    }

    @Override
    public void wypiszHierarchie(String wciecie) {
        System.out.println(wciecie + "Dział: " + nazwa);
        czlonkowie.forEach(el -> el.wypiszHierarchie(wciecie));
    }
}
