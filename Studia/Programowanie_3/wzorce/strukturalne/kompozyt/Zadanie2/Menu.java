package wzorce.strukturalne.kompozyt.Zadanie2;

import java.util.ArrayList;
import java.util.List;

public class Menu implements ElementMenu {
    private String tytul;
    private final List<ElementMenu> menu = new ArrayList<>();

    public Menu(String tytul) {
        this.tytul = tytul;
    }

    void dodaj(ElementMenu elementMenu) {
        menu.add(elementMenu);
    }

    @Override
    public void wypisz(String wciecie) {
        System.out.println(wciecie + "[ " + tytul + " ]");
        menu.forEach(el -> el.wypisz(wciecie));
    }
}
