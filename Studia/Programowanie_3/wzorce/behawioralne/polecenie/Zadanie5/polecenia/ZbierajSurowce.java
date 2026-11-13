package wzorce.behawioralne.polecenie.Zadanie5.polecenia;

import wzorce.behawioralne.polecenie.Zadanie5.Jednostka;

public class ZbierajSurowce implements Polecenie {
    private final Jednostka jednostka;

    public ZbierajSurowce(Jednostka jednostka) {
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
