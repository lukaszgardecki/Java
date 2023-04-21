package wzorce.strategia2;

import wzorce.strategia2.interfejs.Axe;
import wzorce.strategia2.interfejs.Bow;
import wzorce.strategia2.interfejs.Knife;
import wzorce.strategia2.model.Char;
import wzorce.strategia2.model.King;
import wzorce.strategia2.model.Knight;
import wzorce.strategia2.model.Queen;

public class Game {
    public static void main(String[] args) {
        Char king = new King();
        king.fight();
        king.displayWeapon();
        king.setWeapon(new Bow());
        king.displayWeapon();

        Char queen = new Queen();
        queen.displayWeapon();
        queen.setWeapon(new Axe());
        queen.displayWeapon();
        queen.fight();

        Char knight = new Knight();
        knight.fight();
        knight.displayWeapon();
        knight.setWeapon(new Knife());
        knight.displayWeapon();
    }
}
