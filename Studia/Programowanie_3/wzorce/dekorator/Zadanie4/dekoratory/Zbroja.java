package wzorce.dekorator.Zadanie4.dekoratory;

import wzorce.dekorator.Zadanie4.Postac;

public class Zbroja extends EkwipunekDekorator {

    public Zbroja(Postac postac) {
        super(postac);
    }

    @Override
    public int atak() {
        return super.atak();
    }

    @Override
    public int obrona() {
        return super.obrona() + 4;
    }

    @Override
    public String opis() {
        return super.opis() + " ze zbroją";
    }
}
