package battleship;

public class Battlefield {
    private static final int X = 10;
    private static final int Y = 10;
    private static final char FIELD_CHAR = '~';
    private static final char SHIP_CHAR = 'O';
    private static final char MISS_CHAR = 'M';
    private static final char HIT_CHAR = 'X';
    private static int axisXstart = 1;
    private static char axisYstart = 'A';
    private static String[][] board = new String[getX()+1][getY()+1];
    private static String[][] fogBoard = new String[getX()+1][getY()+1];

    public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public static String[][] getBoard() {
        return board;
    }

    public static String[][] getFogBoard() {
        return fogBoard;
    }

    public static char getFieldChar() {
        return FIELD_CHAR;
    }

    public static char getShipChar() {
        return SHIP_CHAR;
    }

    public static char getMissChar() {
        return MISS_CHAR;
    }

    public static char getHitChar() {
        return HIT_CHAR;
    }

    public static int getAxisXstart() {
        return axisXstart;
    }

    public static char getAxisYstart() {
        return axisYstart;
    }

    public void createBattlefield() {
        for(int i = 0; i <= getX(); i++) {
            for(int j = 0; j <= getY(); j++) {
                if(i == 0 && j == 0) {
                    board[i][j] = " ";
                    fogBoard[i][j] = " ";
                    continue;
                }
                if(i == 0) {
                    board[i][j] = String.valueOf(axisXstart);
                    fogBoard[i][j] = String.valueOf(axisXstart);
                    axisXstart++;
                    continue;
                }
                if(j == 0) {
                    board[i][j] = Character.toString(axisYstart);
                    fogBoard[i][j] = Character.toString(axisYstart);
                    axisYstart++;
                } else {
                    board[i][j] =Character.toString(FIELD_CHAR);
                    fogBoard[i][j] =Character.toString(FIELD_CHAR);
                }
            }
        }
        displayBattlefield();
    }

