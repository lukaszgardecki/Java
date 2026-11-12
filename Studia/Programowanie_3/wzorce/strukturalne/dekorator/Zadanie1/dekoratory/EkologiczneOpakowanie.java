package wzorce.strukturalne.dekorator.Zadanie1.dekoratory;

import wzorce.strukturalne.dekorator.Zadanie1.napoje.Napoj;

public class EkologiczneOpakowanie extends DodatekDekorator {

    public EkologiczneOpakowanie(Napoj napoj) {
        super(napoj);
    }

    @Override
    public double koszt() {
        return super.koszt() + 0.4;
    }

    @Override
    public String opis() {
        return super.opis() + " + ekologiczne opakowanie";
    }
}
