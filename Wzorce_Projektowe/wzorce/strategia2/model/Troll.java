package wzorce.strategia2.model;

import wzorce.strategia2.interfejs.Axe;

public class Troll extends Char {

    public Troll() {
        weapon = new Axe();
    }

    @Override
    public void displayWeapon() {
        System.out.printf("Broń Trolla: %s%n", weapon.getName());
    }

    @Override
    public void fight() {
        System.out.println("Troll is fighting!");
    }
}
