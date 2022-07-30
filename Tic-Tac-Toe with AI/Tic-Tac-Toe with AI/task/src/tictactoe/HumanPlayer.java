package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(TicTacToeBoard board) {
        super(board);
        this.board = board;
    }

    @Override
    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the coordinates: ");
            String coordinatesString = scanner.nextLine();

            try {
                int rawCoordinate1 = Integer.parseInt(coordinatesString.split(" ")[0], 10);
                int rawCoordinate2 = Integer.parseInt(coordinatesString.split(" ")[1], 10);

                if (rawCoordinate1 > 3 || rawCoordinate2 > 3 || rawCoordinate1 < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (!board.placeMark(rawCoordinate1 -1, rawCoordinate2 -1)) {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
