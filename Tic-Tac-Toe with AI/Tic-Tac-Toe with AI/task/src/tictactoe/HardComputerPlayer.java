package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class HardComputerPlayer extends Player {
    private String move;

    public HardComputerPlayer(TicTacToeBoard board) {
        super(board);
        this.board = board;
    }

    private int calculateBestMove(TicTacToeBoard board, int depth, Map<String, Integer> outcomes) {
        if (board.isBoardFull() && !board.checkForWin()) {
            return 0;
        } else if (board.checkForWin()) {
            return -1;
        } else {
            for (String space : board.getAvailableCells()) {
                board.placeMark(Character.getNumericValue(space.charAt(0)),
                        Character.getNumericValue(space.charAt(2)));
                board.changePlayer();
                outcomes.put(space, (-1 * calculateBestMove(board, depth + 1, new HashMap<>())));
                board.undo(Character.getNumericValue(space.charAt(0)),
                        Character.getNumericValue(space.charAt(2)));
                board.changePlayer();
            }

            if (depth == 0) {
                outcomes.entrySet().stream().max(Map.Entry.comparingByValue())
                        .ifPresent((val) -> move = val.getKey());
                return -1;
            } else {
                return outcomes.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
            }
        }
    }

    @Override
    public void makeMove() {
        System.out.println("Making move level \"hard\"");
        calculateBestMove(board, 0, new HashMap<>());
        board.placeMark(Character.getNumericValue(move.charAt(0)),
                Character.getNumericValue(move.charAt(2)));
    }
}
