package wzorce.behawioralne.polecenie.Zadanie5.polecenia;

import wzorce.behawioralne.polecenie.Zadanie5.Jednostka;

public class Buduj implements Polecenie {
    private final Jednostka jednostka;

    public Buduj(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public void wykonaj() {
        jednostka.buduj();
    }

    @Override
    public void cofnij() {
        jednostka.rozbierz();
    }
}
