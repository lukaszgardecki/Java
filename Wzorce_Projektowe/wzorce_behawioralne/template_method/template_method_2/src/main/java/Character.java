public abstract class Character {
    protected String weapon;
    protected String safePlace;

    public void pickUpWeapon() {
        System.out.println("Pick up " + weapon);
    }

    public void defenseAction() {
        System.out.println("Defend with " + weapon);
    }

    public void moveToSafety() {
        System.out.println("Return to the " + safePlace);
    }

    public void defendAgainstAttack() {
        pickUpWeapon();
        defenseAction();
        moveToSafety();
        System.out.println();
    }
}
