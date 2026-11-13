package wzorce.behawioralne.polecenie.Zadanie5.polecenia;

import wzorce.behawioralne.polecenie.Zadanie5.Jednostka;

public class BronSie implements Polecenie {
    private final Jednostka jednostka;

    public BronSie(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public void wykonaj() {
        jednostka.bronSie();
    }

    @Override
    public void cofnij() {
        jednostka.przestanBronic();
    }
}
