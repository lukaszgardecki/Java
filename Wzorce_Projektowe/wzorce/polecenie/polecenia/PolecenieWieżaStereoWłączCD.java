package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.WieżaStereo;

public class PolecenieWieżaStereoWłączCD implements Polecenie{
    private WieżaStereo wieżaStereo;

    public PolecenieWieżaStereoWłączCD(WieżaStereo wieżaStereo) {
        this.wieżaStereo = wieżaStereo;
    }

    @Override
    public void wykonaj() {
        wieżaStereo.włącz();
        wieżaStereo.ustawCD();
        wieżaStereo.ustawGłośność(11);
    }

    @Override
    public void wycofaj() {
        wieżaStereo.ustawGłośność(0);
        wieżaStereo.wyłącz();
    }
}
