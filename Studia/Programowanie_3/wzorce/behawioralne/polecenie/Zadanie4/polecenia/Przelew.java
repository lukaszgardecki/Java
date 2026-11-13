package wzorce.behawioralne.polecenie.Zadanie4.polecenia;

import wzorce.behawioralne.polecenie.Zadanie4.KontoBankowe;

public class Przelew implements Polecenie {
    private final KontoBankowe konto;
    private int kwota;
    private String odbiorca;

    public Przelew(KontoBankowe konto, int kwota, String odbiorca) {
        this.konto = konto;
        this.kwota = kwota;
        this.odbiorca = odbiorca;
    }

    @Override
    public void wykonaj() {
        konto.przelew(kwota,  odbiorca);
    }

    @Override
    public void cofnij() {
        konto.wplata(kwota);
    }
}
