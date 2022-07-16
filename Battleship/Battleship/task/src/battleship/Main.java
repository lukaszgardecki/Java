package battleship;

import java.util.*;

public class Main {
    private static String[] coordTab = new String[3];

    static List<Ship> ships = new ArrayList<>();
    static List<List<String>> lists = new ArrayList<>();


//    static Ship aircraftCarrier = new Ship("Aircraft Carrier", 5);
//    static Ship battleShip = new Ship("Battleship", 4);
//    static Ship submarine = new Ship("Submarine", 3);
//    static Ship cruiser = new Ship("Cruiser", 3);
//    static Ship destroyer = new Ship("Destroyer", 2);
    static Battlefield bf = new Battlefield();


    public static void main(String[] args) {
        bf.createBattlefield();
        addShips();
        playGame();
    }

    public static void addShips() {
        ships.add(new Ship ("Aircraft Carrier", 5));
        ships.add(new Ship ("Battleship", 4));
        ships.add(new Ship ("Submarine", 3));
        ships.add(new Ship ("Cruiser", 3));
        ships.add(new Ship ("Destroyer", 2));


        for (Ship ship : ships) {
            addShipToBattlefield(ship);
        }
    }

    public static void playGame() {
        //iloœæ pó³ do zbicia
        int shipFields = Battlefield.countShips();
        boolean noShipsMore = false;

        displayMessage(5);
            System.out.println();
        //Battlefield.displayBattlefield();
        Battlefield.displayFogBattlefield();
        displayMessage(6);
            System.out.println();

        while (!noShipsMore) {
            takeAshot(shipFields);

            int sunkField = Battlefield.countIfShipIsHit();
            noShipsMore = shipFields == sunkField;
        }
    }

