package tictactoe;

public abstract class Player {
    TicTacToeBoard board;

    public Player(TicTacToeBoard board) {
        this.board = board;
    }

    abstract public void makeMove();
}
