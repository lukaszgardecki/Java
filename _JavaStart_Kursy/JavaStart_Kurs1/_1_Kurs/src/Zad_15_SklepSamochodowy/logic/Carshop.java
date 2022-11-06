package Zad_15_SklepSamochodowy.logic;

import Zad_15_SklepSamochodowy.data.Car;

class Carshop {
    public static void main(String[] args) {
        Car audiA5 = new Car(2014, "Audi", "A5", "Czarne");
        Car audiA4 = new Car(2015, "Audi", "A4");

        audiA4.setColor("Czerwony");
    }
}
