package cinema;
import java.util.Scanner;

public class Cinema {

    private static final int TICKET_PRICE_REG = 10;
    private static final int TICKET_PRICE_LOW = 8;
    private static final int MANY_SEATS = 60;
    private static final String[][] THEATRE = createTheatre();
    private static final int ROWS = THEATRE.length - 1;
    private static final int SEATS = THEATRE[0].length - 1;
    private static final int ALL_SEATS = ROWS * SEATS;

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

            while (true) {
                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("3. Statistics");
                System.out.println("0. Exit");

                choice = scanner.nextInt();


                switch (choice) {
                    case 1:
                        displayTheatre();
                        break;
                    case 2:
                        buyTicket();
                        break;
                    case 3:
                        showStatistics();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Unknown operation.\n");
                }

            }

    }

    public static void showStatistics() {
        System.out.printf("\nNumber of purchased tickets: %d", getSoldTickets());
        System.out.printf("\nPercentage: %.2f%%", countPercentage());
        System.out.printf("\nCurrent income: $%d", countCurrentIncome());
        System.out.printf("\nTotal income: $%d", countTotalIncome());
        System.out.println();
        System.out.println();
    }

    public static int getSoldTickets() {
        int counter = 0;
        for (String[] i : THEATRE) {
            for (String j : i) {
                if ("B".equals(j)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static int countCurrentIncome() {
        int income = 0;
        for (int i = 1; i <= ROWS; i++) {
            for (int j = 1; j <= SEATS; j++) {
                if ("B".equals(THEATRE[i][j])) {

                    income += getTicketPrice(i);
                }
            }
        }
        return income;
    }

    public static int countTotalIncome() {
        int totalIncome = 0;
        for (int i = 1; i <= ROWS; i++) {
            for (int j = 1; j <= SEATS; j++) {
                    totalIncome += getTicketPrice(i);
            }
        }
        return totalIncome;
    }

    public static float countPercentage() {
        return (float) getSoldTickets() / (float) ALL_SEATS * 100;
    }

    public static void buyTicket() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a row number:");
            int chosenRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int chosenSeat = scanner.nextInt();

            if (chosenRow > ROWS || chosenSeat > SEATS) {
                System.out.println("Wrong input!");
            } else if ("B".equals(THEATRE[chosenRow][chosenSeat])) {
                System.out.println("That ticket has already been purchased!\n");
            } else {
                displayTicketPrice (chosenRow);
                markChosenSeat (chosenRow, chosenSeat);
                break;
            }
        }
    }

    public static String[][] createTheatre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        String[][] theatre = new String[rows+1][seats+1];

        System.out.println();

        for (int i = 0; i < (rows + 1); i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == 0 && j == 0) {
                    theatre[i][j] = " ";
                    continue;
                }
                if (i == 0) {
                    theatre[i][j] = Integer.toString(j);
                }
                else if (j == 0) {
                    theatre[i][j] = Integer.toString(i);
                }
                else {
                    theatre[i][j] = "S";
                }
            }
        }
        return theatre;
    }

    //metoda podmieniaj�ca w tablicy wybrany element (wybrane miejsce):
    public static void markChosenSeat(int chosenRow, int chosenSeat) {
        THEATRE[chosenRow][chosenSeat] = "B";
    }

    public static int getTicketPrice(int row) {
        if (ALL_SEATS <= MANY_SEATS) {
            return TICKET_PRICE_REG;
        } else if (row <= ROWS / 2) {
            return TICKET_PRICE_REG;
        } else {
            return TICKET_PRICE_LOW;
        }
    }

    //metoda wy�wietlaj�ca cen� biletu
    public static void displayTicketPrice (int chosenRow) {
            System.out.printf("Ticket price: $%d", getTicketPrice(chosenRow));
            System.out.println();
            System.out.println();
    }

    //metoda wy�wietlaj�ca aktualny stan sali:
    public static void displayTheatre() {
        System.out.println();
        System.out.println("Cinema:");

        for (String[] i : THEATRE) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}