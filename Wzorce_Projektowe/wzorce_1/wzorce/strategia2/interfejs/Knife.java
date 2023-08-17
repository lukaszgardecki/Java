package wzorce.strategia2.interfejs;

public class Knife implements Weapon{
    @Override
    public void useWeapon() {
        System.out.println("Knife fighting!");
    }

    @Override
    public String getName() {
        return "knife";
    }
}
