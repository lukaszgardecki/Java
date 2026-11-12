package wzorce.dekorator.Zadanie1.dekoratory;

import wzorce.dekorator.Zadanie1.napoje.Napoj;

public class Mleko extends DodatekDekorator {

    public Mleko(Napoj napoj) {
        super(napoj);
    }

    @Override
    public double koszt() {
        return super.koszt() + 2;
    }

    @Override
    public String opis() {
        return super.opis() + " + mleko";
    }
}
