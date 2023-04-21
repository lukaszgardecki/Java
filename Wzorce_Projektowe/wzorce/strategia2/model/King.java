package wzorce.strategia2.model;

import wzorce.strategia2.interfejs.Sword;

public class King extends Char {

    public King() {
        weapon = new Sword();
    }

    @Override
    public void displayWeapon() {
        System.out.printf("Broń Króla: %s%n", weapon.getName());
    }

    @Override
    public void fight() {
        System.out.println("King is fighting!");
    }
}
