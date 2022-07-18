package battleship;

import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Battlefield bf1 = new Battlefield();
    static Battlefield bf2 = new Battlefield();

    public static void main(String[] args) {

        displayMessage(13);
        bf1.createBattlefield();
        bf1.displayBattlefield();
        bf1.addShips(bf1);

        promptEnterKey();

        displayMessage(14);
        bf2.createBattlefield();
        bf2.displayBattlefield();
        bf2.addShips(bf2);


        playGame(bf1, bf2);

//        System.out.println("wyœweitalnie kontrolne");
//        bf1.displayBattlefield();
//        bf2.displayBattlefield();


    }
    // metoda, wktórej trzeba nacicn¹æ enter ¿eby przejœc dalej
    public static void promptEnterKey() {
        displayMessage(15);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void playGame(Battlefield bf1, Battlefield bf2) {

        //iloœæ pó³ do zbicia
        int shipFields1 = bf1.countShips();
        int shipFields2 = bf2.countShips();
        boolean noShipsMore;


        //displayMessage(5);
        //System.out.println();


        while(true) {
            int sunkField;

            player1turn(shipFields2);
            sunkField = bf2.countIfShipIsHit();
            noShipsMore = shipFields2 == sunkField;
            if (noShipsMore) break;


            player2turn(shipFields1);
            sunkField = bf1.countIfShipIsHit();
            noShipsMore = shipFields1 == sunkField;
            if (noShipsMore) break;
        }

    }


    public static void player1turn(int shipFields2) {
        promptEnterKey();
        bf2.displayFogBattlefield();
        System.out.println("---------------------");
        bf1.displayBattlefield();

        displayMessage(16);
        System.out.println();

        takeAshot(shipFields2, bf2);
    }

    public static void player2turn(int shipFields1) {
        promptEnterKey();
        bf1.displayFogBattlefield();
        System.out.println("---------------------");
        bf2.displayBattlefield();

        displayMessage(17);
        System.out.println();

        takeAshot(shipFields1, bf1);
    }















    public static void takeAshot(int shipFields, Battlefield bf) {
        Scanner scanner = new Scanner(System.in);

        String hitChar = Character.toString(Battlefield.getHitChar());
        String missChar = Character.toString(Battlefield.getMissChar());
        String shipChar = Character.toString(Battlefield.getShipChar());
        String water = Character.toString(Battlefield.getFieldChar());

        while(true) {
            String shotCoord = scanner.nextLine();
            boolean isVerified = checkShotCoord(shotCoord, bf);

            try {
                int row = bf.returnCoordinate(Battlefield.coordTab[2]);
                int col = Integer.parseInt(Battlefield.coordTab[2].substring(1));
                String fieldOnBoard = bf.getBoard()[row][col];
                //
                //String fieldOnFogBoard = Battlefield.getFogBoard()[row][col];
                //
                boolean shipIsHit = Objects.equals(fieldOnBoard, shipChar);
                boolean youMissed = Objects.equals(fieldOnBoard, water);
                boolean youAlreadyHitHere = Objects.equals(fieldOnBoard, hitChar) || Objects.equals(fieldOnBoard, missChar);

                if (isVerified) {
                    int sunkField = bf.countIfShipIsHit();
                    boolean noShipsMore = shipFields == sunkField + 1;
                    boolean isSink = Ship.isShipSunk(Battlefield.coordTab[2], bf.lists);

                    if (shipIsHit && noShipsMore) {
                            //je¿eli trafione to wstaw "x" na obie planszse i zakoñcz grê
                        bf.getBoard()[row][col] = hitChar;
                        bf.getFogBoard()[row][col] = hitChar;

                        System.out.println();
                        ////Battlefield.displayBattlefield();
                        //bf.displayFogBattlefield();
                        displayMessage(10);
                        System.out.println();
                    } else if (shipIsHit && isSink) {
                        //je¿eli trafione i zatopione to wstaw "x" na obie planszse
                        bf.getBoard()[row][col] = hitChar;
                        bf.getFogBoard()[row][col] = hitChar;

                        System.out.println();
                        ////Battlefield.displayBattlefield();
                        //bf.displayFogBattlefield();
                        displayMessage(11);
                        System.out.println();
                    } else if (shipIsHit) {
                            //je¿eli trafione to wstaw "x"na obie plansze
                        bf.getBoard()[row][col] = hitChar;
                        bf.getFogBoard()[row][col] = hitChar;

                            System.out.println();
                        ////Battlefield.displayBattlefield();
                        //bf.displayFogBattlefield();
                        displayMessage(7);
                            //System.out.println();
                    } else if (youMissed) {
                            //je¿eli spud³owano to wstaw "M" na obie plansze
                        bf.getBoard()[row][col] = missChar;
                        bf.getFogBoard()[row][col] = missChar;

                            System.out.println();
                        ////Battlefield.displayBattlefield();
                        //bf.displayFogBattlefield();
                        displayMessage(8);
                            //System.out.println();
                    } else if (youAlreadyHitHere) {
                            //je¿eli wczeœniej ju¿ uderzono w to pole:
                            System.out.println();
                        ////Battlefield.displayBattlefield();
                        //bf.displayFogBattlefield();
                        displayMessage(12);
                            System.out.println();
                    }
                    break;
                } else {
                    displayMessage(9);
                }
                System.out.println();
            } catch (NullPointerException e) {
                displayMessage(9);
                System.out.println();
            }
        }
    }

    public static boolean checkShotCoord(String coord, Battlefield bf) {
        boolean isGOOD;
        try {
                        // 0. ILOŒÆ KOORDYNATÓW MUSI BYÆ ZAWSZE 1
            String[] entryTab = coord.trim().split("\\s+"); // --> wszystkie wprowadzone elementy
            String[] corTab = {entryTab[0]}; // --> tylko jeden element
                        // 1. WIELKOŒÆ LITER A-J, zamiana na wielkie litery
            corTab[0] = corTab[0].toUpperCase();
                        // 2. WARTOŒÆ LICZBY PO LITERZE
            int secIndex = Integer.parseInt(corTab[0].substring(1));
                //je¿eli wartoœæ liczby jest wiêksza od dopuszczalnej to ustaw najwiêksz¹ mo¿liw¹
            if (secIndex > Battlefield.getX()) {
                throw new Exception();
            }
                //je¿eli wartoœæ liczby jest mniejsza ni¿ 1 to ustaw j¹ na 1
            else if (secIndex < 1) {
                throw new Exception();
            }
                        // 3. SPRAWDZENIE, CZY PIERWSZY ZNAK (LITERA) MIEŒCI SIÊ W ZAKRESIE
            char firstSign = corTab[0].charAt(0);
            boolean isRangeOK = false;

            for(int i = 1; i <= Battlefield.getY(); i++) {
                if(firstSign == bf.getBoard()[i][0].charAt(0)) {
                    isRangeOK = true;
                    break;
                }
            }
            if(!isRangeOK) throw new Exception();

            Battlefield.coordTab[2] = corTab[0];
            isGOOD = true;
        } catch (Exception e) {
            isGOOD = false;
        }
        return isGOOD;
    }


























    public static void displayMessage(int Msg) {
        switch (Msg) {
            case 3:
                System.out.print("\nError! Wrong ship location! Try again:\n");
                break;
            case 4:
                System.out.print("\nError! You placed it too close to another one. Try again:\n");
                break;
            case 5:
                System.out.print("\nThe game starts!");
                break;
            case 6:
                System.out.println("\nTake a shot!");
                break;
            case 7:
                System.out.println("You hit a ship!");
                break;
            case 8:
                System.out.println("You missed!");
                break;
            case 9:
                System.out.print("\nError! You entered the wrong coordinates! Try again:\n");
                break;
            case 10:
                System.out.print("You sank the last ship. You won. Congratulations!");
                break;
            case 11:
                System.out.print("You sank a ship!"); //Specify a new target:
                break;
            case 12:
                System.out.print("\nYou already hit this field! Specify a new target:\n");
                break;
            case 13:
                System.out.println("\nPlayer 1, place your ships on the game field\n");
                break;
            case 14:
                System.out.println("Player 2, place your ships on the game field\n");
                break;
            case 15:
                System.out.println("\nPress Enter and pass the move to another player");
                break;
            case 16:
                System.out.println("\nPlayer 1, it's your turn:");
                break;
            case 17:
                System.out.println("\nPlayer 2, it's your turn:");
                break;

        }
    }

    public static void displayMessage(int Msg, Ship s) {
        switch (Msg) {
            case 1:
                System.out.printf("Enter the coordinates of the %s (%d cells):\n", s.getName(), s.getFields());
                break;
            case 2:
                //System.out.println();
                System.out.printf("\nError! Wrong length of the %s! Try again:\n", s.getName());
                break;
        }
    }

}
