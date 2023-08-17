package wzorce.polecenie.polecenia;

import wzorce.polecenie.obiektyRealizujące.DrzwiGarażowe;

public class PolecenieOtwórzDrzwiGarażowe implements Polecenie{
    private DrzwiGarażowe drzwiGarażowe;

    public PolecenieOtwórzDrzwiGarażowe(DrzwiGarażowe drzwiGarażowe) {
        this.drzwiGarażowe = drzwiGarażowe;
    }

    @Override
    public void wykonaj() {
        drzwiGarażowe.doGóry();
    }

    @Override
    public void wycofaj() {
        drzwiGarażowe.naDół();
    }
}
