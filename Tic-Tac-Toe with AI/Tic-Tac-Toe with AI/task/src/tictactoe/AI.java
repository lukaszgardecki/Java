package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AI {
    Random random = new Random();
    String x = Board.getSignX();
    String o = Board.getSignO();
    String curPl = Board.getCurrentPlayer();
    String oppSign = curPl;
    String mySign = curPl.equals(x) ? o : x;
    String freeField = Board.getSignEmpty();
    String[][] tab = Board.getTable();
    int c1;
    int c2;

    public void makeMove(int difficulty) {
        if (difficulty == 1) {
            easy();
        }
        if (difficulty == 2) {
            medium();
        }
    }

    void easy() {
        randomMove();
        Message.display(8);
        Board.insertSign(c1 + 1, c2 + 1);
    }

    void randomMove() {
        int freeFields = Board.countFreeFields();
        ArrayList<String> freeFieldsList = new ArrayList<>(freeFields);
        int aiChoice = random.nextInt(freeFields);

        //dodaj wspó³rzêdne wolnych pól do listy
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j].equals(Board.getSignEmpty())) {
                    String cords = "" + i + j;
                    freeFieldsList.add(cords);
                }
            }
        }
        String choice = freeFieldsList.get(aiChoice);
        c1 = Integer.parseInt(String.valueOf(choice.charAt(0)));
        c2 = Integer.parseInt(String.valueOf(choice.charAt(1)));
    }

    void medium() {
        loop1:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 0 && j == 0) {
                    //check diagonals
                    // if I already have two in row - win the game:
                    if (tab[2][2].equals(freeField) && tab[0][0].equals(mySign) && tab[1][1].equals(mySign)) {
                        System.out.println("");
                        c1 = 2;
                        c2 = 2;
                        break loop1;
                    } else if (tab[1][1].equals(freeField) && tab[0][0].equals(mySign) && tab[2][2].equals(mySign)) {
                        c1 = 1;
                        c2 = 1;
                        break loop1;
                    } else if (tab[0][0].equals(freeField) && tab[1][1].equals(mySign) && tab[2][2].equals(mySign)) {
                        c1 = 0;
                        c2 = 0;
                        break loop1;
                    } else if (tab[0][2].equals(freeField) && tab[2][0].equals(mySign) && tab[1][1].equals(mySign)) {
                        c1 = 0;
                        c2 = 2;
                        break loop1;
                    } else if (tab[1][1].equals(freeField) && tab[2][0].equals(mySign) && tab[0][2].equals(mySign)) {
                        c1 = 1;
                        c2 = 1;
                        break loop1;
                    } else if (tab[2][0].equals(freeField) && tab[1][1].equals(mySign) && tab[0][2].equals(mySign)) {
                        c1 = 2;
                        c2 = 0;
                        break loop1;
                    }
                    // if player has two in row - block him
                    if (tab[2][2].equals(freeField) && tab[0][0].equals(oppSign) && tab[1][1].equals(oppSign)) {
                        c1 = 2;
                        c2 = 2;
                        break loop1;
                    } else if (tab[1][1].equals(freeField) && tab[0][0].equals(oppSign) && tab[2][2].equals(oppSign)) {
                        c1 = 1;
                        c2 = 1;
                        break loop1;
                    } else if (tab[0][0].equals(freeField) && tab[1][1].equals(oppSign) && tab[2][2].equals(oppSign)) {
                        c1 = 0;
                        c2 = 0;
                        break loop1;
                    } else if (tab[0][2].equals(freeField) && tab[2][0].equals(oppSign) && tab[1][1].equals(oppSign)) {
                        c1 = 0;
                        c2 = 2;
                        break loop1;
                    } else if (tab[1][1].equals(freeField) && tab[2][0].equals(oppSign) && tab[0][2].equals(oppSign)) {
                        c1 = 1;
                        c2 = 1;
                        break loop1;
                    } else if (tab[2][0].equals(freeField) && tab[1][1].equals(oppSign) && tab[0][2].equals(oppSign)) {
                        c1 = 2;
                        c2 = 0;
                        break loop1;
                    }
                }
                if (i == 0) {
                    // if I already have two in row - win the game:
                    if (tab[j][i].equals(freeField) && tab[j][1].equals(mySign) && tab[j][2].equals(mySign)){
                        //System.out.println("opcja 1");
                        c1 = j;
                        c2 = i;
                        break loop1;
                    } else if (tab[i][j].equals(freeField) && tab[1][j].equals(mySign) && tab[2][j].equals(mySign)) {
                        //System.out.println("opcja 2");
                        c1 = i;
                        c2 = j;
                        break loop1;
                    }
                    // if player has two in row - block him
                    else if (tab[j][i].equals(freeField) && tab[j][1].equals(oppSign) && tab[j][2].equals(oppSign)){
                        //System.out.println("opcja 3");
                        c1 = j;
                        c2 = i;
                        break loop1;
                    } else if (tab[i][j].equals(freeField) && tab[1][j].equals(oppSign) && tab[2][j].equals(oppSign)) {
                        //System.out.println("opcja 4");
                        c1 = i;
                        c2 = j;
                        break loop1;
                    }
                } else if (i == 1) {
                    // if I already have two in row - win the game:
                    if (tab[j][i].equals(freeField) && tab[j][0].equals(mySign) && tab[j][2].equals(mySign)){
                        //System.out.println("opcja 5");
                        c1 = j;
                        c2 = i;
                        break loop1;
                    } else if (tab[i][j].equals(freeField) && tab[0][j].equals(mySign) && tab[2][j].equals(mySign)) {
                        //System.out.println("opcja 6");
                        c1 = i;
                        c2 = j;
                        break loop1;
                    }
                    // if player has two in row - block him
                    else if (tab[j][i].equals(freeField) && tab[j][0].equals(oppSign) && tab[j][2].equals(oppSign)) {
                        //System.out.println("opcja 7");
                        c1 = j;
                        c2 = i;
                        break loop1;
                    } else if (tab[i][j].equals(freeField) && tab[0][j].equals(oppSign) && tab[2][j].equals(oppSign)) {
                        //System.out.println("opcja 8");
                        c1 = i;
                        c2 = j;
                        break loop1;
                    }
                } else {
                    // if I already have two in row - win the game:
                    if (tab[j][i].equals(freeField) && tab[j][0].equals(mySign) && tab[j][1].equals(mySign)) {
                        //System.out.println("opcja 9");
                        c1 = j;
                        c2 = i;
                        break loop1;
                    } else if (tab[i][j].equals(freeField) && tab[0][j].equals(mySign) && tab[1][j].equals(mySign)) {
                        //System.out.println("opcja 10");
                        c1 = i;
                        c2 = j;
                        break loop1;
                    }
                    // if player has two in row - block him
                    else if (tab[j][i].equals(freeField) && tab[j][0].equals(oppSign) && tab[j][1].equals(oppSign)) {
                        //System.out.println("opcja 11");
                        c1 = j;
                        c2 = i;
                        break loop1;
                    } else if (tab[i][j].equals(freeField) && tab[0][j].equals(oppSign) && tab[1][j].equals(oppSign)) {
                        //System.out.println("opcja 12");
                        c1 = i;
                        c2 = j;
                        break loop1;
                    }
                    // else make a random move
                    else {
                        System.out.println("i=2easy");
                        randomMove();
                        break;
                    }
                }
            }
        }
        Message.display(11);
        Board.insertSign(c1 + 1, c2 + 1);
    }

    void hard() {
        //minimax
        String[][] OriginBoard = Board.getTable();



        for (int i = 0; i < Board.countFreeFields(OriginBoard); i++) {
            String[][] CopyBoard = Arrays.copyOf(OriginBoard, OriginBoard.length);




        }
    }
}
