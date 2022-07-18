package battleship;

import java.util.*;

public class Main {
//    static String[] coordTab = new String[3];



    static Battlefield bf1 = new Battlefield();
    static Battlefield bf2 = new Battlefield();



    public static void main(String[] args) {
        System.out.println();

        bf1.addShips(bf1);

        System.out.println("To jest plansza b1");

        bf1.createBattlefield();
        bf1.displayBattlefield();


        System.out.println("To jest plansza b2");
        bf2.createBattlefield();
        bf2.displayBattlefield();
        bf2.addShips(bf2);

        System.out.println();
        System.out.println("WYŒWIETL DWIE PLANSZE");
        bf1.displayBattlefield();
        bf2.displayBattlefield();
//        System.out.println("Teraz nastêpuje dodawanie statków na planszê 1:");



//        System.out.println("Teraz nastêpuje dodawanie statków na planszê 2:");
//        bf2.addShips(bf2);

//        System.out.println("To jest plansza b1");
//        bf1.displayBattlefield();
//        System.out.println("To jest plansza b2");
//        bf2.displayBattlefield();
//        System.out.println("To jest plansza b1");
//        bf1.displayBattlefield();



    }


//    public static void playGame(Battlefield bf1, Battlefield bf2) {
//        //iloœæ pó³ do zbicia
//        int shipFields1 = bf1.countShips();
//        boolean noShipsMore = false;
//
//        displayMessage(5);
//            System.out.println();
//        //Battlefield.displayBattlefield();
//        bf1.displayFogBattlefield();
//        displayMessage(6);
//            System.out.println();
//
//        while (!noShipsMore) {
//            //wykonaj strza³ NARAZIE tylko na jednym polu bitwy
//            takeAshot(shipFields1, bf1);
//
//            int sunkField = bf1.countIfShipIsHit();
//            noShipsMore = shipFields1 == sunkField;
//        }
//    }

//    public static void takeAshot(int shipFields, Battlefield bf) {
//        Scanner scanner = new Scanner(System.in);
//
//        String hitChar = Character.toString(bf.getHitChar());
//        String missChar = Character.toString(bf.getMissChar());
//        String shipChar = Character.toString(bf.getShipChar());
//        String water = Character.toString(bf.getFieldChar());
//
//        while(true) {
//            String shotCoord = scanner.nextLine();
//            boolean isVerified = checkShotCoord(shotCoord, bf);
//
//            try {
//                int row = bf.returnCoordinate(Battlefield.coordTab[2]);
//                int col = Integer.parseInt(Battlefield.coordTab[2].substring(1));
//                String fieldOnBoard = bf.getBoard()[row][col];
//                //
//                //String fieldOnFogBoard = Battlefield.getFogBoard()[row][col];
//                //
//                boolean shipIsHit = Objects.equals(fieldOnBoard, shipChar);
//                boolean youMissed = Objects.equals(fieldOnBoard, water);
//                boolean youAlreadyHitHere = Objects.equals(fieldOnBoard, hitChar) || Objects.equals(fieldOnBoard, missChar);
//
//                if (isVerified) {
//                    int sunkField = bf.countIfShipIsHit();
//                    boolean noShipsMore = shipFields == sunkField + 1;
//                    boolean isSink = Ship.isShipSunk(Battlefield.coordTab[2], lists);
//
//                    if (shipIsHit && noShipsMore) {
//                            //je¿eli trafione to wstaw "x" na obie planszse i zakoñcz grê
//                        bf.getBoard()[row][col] = hitChar;
//                        bf.getFogBoard()[row][col] = hitChar;
//
//                        System.out.println();
//                        //Battlefield.displayBattlefield();
//                        bf.displayFogBattlefield();
//                        displayMessage(10);
//                        System.out.println();
//                    } else if (shipIsHit && isSink) {
//                        //je¿eli trafione i zatopione to wstaw "x" na obie planszse
//                        bf.getBoard()[row][col] = hitChar;
//                        bf.getFogBoard()[row][col] = hitChar;
//
//                        System.out.println();
//                        //Battlefield.displayBattlefield();
//                        bf.displayFogBattlefield();
//                        displayMessage(11);
//                        System.out.println();
//                    } else if (shipIsHit) {
//                            //je¿eli trafione to wstaw "x"na obie plansze
//                        bf.getBoard()[row][col] = hitChar;
//                        bf.getFogBoard()[row][col] = hitChar;
//
//                            System.out.println();
//                        //Battlefield.displayBattlefield();
//                        bf.displayFogBattlefield();
//                        displayMessage(7);
//                            System.out.println();
//                    } else if (youMissed) {
//                            //je¿eli spud³owano to wstaw "M" na obie plansze
//                        bf.getBoard()[row][col] = missChar;
//                        bf.getFogBoard()[row][col] = missChar;
//
//                            System.out.println();
//                        //Battlefield.displayBattlefield();
//                        bf.displayFogBattlefield();
//                        displayMessage(8);
//                            System.out.println();
//                    } else if (youAlreadyHitHere) {
//                            //je¿eli wczeœniej ju¿ uderzono w to pole:
//                            System.out.println();
//                        //Battlefield.displayBattlefield();
//                        bf.displayFogBattlefield();
//                        displayMessage(12);
//                            System.out.println();
//                    }
//                    break;
//                } else {
//                    displayMessage(9);
//                }
//                System.out.println();
//            } catch (NullPointerException e) {
//                displayMessage(9);
//                System.out.println();
//            }
//        }
//    }

//    public static boolean checkShotCoord(String coord, Battlefield bf) {
//        boolean isGOOD;
//        try {
//                        // 0. ILOŒÆ KOORDYNATÓW MUSI BYÆ ZAWSZE 1
//            String[] entryTab = coord.trim().split("\\s+"); // --> wszystkie wprowadzone elementy
//            String[] corTab = {entryTab[0]}; // --> tylko jeden element
//                        // 1. WIELKOŒÆ LITER A-J, zamiana na wielkie litery
//            corTab[0] = corTab[0].toUpperCase();
//                        // 2. WARTOŒÆ LICZBY PO LITERZE
//            int secIndex = Integer.parseInt(corTab[0].substring(1));
//                //je¿eli wartoœæ liczby jest wiêksza od dopuszczalnej to ustaw najwiêksz¹ mo¿liw¹
//            if (secIndex > bf.getX()) {
//                throw new Exception();
//            }
//                //je¿eli wartoœæ liczby jest mniejsza ni¿ 1 to ustaw j¹ na 1
//            else if (secIndex < 1) {
//                throw new Exception();
//            }
//                        // 3. SPRAWDZENIE, CZY PIERWSZY ZNAK (LITERA) MIEŒCI SIÊ W ZAKRESIE
//            char firstSign = corTab[0].charAt(0);
//            boolean isRangeOK = false;
//
//            for(int i = 1; i <= bf.getY(); i++) {
//                if(firstSign == bf.getBoard()[i][0].charAt(0)) {
//                    isRangeOK = true;
//                    break;
//                }
//            }
//            if(!isRangeOK) throw new Exception();
//
//            Battlefield.coordTab[2] = corTab[0];
//            isGOOD = true;
//        } catch (Exception e) {
//            isGOOD = false;
//        }
//        return isGOOD;
//    }


























