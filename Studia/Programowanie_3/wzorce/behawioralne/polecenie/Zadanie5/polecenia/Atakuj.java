package wzorce.behawioralne.polecenie.Zadanie5.polecenia;

import wzorce.behawioralne.polecenie.Zadanie5.Jednostka;

public class Atakuj implements Polecenie {
    private final Jednostka jednostka;

    public Atakuj(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public void wykonaj() {
        jednostka.atakuj();
    }

    @Override
    public void cofnij() {
        jednostka.wycofaj();
    }
}
