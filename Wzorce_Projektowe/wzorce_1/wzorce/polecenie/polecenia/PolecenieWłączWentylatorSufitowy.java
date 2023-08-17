package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.WentylatorSufitowy;

public class PolecenieWłączWentylatorSufitowy implements Polecenie{
    private WentylatorSufitowy wentylatorSufitowy;

    public PolecenieWłączWentylatorSufitowy(WentylatorSufitowy wentylatorSufitowy) {
        this.wentylatorSufitowy = wentylatorSufitowy;
    }

    @Override
    public void wykonaj() {
//        wentylatorSufitowy.włącz();
    }

    @Override
    public void wycofaj() {
        wentylatorSufitowy.wyłącz();
    }
}
