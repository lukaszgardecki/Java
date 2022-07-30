package tictactoe;

import java.util.List;
import java.util.Random;

public class MediumComputerPlayer extends Player {
    private boolean isMoveMade = false;

    public MediumComputerPlayer(TicTacToeBoard board) {
        super(board);
        this.board = board;
    }

    private void processTwoInRow(int a1, int a2, int b1, int b2, int c1, int c2) {
        if (!board.placeMark(a1, a2)) {
            if (!board.placeMark(b1, b2)) {
                if (board.placeMark(c1, c2)) {
                    isMoveMade = true;
                }
            } else {
                isMoveMade = true;
            }
        } else {
            isMoveMade = true;
        }
    }

    private void checkForTwoInRow(char mark) {
        for (int i = 0; i < 3; i++) {
            if (board.checkRowColForTwoInRow(mark,
                    i, 0, i, 1, i, 2)) {
                processTwoInRow(i, 0, i, 1, i, 2);
            }
            if (isMoveMade) {
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board.checkRowColForTwoInRow(mark,
                    0, i, 1, i, 2, i)) {
                processTwoInRow(0, i, 1, i, 2, i);
            }
            if (isMoveMade) {
                return;
            }
        }

        if (board.checkRowColForTwoInRow(mark,
                0, 0, 1, 1, 2, 2)) {
            processTwoInRow(0, 0, 1, 1, 2, 2);
            if (isMoveMade) {
                return;
            }
        }

        if (board.checkRowColForTwoInRow(mark,
                0, 2, 1, 1, 2, 0)) {
            processTwoInRow(0, 2, 1, 1, 2, 0);
        }
    }

    @Override
    public void makeMove() {
        isMoveMade = false;
        System.out.println("Making move level \"medium\"");
        checkForTwoInRow(board.getCurrentPlayerMark());

        char enemyMark;
        if (board.getCurrentPlayerMark() == 'X') {
            enemyMark = 'O';
        }
        else {
            enemyMark = 'X';
        }
        checkForTwoInRow(enemyMark);

        if (!isMoveMade) {
            List<String> moves = board.getAvailableCells();
            String move = moves.get(new Random().nextInt(moves.size()));
            board.placeMark(Character.getNumericValue(move.charAt(0)),
                    Character.getNumericValue(move.charAt(2)));
        }
    }
}
