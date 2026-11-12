package wzorce.strukturalne.dekorator.Zadanie4.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie4.Postac;

public abstract class EkwipunekDekorator implements Postac {
    protected Postac opakowanaPostac;

    protected EkwipunekDekorator(Postac postac) {
        this.opakowanaPostac = postac;
    }

    @Override
    public int atak() {
        return opakowanaPostac.atak();
    }

    @Override
    public int obrona() {
        return opakowanaPostac.obrona();
    }

    @Override
    public String opis() {
        return opakowanaPostac.opis();
    }
}
