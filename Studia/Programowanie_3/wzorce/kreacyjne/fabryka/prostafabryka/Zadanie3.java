package wzorce.kreacyjne.fabryka.prostafabryka;

/**
 * Zadanie 3: Tworzenie postaci w grze RPG
 *
 * Cel: ćwiczenie fabryki w kontekście gier - pokazanie, jak można centralizować logikę tworzenia obiektów
 *
 * - stwórz fabrykę CharacterFactory, która tworzy różne typy postaci (Warrior, Mage, Archer) implementujące interfejs Character
 * - Rozszerzenie: dodaj możliwość przekazywania parametrów (np. poziom, broń) do fabryki
 */
public class Zadanie3 {
    public static void main(String[] args) {
        Character c1 = CharacterFactory.createCharacter(CharacterType.WARRIOR, 2, Weapon.SWORD);
        Character c2 = CharacterFactory.createCharacter(CharacterType.MAGE, 60, Weapon.WAND);
        Character c3 = CharacterFactory.createCharacter(CharacterType.ARCHER, 34, Weapon.BOW);

        c1.attack();
        c2.attack();
        c3.attack();
    }
}

class CharacterFactory {
    static Character createCharacter(CharacterType type, int level, Weapon weapon) {
        return switch(type) {
            case CharacterType.WARRIOR -> new Warrior(level, weapon);
            case CharacterType.MAGE -> new Mage(level, weapon);
            case CharacterType.ARCHER -> new Archer(level, weapon);
        };
    }
}

enum CharacterType { WARRIOR, MAGE, ARCHER }
enum Weapon { SWORD, WAND, BOW }

abstract class Character {
    protected int level;
    protected Weapon weapon;

    protected Character(int level, Weapon weapon) {
        this.level = level;
        this.weapon = weapon;
    }

    abstract void attack();
}

class Warrior extends Character {

    Warrior(int level, Weapon weapon) {
        super(level, weapon);
    }

    @Override
    public void attack() {
        System.out.printf("Wojownik [%s lvl] atakuje z [%s]\n", level, weapon);
    }
}

class Mage extends Character {

    Mage(int level, Weapon weapon) {
        super(level, weapon);
    }

    @Override
    public void attack() {
        System.out.printf("Mag [%s lvl] atakuje z [%s]\n", level, weapon);
    }
}

class Archer extends Character {

    Archer(int level, Weapon weapon) {
        super(level, weapon);
    }

    @Override
    public void attack() {
        System.out.printf("Paladyn [%s lvl] atakuje z [%s]\n", level, weapon);
    }
}
