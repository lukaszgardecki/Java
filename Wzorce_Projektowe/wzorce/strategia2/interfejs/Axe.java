package wzorce.strategia2.interfejs;

public class Axe implements Weapon {
    @Override
    public void useWeapon() {
        System.out.println("Axe fighting!");
    }

    @Override
    public String getName() {
        return "axe";
    }

}
