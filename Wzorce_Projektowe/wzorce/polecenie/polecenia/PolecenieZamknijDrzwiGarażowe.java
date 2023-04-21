package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.DrzwiGarażowe;

public class PolecenieZamknijDrzwiGarażowe implements Polecenie{
    private DrzwiGarażowe drzwiGarażowe;

    public PolecenieZamknijDrzwiGarażowe(DrzwiGarażowe drzwiGarażowe) {
        this.drzwiGarażowe = drzwiGarażowe;
    }

    @Override
    public void wykonaj() {
        drzwiGarażowe.naDół();
    }

    @Override
    public void wycofaj() {
        drzwiGarażowe.doGóry();
    }
}
