package wzorce.behawioralne.polecenie.Zadanie5;

public class Buduj implements Polecenie {
    private final Jednostka jednostka;

    Buduj(Jednostka jednostka) {
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
