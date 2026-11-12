package wzorce.strukturalne.dekorator.Zadanie1.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie1.napoje.Napoj;

public class Syrop extends DodatekDekorator {

    public Syrop(Napoj napoj) {
        super(napoj);
    }

    @Override
    public double koszt() {
        return super.koszt() + 0.5;
    }

    @Override
    public String opis() {
        return super.opis() + " + syrop";
    }
}
