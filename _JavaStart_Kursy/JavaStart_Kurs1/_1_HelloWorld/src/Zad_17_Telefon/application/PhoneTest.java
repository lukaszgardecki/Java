package Zad_17_Telefon.application;

import Zad_17_Telefon.logic.Charger;
import Zad_17_Telefon.model.Telephone;

public class PhoneTest {
    public static void main(String[] args) {
        Telephone telephone = new Telephone("Samsung", "Galaxy S10", 3400, 75);
        Charger charger = new Charger();


        System.out.println(telephone);
        charger.charge(telephone);
        charger.charge(telephone);
        charger.charge(telephone);
        charger.charge(telephone);
        charger.charge(telephone);
        System.out.println("Telefon po na³adowaniu:");
        System.out.println(telephone);
    }
}
