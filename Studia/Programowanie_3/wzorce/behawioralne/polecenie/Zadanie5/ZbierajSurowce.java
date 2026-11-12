package wzorce.behawioralne.polecenie.Zadanie5;

public class ZbierajSurowce implements Polecenie {
    private final Jednostka jednostka;

    ZbierajSurowce(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public void wykonaj() {
        jednostka.zbierajSurowce();
    }

    @Override
    public void cofnij() {
        jednostka.oddajSurowce();
    }
}
