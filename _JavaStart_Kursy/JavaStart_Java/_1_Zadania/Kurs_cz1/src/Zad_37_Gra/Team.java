package Zad_37_Gra;

class Team {
    private GameCharacter[] characters = new GameCharacter[3];
    private int playersInTeam = 0;
    private double totalAttack;
    private double totalDefense;
    private double totalEnergy;
    private String name;

    public Team(String name) {
        this.name = name;
    }

    void add(GameCharacter gameCharacter) {
        if (playersInTeam == characters.length) {
            System.out.println("Nie mo¿na dodaæ gracza. Osi¹gniêto maksymaln¹ liczbê graczy w dru¿ynie.");
        }
        characters[playersInTeam] = gameCharacter;
        totalAttack += gameCharacter.getTotalAttack();
        totalDefense += gameCharacter.getTotalDefense();
        totalEnergy += gameCharacter.getEnergy();
        playersInTeam++;
    }


    void attack(Team team) {
        team.setTotalEnergy(team.getTotalEnergy() - this.getTotalAttack() + team.getTotalDefense());
    }

    double getTotalAttack() {
        return totalAttack;
    }

    double getTotalDefense() {
        return totalDefense;
    }

    double getTotalEnergy() {
        return totalEnergy;
    }

    public void setTotalEnergy(double totalEnergy) {
        this.totalEnergy = totalEnergy;
    }

    public String getName() {
        return name;
    }
}
