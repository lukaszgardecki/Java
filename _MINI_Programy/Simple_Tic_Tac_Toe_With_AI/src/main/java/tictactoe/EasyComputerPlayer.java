package tictactoe;

import java.util.List;
import java.util.Random;

public class EasyComputerPlayer extends Player {
    public EasyComputerPlayer(TicTacToeBoard board) {
        super(board);
        this.board = board;
    }

    @Override
    public void makeMove() {
        System.out.println("Making move level \"easy\"");
        List<String> moves = board.getAvailableCells();
        String move = moves.get(new Random().nextInt(moves.size()));
        board.placeMark(Character.getNumericValue(move.charAt(0)),
                Character.getNumericValue(move.charAt(2)));
    }
}