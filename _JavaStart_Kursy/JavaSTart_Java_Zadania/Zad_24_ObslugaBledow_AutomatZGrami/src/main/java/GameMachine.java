import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameMachine {
    private List<Game> games;

    public GameMachine() {
        this.games = addGames();
    }

    private List<Game> addGames() {
        List<Game> games = new ArrayList<>();
        games.add(new Game("GTA5", 329.0));
        games.add(new Game("Wiedźmin III", 130.0));
        games.add(new Game("Forza", 249.0));
        games.add(new Game("Minionki", 140.5));
        games.add(new Game("Euro Truck Simulator 2", 100.0));
        games.add(new Game("Mafia", 189.90));
        return games;
    }

    public Game buyGame(String name) {
        if (isGameExists(name)) {
            int i = getIndexByName(name);
            return games.remove(i);
        }
        return null;
    }

    private int getIndexByName(String name) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return games.indexOf(game);
            }
        }
        return 0;
    }

    private boolean isGameExists(String name) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return games.stream().map(Game::toString).collect(Collectors.joining());
    }
}
