package wzorce.behawioralne.polecenie.Zadanie5;

public class BronSie implements Polecenie {
    private final Jednostka jednostka;

    BronSie(Jednostka jednostka) {
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
