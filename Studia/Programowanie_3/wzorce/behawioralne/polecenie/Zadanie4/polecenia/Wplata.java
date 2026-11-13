package wzorce.behawioralne.polecenie.Zadanie4.polecenia;

import wzorce.behawioralne.polecenie.Zadanie4.KontoBankowe;

public class Wplata implements Polecenie {
    private final KontoBankowe konto;
    private int kwota;

    public Wplata(KontoBankowe konto, int kwota) {
        this.konto = konto;
        this.kwota = kwota;
    }

    @Override
    public void wykonaj() {
        konto.wplata(kwota);
    }

    @Override
    public void cofnij() {
        konto.wyplata(kwota);
    }
}
