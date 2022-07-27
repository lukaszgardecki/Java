package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        Player player = new Player();
        AI ai = new AI();

        while (true) {
            int gameNum = selectGame();
            if (gameNum == 0) break;
            Board.displayBoard();

            while (true) {
                try {


                    if (gameNum == 1) ai.makeMove();
                    ;
                    if (gameNum == 2 || gameNum == 3) player.makeMove();
                    ;


                    boolean isDraw = Board.countFreeFields() == 0;
                    boolean isWin = checkWinner();
                    if (isWin) {
                        Message.display(7);
                        break;
                    } else if (isDraw) {
                        Message.display(5);
                        break;
                    }/* else {
                    Message.display(6);
                }*/
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    Message.display(2);
                }

                if (gameNum == 1 || gameNum == 2) ai.makeMove();

            }
            Board.table = Board.clearBoard();
        }
    }

    public static int selectGame() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> menuTab = new ArrayList<>();
        int game;

        while(true) {
            try {
                Message.display(9);
                String[] inputTab = scanner.nextLine().split("\\s+");

                //je¿eli pierwsze s³owo to start
                if (inputTab[0].equalsIgnoreCase("START")) {

                    if (inputTab[1].equalsIgnoreCase("EASY") && inputTab[2].equalsIgnoreCase("EASY")) {
                        game = 1;
                        break;
                    } else if (inputTab[1].equalsIgnoreCase("USER") && inputTab[2].equalsIgnoreCase("EASY")
                            || inputTab[1].equalsIgnoreCase("EASY") && inputTab[2].equalsIgnoreCase("USER")) {
                        game = 2;
                        break;
                    } else if (inputTab[1].equalsIgnoreCase("USER") && inputTab[2].equalsIgnoreCase("USER")) {
                        game = 3;
                        break;
                    } else {
                        Message.display(10);
                    }

                } else if (inputTab[0].equalsIgnoreCase("EXIT")) {
                    game = 0;
                    break;
                } else {
                    Message.display(10);
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                Message.display(10);
                game = 0;
            }
        }

        return game;
    }




    //is someone won?
    public static boolean checkWinner() {
        boolean win1 = false;
        boolean win2 = false;
        boolean win3;
        boolean win4;
        String x = Board.getSignX();
        String o = Board.getSignO();
        String[][] tab = Board.getTable();

        for (int i = 0; i < 3; i++) {

            win1 = tab[i][0].equals(x) && tab[i][1].equals(x) && tab[i][2].equals(x)
                    || tab[i][0].equals(o) && tab[i][1].equals(o) && tab[i][2].equals(o);
            if (win1) break;
            win2 = tab[0][i].equals(x) && tab[1][i].equals(x) && tab[2][i].equals(x)
                    || tab[0][i].equals(o) && tab[1][i].equals(o) && tab[2][i].equals(o);
            if (win2)  break;
        }
        win3 = tab[0][0].equals(x) && tab[1][1].equals(x) && tab[2][2].equals(x)
                || tab[0][0].equals(o) && tab[1][1].equals(o) && tab[2][2].equals(o);
        win4 = tab[2][0].equals(x) && tab[1][1].equals(x) && tab[0][2].equals(x)
                || tab[2][0].equals(o) && tab[1][1].equals(o) && tab[0][2].equals(o);
        return win1 || win2 || win3 || win4;
    }


}
