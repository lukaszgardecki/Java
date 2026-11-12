package wzorce.strukturalne.dekorator.Zadanie4.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie4.Postac;

public class MiksturaSily extends EkwipunekDekorator {

    public MiksturaSily(Postac postac) {
        super(postac);
    }

    @Override
    public int atak() {
        return super.atak() + 5;
    }

    @Override
    public int obrona() {
        return super.obrona() + 5;
    }

    @Override
    public String opis() {
        return super.opis() + " po miksturze siły";
    }
}
