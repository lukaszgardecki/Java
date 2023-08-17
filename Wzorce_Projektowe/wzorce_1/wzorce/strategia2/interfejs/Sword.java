package wzorce.strategia2.interfejs;

public class Sword implements Weapon{

    @Override
    public void useWeapon() {
        System.out.println("Sword fighting!");
    }

    @Override
    public String getName() {
        return "sword";
    }
}
