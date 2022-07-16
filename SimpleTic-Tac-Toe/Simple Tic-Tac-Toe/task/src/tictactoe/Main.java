package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        String[] coor;
        int xs, os;
        boolean entry, winner;
        int firstEl, secondEl;


        // 1. Wyœwietl planszê:
        displayGrid (board);

        xs = countX(board);
        os = countO(board);

        while (xs + os < 9) {
            do {
                System.out.print("Enter the coordinates: ");
                coor = scanner.nextLine().split(" ");
                entry = checkCoordinates(coor, board);
            } while (!entry);

            firstEl = Integer.parseInt(coor[0]) - 1;
            secondEl = Integer.parseInt(coor[1]) - 1;


            //zmieñ znak i wyœwietl planszê:
            changeSign(board, firstEl, secondEl);
            displayGrid(board);

            xs = countX(board);
            os = countO(board);

            winner = isWinner(board, xs, os);
            if (winner) {
                break;
            }
        }
    }

    //metoda wyœwietlaj¹ca planszê
    public static void displayGrid(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    //metoda licz¹ca znaki 'X'
    public static int countX (char[][] board) {
        int xs = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    xs++;
                }
            }
        }
        return xs;
    }

    //metoda licz¹ca znaki 'O'
    public static int countO (char[][] board) {
        int xo = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'O') {
                    xo++;
                }
            }
        }
        return xo;
    }

    //metoda sprawdzaj¹ca, czy elementy w tablicy s¹ liczbami
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //metoda sprawdzaj¹ca wprowadzone wspó³rzêdne
    public static boolean checkCoordinates (String[] coordinates, char[][] board) {
        //sprawdŸ, czy u¿ytkownik wprowadzi³ dwie liczby:
        boolean twoEl = coordinates.length == 2;
        boolean ent = false;

        if (twoEl) {
            boolean firstIsNumeric = isNumeric(coordinates[0]);
            boolean secondIsNumeric = isNumeric(coordinates[1]);

            if (firstIsNumeric && secondIsNumeric) {
                int firstEl = Integer.parseInt(coordinates[0]) - 1;
                int secondEl = Integer.parseInt(coordinates[1]) - 1;

                //sprawdzenie, czy wprowadzone dwa elementy mieszcz¹ siê w tablicy:
                if (firstEl >= board.length || secondEl >= board.length) {
                    //je¿eli nie mieszcz¹ siê:
                    displayMessage(1);
                    //je¿eli mieszcz¹ siê:
                } else if (board[firstEl][secondEl] == 'X' || board[firstEl][secondEl] == 'O') {
                    // sprawdzenie, czy pole jest wolne
                    displayMessage(2);

                } else {
                    //wszystko jest mo¿na wstawiæ X na planszê:
                    //TEST:
                    //System.out.println("Wstawiono X");
                    ent = true;
                }
            } else {
                //je¿eli s¹ dwa elementy w tablicy, ale jeden (lub oba) nie s¹ liczbami:
                displayMessage(3);
            }
        } else if (isNumeric(coordinates[0])) {
            //je¿eli wprowadzony element jest liczb¹:
            displayMessage(4);
        }
        else {
            //je¿eli wprowadzony element nie jest liczb¹:
            displayMessage(3);
        }

        return ent;
    }


    //metoda, która zamienia znak w tablicy
    public static void changeSign(char[][] board, int frstEl, int scEl) {
        int x = countX(board);
        int o = countO(board);

        switch (x + o) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
                board[frstEl][scEl] = 'X';
                break;
            case 1:
            case 3:
            case 5:
            case 7:
                board[frstEl][scEl] = 'O';
                break;
        }
    }


    //metoda sprawdzaj¹ca stan gry i wyœwietlaj¹ca komunikat czy ktoœ wygra³
    public static boolean isWinner(char[][] board, int xs, int os) {

        int sum1 = board[0][0] + board[0][1] + board[0][2];
        int sum2 = board[1][0] + board[1][1] + board[1][2];
        int sum3 = board[2][0] + board[2][1] + board[2][2];
        int sum4 = board[0][0] + board[1][0] + board[2][0];
        int sum5 = board[0][1] + board[1][1] + board[2][1];
        int sum6 = board[0][2] + board[1][2] + board[2][2];
        int sum7 = board[0][0] + board[1][1] + board[2][2];
        int sum8 = board[0][2] + board[1][1] + board[2][0];
        boolean isWinner = false;
        boolean xWin = false;
        boolean oWin = false;

        if (sum1 == 264 || sum2 == 264 || sum3 == 264 || sum4 == 264 || sum5 == 264 || sum6 == 264 || sum7 == 264 || sum8 == 264) {
            xWin = true;
        }
        if (sum1 == 237 || sum2 == 237 || sum3 == 237 || sum4 == 237 || sum5 == 237 || sum6 == 237 || sum7 == 237 || sum8 == 237) {
            oWin = true;
        }

//        if (Math.abs(xs-os) > 1 || (xWin && oWin)) {
//            System.out.println("Impossible");
//        }
//        else if ((xs + os) < 9 && xWin == false && oWin == false) {
//            System.out.println("Game not finished");
//        } else

        if ((xs + os) <= 9 && xWin) {
            displayMessage(5);
        }  else if ((xs + os) <= 9 && oWin) {
            displayMessage(6);
        }
        if (xs + os == 9 && xWin == false && oWin == false) {
            displayMessage(7);
        }

        if (xWin || oWin) {
            isWinner = true;
        }

        return isWinner;
    }


    //metoda wyœwietlaj¹ca komunikaty:
    public static void displayMessage(int messNum) {
        switch (messNum) {
            case 1:
                System.out.println("Coordinates should be from 1 to 3!");
                break;
            case 2:
                System.out.println("This cell is occupied! Choose another one!");
                break;
            case 3:
                System.out.println("You should enter numbers!");
                break;
            case 4:
                System.out.println("You should enter 2 numbers!");
                break;
            case 5:
                System.out.println("X wins");
                break;
            case 6:
                System.out.println("O wins");
                break;
            case 7:
                System.out.println("Draw");
        }
    }


}