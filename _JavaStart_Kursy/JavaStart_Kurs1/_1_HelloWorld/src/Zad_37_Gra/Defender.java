package Zad_37_Gra;

class Defender extends GameCharacter {
    private double defenseBonus;

    public Defender(String name, double energy, double attack, double defense, double defenseBonus) {
        super(name, energy, attack, defense);
        this.defenseBonus = defenseBonus;
    }

    @Override
    double getTotalDefense() {
        return super.getTotalDefense() * (1 + defenseBonus);
    }
}