    public static void displayMessage(int Msg) {
        switch (Msg) {
            case 3:
                System.out.println();
                System.out.print("Error! Wrong ship location! Try again:\n");
                break;
            case 4:
                System.out.println();
                System.out.print("Error! You placed it too close to another one. Try again:\n");
                break;
            case 5:
                System.out.println();
                System.out.print("The game starts!\n");
                break;
            case 6:
                System.out.println();
                System.out.print("Take a shot!\n");
                break;
            case 7:
                System.out.println();
                System.out.print("You hit a ship! Try again:\n");
                break;
            case 8:
                System.out.println();
                System.out.print("You missed! Try again:\n");
                break;
            case 9:
                System.out.println();
                System.out.print("Error! You entered the wrong coordinates! Try again:\n");
                break;
            case 10:
                System.out.println();
                System.out.print("You sank the last ship. You won. Congratulations!\n");
                break;
            case 11:
                System.out.println();
                System.out.print("You sank a ship! Specify a new target:\n");
                break;
            case 12:
                System.out.println();
                System.out.print("You already hit this field! Specify a new target:\n");
                break;
        }
    }

    public static void displayMessage(int Msg, Ship s) {
        switch (Msg) {
            case 1:
                System.out.printf("Enter the coordinates of the %s (%d cells):\n", s.getName(), s.getFields());
                break;
            case 2:
                System.out.println();
                System.out.printf("Error! Wrong length of the %s! Try again:\n", s.getName());
                break;
        }
    }

}
