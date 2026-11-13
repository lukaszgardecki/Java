package wzorce.behawioralne.polecenie.Zadanie4.polecenia;

import wzorce.behawioralne.polecenie.Zadanie4.KontoBankowe;

public class Wyplata implements Polecenie {
    private final KontoBankowe konto;
    private int kwota;

    public Wyplata(KontoBankowe konto, int kwota) {
        this.konto = konto;
        this.kwota = kwota;
    }

    @Override
    public void wykonaj() {
        konto.wyplata(kwota);
    }

    @Override
    public void cofnij() {
        konto.wplata(kwota);
    }
}
