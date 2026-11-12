package wzorce.behawioralne.polecenie.Zadanie4;

public class Wplata implements Polecenie {
    private final KontoBankowe konto;
    private int kwota;

    Wplata(KontoBankowe konto, int kwota) {
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
