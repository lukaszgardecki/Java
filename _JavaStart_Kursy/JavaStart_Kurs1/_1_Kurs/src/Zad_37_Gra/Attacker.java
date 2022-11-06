package Zad_37_Gra;

class Attacker extends GameCharacter {
    private double attackBonus;

    public Attacker(String name, double energy, double attack, double defense, double attackBonus) {
        super(name, energy, attack, defense);
        this.attackBonus = attackBonus;
    }

    @Override
    double getTotalAttack() {
        return super.getTotalAttack() * (1 + attackBonus);
    }
}
