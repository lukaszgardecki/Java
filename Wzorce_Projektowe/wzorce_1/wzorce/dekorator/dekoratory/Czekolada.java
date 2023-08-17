package wzorce.dekorator.dekoratory;

import wzorce.dekorator.składnikiGłówne.Napój;

public class Czekolada extends SkładnikDekorator {
    private Napój napój;

    public Czekolada(Napój napój) {
        this.napój = napój;
    }

    @Override
    public double koszt() {
        double koszt = napój.koszt();

        if (pobierzWielkość() == Napój.MAŁY) {
            koszt += 0.1;
        } else if (pobierzWielkość() == Napój.ŚREDNI) {
            koszt += 0.15;
        } else if (pobierzWielkość() == Napój.DUŻY) {
            koszt += 0.2;
        }
        return koszt;
    }

    @Override
    public String pobierzOpis() {
        return napój.pobierzOpis() + ", Czekolada";
    }

    @Override
    public int pobierzWielkość() {
        return napój.pobierzWielkość();
    }
}
