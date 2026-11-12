package wzorce.behawioralne.polecenie.Zadanie2;

public class ZrealizujZamowienie implements Polecenie {
    private final Kuchnia kuchnia;
    private final String danie;

    ZrealizujZamowienie(Kuchnia kuchnia, String danie) {
        this.kuchnia = kuchnia;
        this.danie = danie;
    }

    @Override
    public void wykonaj() {
        kuchnia. zrealizuj(danie);
    }
}
