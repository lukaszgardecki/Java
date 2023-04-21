package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.WentylatorSufitowy;

public class PolecenieWłączWentylatorSufitowySzybko implements Polecenie{
    private WentylatorSufitowy wentylatorSufitowy;
    private int poprzedniaSzybkość;

    public PolecenieWłączWentylatorSufitowySzybko(WentylatorSufitowy wentylatorSufitowy) {
        this.wentylatorSufitowy = wentylatorSufitowy;
    }

    @Override
    public void wykonaj() {
        poprzedniaSzybkość = wentylatorSufitowy.pobierzPrędkość();
        wentylatorSufitowy.włączWysokieObroty();
    }

    @Override
    public void wycofaj() {
        if (poprzedniaSzybkość == WentylatorSufitowy.SZYBKO) {
            wentylatorSufitowy.włączWysokieObroty();
        } else if (poprzedniaSzybkość == WentylatorSufitowy.ŚREDNIO) {
            wentylatorSufitowy.włączŚrednieObroty();
        } else if (poprzedniaSzybkość == WentylatorSufitowy.WOLNO) {
            wentylatorSufitowy.włączNiskieObroty();
        } else if (poprzedniaSzybkość == WentylatorSufitowy.WYŁĄCZ) {
            wentylatorSufitowy.wyłącz();
        }
    }
}
