package wzorce.dekorator.Zadanie4.postacie;

import wzorce.dekorator.Zadanie4.Postac;

public class Mag implements Postac {

    @Override
    public int atak() {
        return 5;
    }

    @Override
    public int obrona() {
        return 2;
    }

    @Override
    public String opis() {
        return "Mag";
    }
}
