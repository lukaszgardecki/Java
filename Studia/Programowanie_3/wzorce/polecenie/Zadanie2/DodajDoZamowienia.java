package wzorce.polecenie.Zadanie2;

public class DodajDoZamowienia implements Polecenie {
    private final Kuchnia kuchnia;
    private final String danie;

    DodajDoZamowienia(Kuchnia kuchnia, String danie) {
        this.kuchnia = kuchnia;
        this.danie = danie;
    }

    @Override
    public void wykonaj() {
        kuchnia.przygotuj(danie);
    }
}
