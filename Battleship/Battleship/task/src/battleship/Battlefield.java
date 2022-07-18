package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battlefield {





    static String[] coordTab = new String[3];
    private List<List<String>> lists = new ArrayList<>();
    List<Ship> ships = new ArrayList<>();

    private static final int X = 10;
    private static final int Y = 10;
    private static final char FIELD_CHAR = '~';
    private static final char SHIP_CHAR = 'O';
    private static final char MISS_CHAR = 'M';
    private static final char HIT_CHAR = 'X';
    private int axisXstart = 1;
    private char axisYstart = 'A';
    private String[][] board = new String[getX()+1][getY()+1];
    private String[][] fogBoard = new String[getX()+1][getY()+1];

    public static int getX() {
        return X;
    }

    public static int getY() {
        return Y;
    }

    public String[][] getBoard() {
        return board;
    }

    public String[][] getFogBoard() {
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

    public static char getHitChar()  {
        return HIT_CHAR;
    }

    public int getAxisXstart() {
        return axisXstart;
    }

    public char getAxisYstart() {
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
                    board[i][j] = Character.toString(FIELD_CHAR);
                    fogBoard[i][j] = Character.toString(FIELD_CHAR);
                }
            }
        }
    }

    public void displayBattlefield() {
        for (String[] row : board) {
            for (String field: row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }

    public void displayFogBattlefield() {
        for (String[] row : fogBoard) {
            for (String field: row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }
    }












    public void addShips(Battlefield OOO) {
//        Main.ships.add(new Ship ("Aircraft Carrier", 5));
//        Main.ships.add(new Ship ("Battleship", 4));
//        Main.ships.add(new Ship ("Submarine", 3));
//        Main.ships.add(new Ship ("Cruiser", 3));
        ships.add(new Ship ("Destroyer", 2));


        for (Ship ship : ships) {
            addShipToBattlefield(ship,OOO);
        }
    }












    public void addShipToBattlefield(Ship sh, Battlefield OOO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        Main.displayMessage(1, sh);
        System.out.println();

        while (true) {
            String coordinates = scanner.nextLine();
            boolean verified = checkCoordinates(coordinates, sh);

            if (verified) {
                boolean isPlace = isEnoughPlace(coordTab[0], coordTab[1]);
                if(isPlace) {
                    sh.addCoordsToShipList(sh, coordTab[0], coordTab[1], OOO); // przypisz statkowi swoje koordynaty
                    changeSign(coordTab[0], coordTab[1]); //zmieñ znak na mapie
                    lists.add(sh.getCords()); // listê z koordynatami dodaj do ogólnej listy koordynatów
                    break;
                }
            }
            System.out.println();
        }

        System.out.println();
        displayBattlefield();
    }








    // Metoda sprawdzaj¹ca wprowadzone koordynaty
    public boolean checkCoordinates(String coordinates, Ship ship) {
        boolean isGOOD;
        try {
            // 0. ILOŒÆ KOORDYNATÓW MUSI BYÆ ZAWSZE 2
            String[] entryTab = coordinates.trim().split("\\s+"); //tablica zawiera wprowadzone elementy
            String[] corTab = {entryTab[0], entryTab[1]}; //tablica zawiera tylko dwa elementy

            // 1. WIELKOŒÆ LITER A-J, zamiana na wielkie litery
            corTab[0] = corTab[0].toUpperCase();
            corTab[1] = corTab[1].toUpperCase();
            char firstCharFrom = corTab[0].charAt(0); //konwersja na char, ¿eby wyci¹n¹æ inta
            char firstCharTo = corTab[1].charAt(0); //konwersja na char, ¿eby wyci¹n¹æ inta

            // 2. WARTOŒÆ LICZBY PO LITERZE
            int secIndexFrom = Integer.parseInt(corTab[0].substring(1));
            int secIndexTo = Integer.parseInt(corTab[1].substring(1));
            boolean b1 = false, b2 = false, b3 = false, b4 = false;

            //je¿eli wartoœæ liczby jest wiêksza od dopuszczalnej to ustaw najwiêksz¹ mo¿liw¹
            if (secIndexFrom > getX()) {
                secIndexFrom = getX();
                b1 = true;
            }
            //je¿eli wartoœæ liczby jest mniejsza ni¿ 1 to ustaw j¹ na 1
            else if (secIndexFrom < 1) {
                secIndexFrom = 1;
                b2 = true;
            }
            //je¿eli wartoœæ liczby jest wiêksza od dopuszczalnej to ustaw najwiêksz¹ mo¿liw¹
            if (secIndexTo > getX()) {
                secIndexTo = getX();
                b3 = true;
            }
            //je¿eli wartoœæ liczby jest mniejsza ni¿ 1 to ustaw j¹ na 1
            else if (secIndexTo < 1) {
                secIndexTo = 1;
                b4 = true;
            }
            //je¿eli, któraœ z wartoœci jest nieprawid³owa to wyœwietl komunikat
            if (b1 || b2 || b3 || b4) {
                throw new Exception();
            }

            //je¿eli próbuje siê ustawiæ statek nie w linii prostej
            if (secIndexFrom != secIndexTo && firstCharFrom != firstCharTo) {
                throw new Exception();
            }

            // 3. KOLEJNOSÆ ! SPRAWDZENIE CZY PIERWSZY ARGUMENT JEST ZAWSZE MNIEJSZY NI¯ DRUGI
            int fromValue = (int) firstCharFrom + secIndexFrom; // ogólna wartoœæ koordynatu na podstawie ASCII
            int toValue = (int) firstCharTo + secIndexTo; // ogólna wartoœæ koordynatu na podstawie ASCII

            if (fromValue > toValue) {
                String tmp1 = corTab[0];
                corTab[0] = corTab[1];
                corTab[1] = tmp1;
            }

            coordTab[0] = corTab[0];
            coordTab[1] = corTab[1];
            isGOOD = true;

        } catch (Exception e) {
            Main.displayMessage(3);
            isGOOD = false;
        }

        // 4. SPRAWDZENIE CZY ZGADZA SIÊ PODANA D£UGOŒÆ STATKU
        if (isGOOD) {
            int rowIndexFrom = returnCoordinate(coordTab[0]);
            int rowIndexTo = returnCoordinate(coordTab[1]);
            int columnIndexFrom = Integer.parseInt(coordTab[0].substring(1));
            int columnIndexTo = Integer.parseInt(coordTab[1].substring(1));

            int customRowLength = rowIndexTo - rowIndexFrom + 1;
            int customColumnLength = columnIndexTo - columnIndexFrom + 1;

            if (customRowLength != ship.getFields() && customColumnLength != ship.getFields()) {
                Main.displayMessage(2, ship);
                isGOOD = false;
            }
        }

        return isGOOD;
    }





    // Metoda szuka litery w tablicy (oœ A-J) i zwraca jej indeks
    public int returnCoordinate(String cor) {
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




    //metoda sprawdzaj¹ca, czy mamy wystarczaj¹co miejsca na polu, ¿eby wstawiæ statek
    public boolean isEnoughPlace(String from, String to) {
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
            //je¿eli warunek spe³niony, to statek jest poziomy
            int fields = toInd2 - fromInd2 + 1;

            for(int k = 0; k < fields; k++) {
                //stworzenie krzy¿a sprawdzaj¹cego
                boolean c0 = (  (fromInd2 + k <= getX()) &&
                                board[fromInd1][fromInd2 + k].charAt(0) == FIELD_CHAR     ); //œrodek

                boolean c1 = (  (fromInd1-1 >= 1) &&
                                (fromInd2 + k <= getX()) &&
                                board[fromInd1-1][fromInd2+k].charAt(0) == FIELD_CHAR    ); // góra

                boolean c2 = (  (fromInd2+1+k <= getX()) &&
                                board[fromInd1][fromInd2+1+k].charAt(0) == FIELD_CHAR    ); // prawo

                boolean c3 = (  fromInd1+1 <= getY() &&
                                (fromInd2 + k <= getX()) &&
                                board[fromInd1+1][fromInd2+k].charAt(0) == FIELD_CHAR    ); // dó³

                boolean c4 = (  fromInd2-1+k >= 1 &&
                                fromInd2-1+k <= getX() &&
                                board[fromInd1][fromInd2-1+k].charAt(0) == FIELD_CHAR    ); // lewo

                boolean cAll = c0 && c1 && c2 && c3 && c4; //pe³ny krzy¿

                if (w5) {                            //start [1,1] - start z lewego górnego rogu
                    answer = c0 && c2 && c3;
                } else if (w7) {                     //start [10, 1] - start z lewego dolnego rogu
                    answer = c0 && c1 && c2;
                } else if (w12) {                    //koniec [1,10] - koniec w górnym prawym rogu
                    answer = c0 && c3 && c4;
                } else if (w10) {                    //koniec [10,10] - koniec w dolnym prawym rogu
                    answer = c0 && c1 && c4;
                } else if (w1) {                     //start [1,-] - start z górnego rzêdu
                    answer = c0 && c2 && c3 && c4;
                } else if (w3) {                     //start [-,1] - start z lewej strony
                    answer = c0 && c1 && c2 && c3;
                } else if (w2) {                     //start [10,-] - start z dolnego rzêdu
                    answer = c0 && c1 && c2 && c4;
                } else if (w9) {                     //koniec [-,10] - koniec z prawej strony
                    answer = c0 && c1 && c3 && c4;
                } else answer = cAll;                  //start i koniec w œrodku pola - sprawdŸ pe³ny krzy¿

                //je¿eli, w którymkolwiek przejœciu pêtli, answer bêdzie równaæ siê false to zwróæ false
                if(!answer) {
                    break;
                }
            }

        } else if(fromInd2 == toInd2) {
            //je¿eli warunek jest spe³niony, to statek jest pionowy
            int fields = toInd1 - fromInd1 + 1;

            for(int k = 0; k < fields; k++) {
                //stworzenie krzy¿a sprawdzaj¹cego
                boolean c0 = (  (fromInd1 + k <= getY()) &&
                                board[fromInd1 + k][fromInd2].charAt(0) == FIELD_CHAR     ); //œrodek

                boolean c1 = (  (fromInd1-1 + k >= 1) &&
                                board[fromInd1-1 + k][fromInd2].charAt(0) == FIELD_CHAR    ); // góra

                boolean c2 = (  (fromInd2+1 <= getX()) &&
                                board[fromInd1 + k][fromInd2+1].charAt(0) == FIELD_CHAR    ); // prawo

                boolean c3 = (  fromInd1+1 + k <= getY() &&
                                board[fromInd1+1 + k][fromInd2].charAt(0) == FIELD_CHAR    ); // dó³

                boolean c4 = (  fromInd2-1 >= 1 &&
                                board[fromInd1 + k][fromInd2-1].charAt(0) == FIELD_CHAR    ); // lewo

                boolean cAll = c0 && c1 && c2 && c3 && c4; //pe³ny krzy¿

                if (w5) {                            //start [1,1] - start z lewego górnego rogu
                    answer = c0 && c2 && c3;
                } else if (w6) {                     //start [1,10] - start z prawego górnego rogu
                    answer = c0 && c3 && c4;
                } else if (w10) {                    //koniec [10,10] - koniec w dolnym prawym rogu
                    answer = c0 && c1 && c4;
                } else if (w11) {                    //koniec [10,1] - koniec w dolnym lewym rogu
                    answer = c0 && c1 && c2;
                } else if (w1) {                     //start [1,-] - start z górnego rzêdu
                    answer = c0 && c2 && c3 && c4;
                } else if (w3) {                     //start [-,1] - start z lewej strony
                    answer = c0 && c1 && c2 && c3;
                } else if (w4) {                     //start [-,10] - start z prawej strony
                    answer = c0 && c1 && c3 && c4;
                } else if (w8) {                     //koniec [10,-] - koniec w dolnym rzêdzie
                    answer = c0 && c1 && c2 && c4;
                } else answer = cAll;                //start i koniec w œrodku pola - sprawdŸ pe³ny krzy¿

                //je¿eli, w którymkolwiek przejœciu pêtli, answer bêdzie równaæ siê false to zwróæ false
                if (!answer) {
                    break;
                }
            }
        }
        //jeœli nie ma miejsca to wyœwietl komunikat
        if(!answer) {
            Main.displayMessage(4);
        }

        return answer;
    }






    //za³o¿enie: do funkcji trafiaj¹ POPRAWNE koordynaty (trzeba je wczeœniej sprawdziæ)
    public void changeSign(String from, String to) {
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
                    //to statek bêdzie w poziomie
                    for (int k = secIndexFrom; k <= secIndexTo; k++) {
                        board[j][k] = Character.toString(SHIP_CHAR);
                    }
                    break;
                } else if (Integer.parseInt(board[0][i]) == secIndexFrom && Integer.parseInt(board[0][i]) == secIndexTo) {
                    //to statek bêdzie w pionie
                    for (int k = firstIndexFrom; k <= firstIndexTo; k++) {
                        board[k][i] = Character.toString(SHIP_CHAR);;
                    }
                    break;
                }
            }
        }
    }




















//    public int countIfShipIsHit() {
//        int counter = 0;
//        for (int i = 1; i <= getX(); i++) {
//            for (int j = 1; j <= getY(); j++) {
//                //je¿eli znak na tablicy to "O"(okrêt) to licz
//                if (getFogBoard()[i][j].charAt(0) == getHitChar() ) {
//                    counter++;
//                }
//            }
//        }
//        return counter;
//    }

//    public int countShips() {
//        int counter = 0;
//        for (int i = 1; i <= getX(); i++) {
//            for (int j = 1; j <= getY(); j++) {
//                //je¿eli znak na tablicy to "O"(okrêt) to licz
//                if (getBoard()[i][j].charAt(0) == getShipChar() ) {
//                    counter++;
//                }
//            }
//        }
//        return counter;
//    }


}
