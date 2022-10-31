package Zad_37_Gra;

class Game {
    Team team1;
    Team team2;

    public static void main(String[] args) {
        Game game = new Game();
        game.create();
        game.play();
    }

    private void create() {
        team1 = new Team("Atakuj¹cy");
        team2 = new Team("Broni¹cy");

        team1.add(new Attacker("Gracz1", 100, 20, 10, 0.25));
        team1.add(new Attacker("Gracz3", 100, 20, 10, 0.21));
        team1.add(new Defender("Gracz4", 100, 10, 20, 0.22));

        team2.add(new Attacker("Gracz2", 100, 20, 10, 0.44));
        team2.add(new Defender("Gracz5", 100, 10, 20, 0.2));
        team2.add(new Defender("Gracz6", 100, 10, 20, 0.18));
    }

    private void play() {
            team1.attack(team2);
            team2.attack(team1);
            showResults();
    }

    private void showResults() {
        System.out.println("Koniec gry!");
        if (team1.getTotalEnergy() > team2.getTotalEnergy()) {
            System.out.printf("Zwyciê¿yli %s! Pozosta³o punktów ¿ycia: %.2f\n", team1.getName(), team1.getTotalEnergy());
        } else if (team2.getTotalEnergy() > team1.getTotalEnergy()) {
            System.out.printf("Zwyciê¿yli %s! Pozosta³o punktów ¿ycia: %.2f\n", team2.getName(), team2.getTotalEnergy());
        } else {
            System.out.println("Remis.");
        }
    }



}
