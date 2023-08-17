package wzorce.strategia2.model;

import wzorce.strategia2.interfejs.Weapon;

public abstract class Char {
    Weapon weapon;

    public Char() {}

    public void fight() {
        weapon.useWeapon();
    }

    public abstract void displayWeapon();

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
