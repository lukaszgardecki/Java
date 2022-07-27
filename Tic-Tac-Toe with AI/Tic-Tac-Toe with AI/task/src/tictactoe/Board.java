package tictactoe;

public class Board {
    static String[][] table = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "} };
    static final String SIGN_X = "X";
    static final String SIGN_O = "O";
    static final String SIGN_EMPTY = " ";
    static String currentPlayer;

    //Getters
    public static String getSignX() {
        return SIGN_X;
    }
    public static String getSignO() {
        return SIGN_O;
    }
    public static String getSignEmpty() {
        return SIGN_EMPTY;
    }
    public static String getCurrentPlayer() {
        return currentPlayer;
    }
    public static String[][] getTable() {
        return table;
    }

    //Setters
    public static void setCurrentPlayer(String sign) {
        currentPlayer = sign;
    }





    //display the board
    public static void displayBoard() {
        System.out.println("---------");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    System.out.print("| ");
                }
                System.out.print(table[i-1][j-1] + " ");

                if (j == 3) {
                    System.out.print("| ");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }



    // put a sign on the board
    public static void insertSign(int cor1, int cor2) {
        int amountX = countXs();
        int amountO = countOs();

        boolean areNumbersFromOneToThree = (cor1 >=1 && cor1 <=3) && (cor2 >=1 && cor2 <=3);
        if (areNumbersFromOneToThree) {
            String field = getTable()[cor1-1][cor2-1];
            boolean isEmpty = field.equals(SIGN_EMPTY);
            if (isEmpty && amountX <= amountO) {
                table[cor1-1][cor2-1] = getSignX();
                setCurrentPlayer(SIGN_X);
                displayBoard();
            } else if (isEmpty) {
                table[cor1-1][cor2-1] = getSignO();
                setCurrentPlayer(SIGN_O);
                displayBoard();

            } else {
                Message.display(4);
            }
        } else {
            Message.display(3);
        }
    }


    public static int countFreeFields() {
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(table[i][j].equals(getSignEmpty())) counter++;
            }
        }
        return counter;
    }
    public static int countXs() {
        int amountX = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(table[i][j].equals(getSignX())) amountX++;
            }
        }
        return amountX;
    }
    public static int countOs() {
        int amountO = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(table[i][j].equals(getSignO())) amountO++;
            }
        }
        return amountO;
    }
}
