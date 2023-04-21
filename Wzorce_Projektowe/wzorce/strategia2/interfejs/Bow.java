package wzorce.strategia2.interfejs;

public class Bow implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("Bow fighting!");
    }

    @Override
    public String getName() {
        return "bow";
    }
}
