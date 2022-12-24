import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMachineController {
    private GameMachine machine;
    private Scanner scanner = new Scanner(System.in);

    public GameMachineController(GameMachine machine) {
        this.machine = machine;
    }

    public void runShop() {
        printShopOffer();
        Game game = createGame();
        takeMoney(game);
    }

    private void printShopOffer() {
        System.out.println("Witaj w naszym sklepie!");
        System.out.println("Możesz kupić nastepujące gry:");
        System.out.println(machine);
    }

    private Game createGame() {
        Game game;
        String title;
        do {
            System.out.println("Podaj tytuł gry:");
            title = scanner.nextLine();
            game = machine.buyGame(title);
            if (game == null) {
                System.out.println("Nie znaleziono gry o takim tytule");
            }
        } while (game == null);
        return game;
    }

    private void takeMoney(Game game) {
        System.out.println("Wpłać pieniądze:");
        double amount = 0;

        do {
            try {
                amount += scanner.nextDouble();
                double price = game.getPrice();
                if (amount > price) {
                    double change = amount - price;
                    System.out.printf("""
                                    Odbierz grę: %s
                                    Odbierz resztę: %.2f zł
                                    """,
                            game.getName(), change);
                } else if (amount < price) {
                    double lack = price - amount;
                    System.out.printf("Gra kosztuje %.2fzł. Dopłać jeszcze %.2f zł.%n", game.getPrice(), lack);
                } else {
                    System.out.printf("Odbierz grę: %s", game.getName());
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadź liczbę!");
            }
            scanner.nextLine();
        } while (amount < game.getPrice());
        System.out.println("Dziękujemy za zakupy!");
    }
}