    public static void takeAshot(int shipFields) {
        Scanner scanner = new Scanner(System.in);

        String hitChar = Character.toString(Battlefield.getHitChar());
        String missChar = Character.toString(Battlefield.getMissChar());
        String shipChar = Character.toString(Battlefield.getShipChar());
        String water = Character.toString(Battlefield.getFieldChar());

        while(true) {
            String shotCoord = scanner.nextLine();
            boolean isVerified = checkShotCoord(shotCoord);

            try {
                int row = Battlefield.returnCoordinate(coordTab[2]);
                int col = Integer.parseInt(coordTab[2].substring(1));
                String fieldOnBoard = Battlefield.getBoard()[row][col];
                //
                //String fieldOnFogBoard = Battlefield.getFogBoard()[row][col];
                //
                boolean shipIsHit = Objects.equals(fieldOnBoard, shipChar);
                boolean youMissed = Objects.equals(fieldOnBoard, water);
                boolean youAlreadyHitHere = Objects.equals(fieldOnBoard, hitChar) || Objects.equals(fieldOnBoard, missChar);

                if (isVerified) {
                    int sunkField = Battlefield.countIfShipIsHit();
                    boolean noShipsMore = shipFields == sunkField + 1;
                    boolean isSink = Ship.isShipSunk(coordTab[2], lists);

                    if (shipIsHit && noShipsMore) {
                            //je¿eli trafione to wstaw "x" na obie planszse i zakoñcz grê
                        Battlefield.getBoard()[row][col] = hitChar;
                        Battlefield.getFogBoard()[row][col] = hitChar;

                        System.out.println();
                        //Battlefield.displayBattlefield();
                        Battlefield.displayFogBattlefield();
                        displayMessage(10);
                        System.out.println();
                    } else if (shipIsHit && isSink) {
                        //je¿eli trafione i zatopione to wstaw "x" na obie planszse
                        Battlefield.getBoard()[row][col] = hitChar;
                        Battlefield.getFogBoard()[row][col] = hitChar;

                        System.out.println();
                        //Battlefield.displayBattlefield();
                        Battlefield.displayFogBattlefield();
                        displayMessage(11);
                        System.out.println();
                    } else if (shipIsHit) {
                            //je¿eli trafione to wstaw "x"na obie plansze
                        Battlefield.getBoard()[row][col] = hitChar;
                        Battlefield.getFogBoard()[row][col] = hitChar;

                            System.out.println();
                        //Battlefield.displayBattlefield();
                        Battlefield.displayFogBattlefield();
                        displayMessage(7);
                            System.out.println();
                    } else if (youMissed) {
                            //je¿eli spud³owano to wstaw "M" na obie plansze
                        Battlefield.getBoard()[row][col] = missChar;
                        Battlefield.getFogBoard()[row][col] = missChar;

                            System.out.println();
                        //Battlefield.displayBattlefield();
                        Battlefield.displayFogBattlefield();
                        displayMessage(8);
                            System.out.println();
                    } else if (youAlreadyHitHere) {
                            //je¿eli wczeœniej ju¿ uderzono w to pole:
                            System.out.println();
                        //Battlefield.displayBattlefield();
                        Battlefield.displayFogBattlefield();
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

    public static boolean checkShotCoord(String coord) {
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
                if(firstSign == Battlefield.getBoard()[i][0].charAt(0)) {
                    isRangeOK = true;
                    break;
                }
            }
            if(!isRangeOK) throw new Exception();

            coordTab[2] = corTab[0];
            isGOOD = true;
        } catch (Exception e) {
            isGOOD = false;
        }
        return isGOOD;
    }


    // Metoda sprawdzaj¹ca wprowadzone koordynaty
    public static boolean checkCoordinates(String coordinates, Ship ship) {
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
            if (secIndexFrom > Battlefield.getX()) {
                secIndexFrom = Battlefield.getX();
                b1 = true;
            }
            //je¿eli wartoœæ liczby jest mniejsza ni¿ 1 to ustaw j¹ na 1
            else if (secIndexFrom < 1) {
                secIndexFrom = 1;
                b2 = true;
            }
            //je¿eli wartoœæ liczby jest wiêksza od dopuszczalnej to ustaw najwiêksz¹ mo¿liw¹
            if (secIndexTo > Battlefield.getX()) {
                secIndexTo = Battlefield.getX();
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
            displayMessage(3);
            isGOOD = false;
        }

        // 4. SPRAWDZENIE CZY ZGADZA SIÊ PODANA D£UGOŒÆ STATKU
        if (isGOOD) {
            int rowIndexFrom = Battlefield.returnCoordinate(coordTab[0]);
            int rowIndexTo = Battlefield.returnCoordinate(coordTab[1]);
            int columnIndexFrom = Integer.parseInt(coordTab[0].substring(1));
            int columnIndexTo = Integer.parseInt(coordTab[1].substring(1));

            int customRowLength = rowIndexTo - rowIndexFrom + 1;
            int customColumnLength = columnIndexTo - columnIndexFrom + 1;

            if (customRowLength != ship.getFields() && customColumnLength != ship.getFields()) {
                displayMessage(2, ship);
                isGOOD = false;
            }
        }

        return isGOOD;
    }


    public static void addShipToBattlefield(Ship sh) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        displayMessage(1, sh);
        System.out.println();

        while (true) {
            String coordinates = scanner.nextLine();
            boolean verified = checkCoordinates(coordinates, sh);

            if (verified) {
                boolean isPlace = Battlefield.isEnoughPlace(coordTab[0], coordTab[1]);
                if(isPlace) {
                    Ship.addCoordsToShipList(sh, coordTab[0], coordTab[1]); // przypisz statkowi swoje koordynaty
                    Battlefield.changeSign(coordTab[0], coordTab[1]); //zmieñ znak na mapie
                    lists.add(sh.getCords()); // listê z koordynatami dodaj do ogólnej listy koordynatów
                    break;
                }
            }
            System.out.println();
        }

        System.out.println();
        Battlefield.displayBattlefield();
    }

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