    public static int countIfShipIsHit() {
        int counter = 0;
        for (int i = 1; i <= getX(); i++) {
            for (int j = 1; j <= getY(); j++) {
                //je�eli znak na tablicy to "O"(okr�t) to licz
                if (getFogBoard()[i][j].charAt(0) == getHitChar() ) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int countShips() {
        int counter = 0;
        for (int i = 1; i <= getX(); i++) {
            for (int j = 1; j <= getY(); j++) {
                //je�eli znak na tablicy to "O"(okr�t) to licz
                if (getBoard()[i][j].charAt(0) == getShipChar() ) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void displayFogBattlefield() {
        for (String[] row : fogBoard) {
            for (String field: row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }

    public static void displayBattlefield() {
        for (String[] row : board) {
            for (String field: row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }

    //za�o�enie: do funkcji trafiaj� POPRAWNE koordynaty (trzeba je wcze�niej sprawdzi�)
    public static void changeSign(String from, String to) {
        // FROM
        char firstCharFrom = from.charAt(0); //"np. D"
        int firstIndexFrom = returnCoordinate(from);
        int secIndexFrom = Integer.parseInt(from.substring(1)); // 4

        //TO
        char firstCharTo = to.charAt(0); // "D"
        int firstIndexTo = returnCoordinate(to);
        int secIndexTo = Integer.parseInt(to.substring(1)); // 6

        for (int i = 1; i <= getX(); i++) { //po osi poziomej
            for (int j = 1; j <= getY(); j++) { //po osi pionowej


                if (board[j][0].charAt(0) == firstCharFrom && board[j][0].charAt(0) == firstCharTo) {
                    //to statek b�dzie w poziomie
                    for (int k = secIndexFrom; k <= secIndexTo; k++) {
                        board[j][k] = Character.toString(SHIP_CHAR);
                    }
                    break;
                } else if (Integer.parseInt(board[0][i]) == secIndexFrom && Integer.parseInt(board[0][i]) == secIndexTo) {
                    //to statek b�dzie w pionie
                    for (int k = firstIndexFrom; k <= firstIndexTo; k++) {
                        board[k][i] = Character.toString(SHIP_CHAR);;
                    }
                    break;
                }
            }
        }
    }

    // Metoda szuka litery w tablicy (o� A-J) i zwraca jej indeks
    public static int returnCoordinate(String cor) {
        char firstChar = cor.charAt(0); // == E
        int x = 0;

        for (int i = 1; i <= getY(); i++) {
            if (board[i][0].charAt(0) == firstChar) {
                x = i;
                break;
            }
        }
        return x;
    }

    //metoda sprawdzaj�ca, czy mamy wystarczaj�co miejsca na polu, �eby wstawi� statek
    public static boolean isEnoughPlace(String from, String to) {
        boolean answer = false;
        int fromInd1 = returnCoordinate(from);
        int fromInd2 = Integer.parseInt(from.substring(1));
        int toInd1 = returnCoordinate(to);
        int toInd2 = Integer.parseInt(to.substring(1));

        //warunki brzegowe
        boolean w1 = fromInd1 == 1;                                 //start [1,-]
        boolean w2 = fromInd1 == getY();                            //start [10,-]
        boolean w3 = fromInd2 == 1;                                 //start [-,1]
        boolean w4 = fromInd2 == getX();                            //start [-,10]
        boolean w5 = w1 && w3;                                      //start [1,1]
        boolean w6 = w1 && w4;                                      //start [1, 10]
        boolean w7 = w2 && w3;                                      //start [10, 1]
        boolean w8 = toInd1 == getY();                              //koniec [10,-]
        boolean w9 = toInd2 == getX();                              //koniec [-,10]
        boolean w10 = w8 && w9;                                     //koniec [10,10]
        boolean w11 = w8 && toInd2 == 1;                            //koniec [10,1]
        boolean w12 = toInd1 == 1 && w9;                            //koniec [1,10]

        if(fromInd1 == toInd1) {
            //je�eli warunek spe�niony, to statek jest poziomy
            int fields = toInd2 - fromInd2 + 1;

            for(int k = 0; k < fields; k++) {
                //stworzenie krzy�a sprawdzaj�cego
                boolean c0 = (  (fromInd2 + k <= getX()) &&
                                board[fromInd1][fromInd2 + k].charAt(0) == FIELD_CHAR     ); //�rodek

                boolean c1 = (  (fromInd1-1 >= 1) &&
                                (fromInd2 + k <= getX()) &&
                                board[fromInd1-1][fromInd2+k].charAt(0) == FIELD_CHAR    ); // g�ra

                boolean c2 = (  (fromInd2+1+k <= getX()) &&
                                board[fromInd1][fromInd2+1+k].charAt(0) == FIELD_CHAR    ); // prawo

                boolean c3 = (  fromInd1+1 <= getY() &&
                                (fromInd2 + k <= getX()) &&
                                board[fromInd1+1][fromInd2+k].charAt(0) == FIELD_CHAR    ); // d�

                boolean c4 = (  fromInd2-1+k >= 1 &&
                                fromInd2-1+k <= getX() &&
                                board[fromInd1][fromInd2-1+k].charAt(0) == FIELD_CHAR    ); // lewo

                boolean cAll = c0 && c1 && c2 && c3 && c4; //pe�ny krzy�

                if (w5) {                            //start [1,1] - start z lewego g�rnego rogu
                    answer = c0 && c2 && c3;
                } else if (w7) {                     //start [10, 1] - start z lewego dolnego rogu
                    answer = c0 && c1 && c2;
                } else if (w12) {                    //koniec [1,10] - koniec w g�rnym prawym rogu
                    answer = c0 && c3 && c4;
                } else if (w10) {                    //koniec [10,10] - koniec w dolnym prawym rogu
                    answer = c0 && c1 && c4;
                } else if (w1) {                     //start [1,-] - start z g�rnego rz�du
                    answer = c0 && c2 && c3 && c4;
                } else if (w3) {                     //start [-,1] - start z lewej strony
                    answer = c0 && c1 && c2 && c3;
                } else if (w2) {                     //start [10,-] - start z dolnego rz�du
                    answer = c0 && c1 && c2 && c4;
                } else if (w9) {                     //koniec [-,10] - koniec z prawej strony
                    answer = c0 && c1 && c3 && c4;
                } else answer = cAll;                  //start i koniec w �rodku pola - sprawd� pe�ny krzy�

                //je�eli, w kt�rymkolwiek przej�ciu p�tli, answer b�dzie r�wna� si� false to zwr�� false
                if(!answer) {
                    break;
                }
            }

        } else if(fromInd2 == toInd2) {
            //je�eli warunek jest spe�niony, to statek jest pionowy
            int fields = toInd1 - fromInd1 + 1;

            for(int k = 0; k < fields; k++) {
                //stworzenie krzy�a sprawdzaj�cego
                boolean c0 = (  (fromInd1 + k <= getY()) &&
                                board[fromInd1 + k][fromInd2].charAt(0) == FIELD_CHAR     ); //�rodek

                boolean c1 = (  (fromInd1-1 + k >= 1) &&
                                board[fromInd1-1 + k][fromInd2].charAt(0) == FIELD_CHAR    ); // g�ra

                boolean c2 = (  (fromInd2+1 <= getX()) &&
                                board[fromInd1 + k][fromInd2+1].charAt(0) == FIELD_CHAR    ); // prawo

                boolean c3 = (  fromInd1+1 + k <= getY() &&
                                board[fromInd1+1 + k][fromInd2].charAt(0) == FIELD_CHAR    ); // d�

                boolean c4 = (  fromInd2-1 >= 1 &&
                                board[fromInd1 + k][fromInd2-1].charAt(0) == FIELD_CHAR    ); // lewo

                boolean cAll = c0 && c1 && c2 && c3 && c4; //pe�ny krzy�

                if (w5) {                            //start [1,1] - start z lewego g�rnego rogu
                    answer = c0 && c2 && c3;
                } else if (w6) {                     //start [1,10] - start z prawego g�rnego rogu
                    answer = c0 && c3 && c4;
                } else if (w10) {                    //koniec [10,10] - koniec w dolnym prawym rogu
                    answer = c0 && c1 && c4;
                } else if (w11) {                    //koniec [10,1] - koniec w dolnym lewym rogu
                    answer = c0 && c1 && c2;
                } else if (w1) {                     //start [1,-] - start z g�rnego rz�du
                    answer = c0 && c2 && c3 && c4;
                } else if (w3) {                     //start [-,1] - start z lewej strony
                    answer = c0 && c1 && c2 && c3;
                } else if (w4) {                     //start [-,10] - start z prawej strony
                    answer = c0 && c1 && c3 && c4;
                } else if (w8) {                     //koniec [10,-] - koniec w dolnym rz�dzie
                    answer = c0 && c1 && c2 && c4;
                } else answer = cAll;                //start i koniec w �rodku pola - sprawd� pe�ny krzy�

                //je�eli, w kt�rymkolwiek przej�ciu p�tli, answer b�dzie r�wna� si� false to zwr�� false
                if (!answer) {
                    break;
                }
            }
        }
        //je�li nie ma miejsca to wy�wietl komunikat
        if(!answer) {
            Main.displayMessage(4);
        }

        return answer;
    }

}
