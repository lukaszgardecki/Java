package wzorce.strategia2.model;

import wzorce.strategia2.interfejs.Bow;

public class Knight extends Char {

    public Knight() {
        weapon = new Bow();
    }

    @Override
    public void displayWeapon() {
        System.out.printf("Broń Rycerza: %s%n", weapon.getName());
    }

    @Override
    public void fight() {
        System.out.println("Knight is fighting!");
    }
}
