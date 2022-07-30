package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameController controller;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input command: ");
            String[] command = scanner.nextLine().split(" ");
            if (command.length != 3 && !command[0].equals("exit")) {
                System.out.println("Bad parameters!");
            } else if (command[0].equals("exit")) {
                break;
            } else {
                if (command[0].equals("start")) {
                    if (Players.fromString(command[1]) && Players.fromString(command[2])) {
                        controller = new GameController(command[1], command[2]);
                        controller.startGame();
                    } else {
                        System.out.println("Bad parameters!");
                    }
                } else {
                    System.out.println("Bad parameters!");
                }
            }
        }
    }
}

















//package tictactoe;
//
//import java.util.Scanner;
//
//public class Main {
//    static int game;
//
//    public static void main(String[] args) {
//        play();
//    }
//
//    public static void play() {
//        Player player = new Player();
//        AI ai = new AI();
//
//        while (true) {
//            selectGame();
//
//            if (game == 0) break;
//            Board.displayBoard();
//
//            while (true) {
//                try {
//                    int amountBefore = Board.countOs() + Board.countXs();
//                    int amountAfter = amountBefore;
//                    while(amountBefore == amountAfter) {
//                        if (game == 1 || game == 5 || game == 6 || game == 7) player.makeMove();
//                        if (game == 2 || game == 8 || game == 9 || game == 11) ai.makeMove(1);
//                        if (game == 3 || game == 10 || game == 12 || game == 14) ai.makeMove(2);
//                        if (game == 4 || game == 13 || game == 15 || game == 16) ai.makeMove(3);
//                        amountAfter = Board.countOs() + Board.countXs();
//                    }
//
//                    boolean isDraw = Board.countFreeFields() == 0;
//                    boolean isWin = checkWinner();
//                    if (isWin) {
//                        Message.display(7);
//                        break;
//                    } else if (isDraw) {
//                        Message.display(5);
//                        break;
//                    }/* else {
//                    Message.display(6);
//                }*/
//
//                    amountBefore = Board.countOs() + Board.countXs();
//                    amountAfter = amountBefore;
//                    while(amountBefore == amountAfter) {
//                        if (game == 1 || game == 11 || game == 12 || game == 13) player.makeMove();
//                        if (game == 2 || game == 5 || game == 14 || game == 15) ai.makeMove(1);
//                        if (game == 3 || game == 6 || game == 8 || game == 16) ai.makeMove(2);
//                        if (game == 4 || game == 7 || game == 9 || game == 10) ai.makeMove(3);
//                        amountAfter = Board.countOs() + Board.countXs();
//                    }
//
//                    isDraw = Board.countFreeFields() == 0;
//                    isWin = checkWinner();
//                    if (isWin) {
//                        Message.display(7);
//                        break;
//                    } else if (isDraw) {
//                        Message.display(5);
//                        break;
//                    }
//
//
//                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
//                    Message.display(2);
//                }
//
//
//
//
//
//
//
//
//
//
//
//            }
//            Board.table = Board.clearBoard();
//        }
//    }
//
//    public static void selectGame() {
//        Scanner scanner = new Scanner(System.in);
//        while(true) {
//            try {
//                Message.display(9);
//                String[] inputTab = scanner.nextLine().split("\\s+");
//
//                //je¿eli pierwsze s³owo to start
//                if (inputTab[0].equalsIgnoreCase("START")) {
//                    if (    inputTab[1].equalsIgnoreCase("USER") && inputTab[2].equalsIgnoreCase("USER")) {
//                        game = 1;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("EASY") && inputTab[2].equalsIgnoreCase("EASY")) {
//                        game = 2;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("MEDIUM") && inputTab[2].equalsIgnoreCase("MEDIUM")) {
//                        game = 3;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("HARD") && inputTab[2].equalsIgnoreCase("HARD")) {
//                        game = 4;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("USER") && inputTab[2].equalsIgnoreCase("EASY")) {
//                        game = 5;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("USER") && inputTab[2].equalsIgnoreCase("MEDIUM")) {
//                        game = 6;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("USER") && inputTab[2].equalsIgnoreCase("HARD")) {
//                        game = 7;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("EASY") && inputTab[2].equalsIgnoreCase("MEDIUM")) {
//                        game = 8;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("EASY") && inputTab[2].equalsIgnoreCase("HARD")) {
//                        game = 9;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("MEDIUM") && inputTab[2].equalsIgnoreCase("HARD")) {
//                        game = 10;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("EASY") && inputTab[2].equalsIgnoreCase("USER")) {
//                        game = 11;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("MEDIUM") && inputTab[2].equalsIgnoreCase("USER")) {
//                        game = 12;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("HARD") && inputTab[2].equalsIgnoreCase("USER")) {
//                        game = 13;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("MEDIUM") && inputTab[2].equalsIgnoreCase("EASY")) {
//                        game = 14;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("HARD") && inputTab[2].equalsIgnoreCase("EASY")) {
//                        game = 15;
//                        break;
//                    } else if (inputTab[1].equalsIgnoreCase("HARD") && inputTab[2].equalsIgnoreCase("MEDIUM")) {
//                        game = 16;
//                        break;
//                    }
//
//
//
//
//
//
//                    else {
//                        Message.display(10);
//                    }
//                } else if (inputTab[0].equalsIgnoreCase("EXIT")) {
//                    game = 0;
//                    break;
//                } else {
//                    Message.display(10);
//                }
//            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
//                Message.display(10);
//                game = 0;
//            }
//        }
//    }
//
//
//
//
//    //is someone won?
//    public static boolean checkWinner() {
//        boolean win1 = false;
//        boolean win2 = false;
//        boolean win3;
//        boolean win4;
//        String x = Board.getSignX();
//        String o = Board.getSignO();
//        String[][] tab = Board.getTable();
//
//        for (int i = 0; i < 3; i++) {
//
//            win1 = tab[i][0].equals(x) && tab[i][1].equals(x) && tab[i][2].equals(x)
//                    || tab[i][0].equals(o) && tab[i][1].equals(o) && tab[i][2].equals(o);
//            if (win1) break;
//            win2 = tab[0][i].equals(x) && tab[1][i].equals(x) && tab[2][i].equals(x)
//                    || tab[0][i].equals(o) && tab[1][i].equals(o) && tab[2][i].equals(o);
//            if (win2)  break;
//        }
//        win3 = tab[0][0].equals(x) && tab[1][1].equals(x) && tab[2][2].equals(x)
//                || tab[0][0].equals(o) && tab[1][1].equals(o) && tab[2][2].equals(o);
//        win4 = tab[2][0].equals(x) && tab[1][1].equals(x) && tab[0][2].equals(x)
//                || tab[2][0].equals(o) && tab[1][1].equals(o) && tab[0][2].equals(o);
//        return win1 || win2 || win3 || win4;
//    }
//
//    public static boolean checkWinner(String[][] ta) {
//        boolean win1 = false;
//        boolean win2 = false;
//        boolean win3;
//        boolean win4;
//        String x = Board.getSignX();
//        String o = Board.getSignO();
//
//        for (int i = 0; i < 3; i++) {
//            win1 = ta[i][0].equals(x) && ta[i][1].equals(x) && ta[i][2].equals(x)
//                    || ta[i][0].equals(o) && ta[i][1].equals(o) && ta[i][2].equals(o);
//            if (win1) break;
//            win2 = ta[0][i].equals(x) && ta[1][i].equals(x) && ta[2][i].equals(x)
//                    || ta[0][i].equals(o) && ta[1][i].equals(o) && ta[2][i].equals(o);
//            if (win2)  break;
//        }
//        win3 = ta[0][0].equals(x) && ta[1][1].equals(x) && ta[2][2].equals(x)
//                || ta[0][0].equals(o) && ta[1][1].equals(o) && ta[2][2].equals(o);
//        win4 = ta[2][0].equals(x) && ta[1][1].equals(x) && ta[0][2].equals(x)
//                || ta[2][0].equals(o) && ta[1][1].equals(o) && ta[0][2].equals(o);
//        return win1 || win2 || win3 || win4;
//    }
//
//
//}
