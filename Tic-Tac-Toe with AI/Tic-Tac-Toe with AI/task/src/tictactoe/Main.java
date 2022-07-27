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


        int gameNum = selectGame();

        Board.displayBoard();

        while(true) {
            try {
                player.makeMove();


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

            ai.makeMove();

        }
    }

    public static int selectGame() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> menuTab = new ArrayList<>();


        Message.display(9);
        String[] inputTab = scanner.nextLine().split("\\s+");
        


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
