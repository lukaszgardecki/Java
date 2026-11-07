package wzorce.polecenie.Zadanie2;

public class UsunZamowienie implements Polecenie {
    private Kuchnia kuchnia;
    private String danie;

    UsunZamowienie(Kuchnia kuchnia, String danie) {
        this.kuchnia = kuchnia;
        this.danie = danie;
    }

    @Override
    public void wykonaj() {
        kuchnia.anuluj(danie);
    }
}
