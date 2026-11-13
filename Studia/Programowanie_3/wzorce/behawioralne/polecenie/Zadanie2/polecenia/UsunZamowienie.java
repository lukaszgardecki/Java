package wzorce.behawioralne.polecenie.Zadanie2.polecenia;

import wzorce.behawioralne.polecenie.Zadanie2.Kuchnia;

public class UsunZamowienie implements Polecenie {
    private Kuchnia kuchnia;
    private String danie;

    public UsunZamowienie(Kuchnia kuchnia, String danie) {
        this.kuchnia = kuchnia;
        this.danie = danie;
    }

    @Override
    public void wykonaj() {
        kuchnia.anuluj(danie);
    }
}
