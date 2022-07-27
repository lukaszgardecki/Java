package tictactoe;

public class Message {
    public static void display(int number) {
        switch (number) {
            case 1 -> System.out.print("Enter the coordinates: ");
            case 2 -> System.out.println("You should enter numbers!");
            case 3 -> System.out.println("Coordinates should be from 1 to 3!");
            case 4 -> System.out.println("This cell is occupied! Choose another one!");
            case 5 -> System.out.println("Draw");
            case 6 -> System.out.println("Game not finished");
            case 7 -> System.out.printf("%s wins\n", Board.getCurrentPlayer());
            case 8 -> System.out.println("Making move level \"easy\"");
            case 9 -> System.out.println("Input command: ");
            case 10 -> System.out.println("Bad parameters!");
        }
    }
}
