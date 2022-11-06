package Zad_37_Gra;

class GameCharacter {
    private String name;
    private double energy;
    private double attack;
    private double defense;

    public GameCharacter(String name, double energy, double attack, double defense) {
        this.name = name;
        this.energy = energy;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    double getTotalAttack() {
        return attack;
    }

    double getTotalDefense() {
        return defense;
    }


}
