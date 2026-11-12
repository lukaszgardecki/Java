package wzorce.behawioralne.polecenie.Zadanie5;

public class Atakuj implements Polecenie {
    private final Jednostka jednostka;

    Atakuj(Jednostka jednostka) {
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
