package wzorce.dekorator.Zadanie4.dekoratory;

import wzorce.dekorator.Zadanie4.Postac;

public class TarczaEnergetyczna extends EkwipunekDekorator {

    public TarczaEnergetyczna(Postac postac) {
        super(postac);
    }

    @Override
    public int atak() {
        return super.atak() + 1;
    }

    @Override
    public int obrona() {
        return super.obrona() + 5;
    }

    @Override
    public String opis() {
        return super.opis() + " z tarczą energetyczną";
    }
}
