package wzorce.behawioralne.polecenie.Zadanie2.polecenia;

import wzorce.behawioralne.polecenie.Zadanie2.Kuchnia;

public class DodajDoZamowienia implements Polecenie {
    private final Kuchnia kuchnia;
    private final String danie;

    public DodajDoZamowienia(Kuchnia kuchnia, String danie) {
        this.kuchnia = kuchnia;
        this.danie = danie;
    }

    @Override
    public void wykonaj() {
        kuchnia.przygotuj(danie);
    }
}
