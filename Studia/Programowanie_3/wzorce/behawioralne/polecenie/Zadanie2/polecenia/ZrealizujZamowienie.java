package wzorce.behawioralne.polecenie.Zadanie2.polecenia;

import wzorce.behawioralne.polecenie.Zadanie2.Kuchnia;

public class ZrealizujZamowienie implements Polecenie {
    private final Kuchnia kuchnia;
    private final String danie;

    public ZrealizujZamowienie(Kuchnia kuchnia, String danie) {
        this.kuchnia = kuchnia;
        this.danie = danie;
    }

    @Override
    public void wykonaj() {
        kuchnia. zrealizuj(danie);
    }
}
