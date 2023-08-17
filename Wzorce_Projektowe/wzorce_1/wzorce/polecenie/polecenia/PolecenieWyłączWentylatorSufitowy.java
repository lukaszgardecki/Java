package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.WentylatorSufitowy;

public class PolecenieWyłączWentylatorSufitowy implements Polecenie{
    private WentylatorSufitowy wentylatorSufitowy;

    public PolecenieWyłączWentylatorSufitowy(WentylatorSufitowy wentylatorSufitowy) {
        this.wentylatorSufitowy = wentylatorSufitowy;
    }

    @Override
    public void wykonaj() {
        wentylatorSufitowy.wyłącz();
    }

    @Override
    public void wycofaj() {
//        wentylatorSufitowy.włącz();
    }
}
