package wzorce.strategia2.model;

import wzorce.strategia2.interfejs.Knife;

public class Queen extends Char {

    public Queen() {
        weapon = new Knife();
    }

    @Override
    public void displayWeapon() {
        System.out.printf("Broń Królowej: %s%n", weapon.getName());
    }

    @Override
    public void fight() {
        System.out.println("Queen is fighting!");
    }
}
