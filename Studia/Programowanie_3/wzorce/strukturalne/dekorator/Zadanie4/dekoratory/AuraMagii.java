package wzorce.strukturalne.dekorator.Zadanie4.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie4.Postac;

public class AuraMagii extends EkwipunekDekorator {

    public AuraMagii(Postac postac) {
        super(postac);
    }

    @Override
    public int atak() {
        return super.atak() + 3;
    }

    @Override
    public int obrona() {
        return super.obrona() + 4;
    }

    @Override
    public String opis() {
        return super.opis() + " po aurze magii";
    }
}
