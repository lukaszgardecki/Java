package wzorce.dekorator.Zadanie4.postacie;

import wzorce.dekorator.Zadanie4.Postac;

public class Wojownik implements Postac {

    @Override
    public int atak() {
        return 4;
    }

    @Override
    public int obrona() {
        return 3;
    }

    @Override
    public String opis() {
        return "Wojownik";
    }
}
