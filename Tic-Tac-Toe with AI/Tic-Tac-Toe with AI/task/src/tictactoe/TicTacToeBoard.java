package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeBoard {
    private final char[][] board;
    private char currentPlayerMark;

    public TicTacToeBoard() {
        this.board = new char[3][3];
        for (char[] chars : this.board) {
            Arrays.fill(chars, '_');
        }

        this.currentPlayerMark = 'X';
    }

    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    isFull = false;
                    break;
                }
            }
        }

        return isFull;
    }

    public boolean checkForWin() {
        return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return checkRowCol(board[0][0], board[1][1], board[2][2])
                || checkRowCol(board[0][2], board[1][1], board[2][0]);
    }

    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '_') && (c1 == c2) && (c2 == c3));
    }

    public boolean checkRowColForTwoInRow(char mark, int ... numbers) {
        boolean cell1equality = board[numbers[0]][numbers[1]] == mark;
        boolean cell2equality = board[numbers[2]][numbers[3]] == mark;
        boolean cell3equality = board[numbers[4]][numbers[5]] == mark;
        if (board[numbers[0]][numbers[1]] != '_' &&
                board[numbers[2]][numbers[3]] != '_' &&
                board[numbers[4]][numbers[5]] != '_') {
            return false;
        }

        return cell1equality && (cell2equality || cell3equality) || (cell2equality && cell3equality);
    }

    public void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        }
        else {
            currentPlayerMark = 'X';
        }
    }

    public boolean placeMark(int row, int col) {
        if (board[row][col] == '_') {
            board[row][col] = currentPlayerMark;
            return true;
        }

        return false;
    }

    public void undo(int row, int col) {
        board[row][col] = '_';
    }

    public List<String> getAvailableCells() {
        List<String> cells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    cells.add(i + " " + j);
                }
            }
        }

        return cells;
    }
}
