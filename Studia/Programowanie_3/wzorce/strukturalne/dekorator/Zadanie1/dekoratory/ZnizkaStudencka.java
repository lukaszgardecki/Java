package wzorce.strukturalne.dekorator.Zadanie1.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie1.napoje.Napoj;

public class ZnizkaStudencka extends DodatekDekorator {

    public ZnizkaStudencka(Napoj napoj) {
        super(napoj);
    }

    @Override
    public double koszt() {
        return super.koszt() * 0.9;
    }

    @Override
    public String opis() {
        return super.opis() + " + zniżka studencka";
    }
}
