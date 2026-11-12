package wzorce.dekorator.Zadanie1.dekoratory;

import wzorce.dekorator.Zadanie1.napoje.Napoj;

public abstract class DodatekDekorator implements Napoj {
    protected final Napoj napoj;

    protected DodatekDekorator(Napoj napoj) {
        if (napoj == null) {
            throw new IllegalArgumentException("napoj nie moze byc null");
        }
        this.napoj = napoj;
    }

    @Override
    public double koszt() {
        return napoj.koszt();
    }

    @Override
    public String opis() {
        return napoj.opis();
    }
}
