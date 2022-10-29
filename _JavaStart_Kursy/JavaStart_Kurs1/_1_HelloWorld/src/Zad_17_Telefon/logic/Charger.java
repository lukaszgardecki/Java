package Zad_17_Telefon.logic;

import Zad_17_Telefon.model.Telephone;

public class Charger {
    public void charge(Telephone telephone) {
        telephone.setChargeLevel(telephone.getChargeLevel() + 1);
    }
}
