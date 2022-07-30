package tictactoe;

public class GameController {
    private final Player playerOne;
    private final Player playerTwo;
    private final TicTacToeBoard board;

    public GameController(String playerOne, String playerTwo) {
        this.board = new TicTacToeBoard();
        this.playerOne = getClassByName(playerOne);
        this.playerTwo = getClassByName(playerTwo);
    }

    private Player getClassByName(String name) {
        switch (name) {
            case "user":
                return new HumanPlayer(board);
            case "easy":
                return new EasyComputerPlayer(board);
            case "medium":
                return new MediumComputerPlayer(board);
            case "hard":
                return new HardComputerPlayer(board);
        }

        return null;
    }

    public void startGame() {
        board.printBoard();
        while (true) {
            playerOne.makeMove();
            board.printBoard();
            if (board.checkForWin()) {
                System.out.printf("%s wins\n\n", board.getCurrentPlayerMark());
                break;
            } else if (board.isBoardFull()) {
                System.out.println("Draw\n");
                break;
            }
            board.changePlayer();

            playerTwo.makeMove();
            board.printBoard();
            if (board.checkForWin()) {
                System.out.printf("%s wins\n\n", board.getCurrentPlayerMark());
                break;
            } else if (board.isBoardFull()) {
                System.out.println("Draw\n");
                break;
            }
            board.changePlayer();
        }
    }
}
