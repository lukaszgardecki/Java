package wzorce.dekorator.dekoratory;

import wzorce.dekorator.składnikiGłówne.Napój;

public class MleczkoSojowe extends SkładnikDekorator {
    private Napój napój;

    public MleczkoSojowe(Napój napój) {
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
        return napój.pobierzOpis() + ", Mleczko Sojowe";
    }

    @Override
    public int pobierzWielkość() {
        return napój.pobierzWielkość();
    }
}
