package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.WieżaStereo;

public class PolecenieWyłączWieżaStereo implements Polecenie{
    private WieżaStereo wieżaStereo;

    public PolecenieWyłączWieżaStereo(WieżaStereo wieżaStereo) {
        this.wieżaStereo = wieżaStereo;
    }

    @Override
    public void wykonaj() {
        wieżaStereo.wyłącz();
    }

    @Override
    public void wycofaj() {
        wieżaStereo.włącz();
    }
}
