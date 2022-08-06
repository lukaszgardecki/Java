package budget;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 0;
    static ArrayList<String> purchasesList = new ArrayList<>();
    static Map<Integer, TypesOfProducts> map = new HashMap<>();
    static double sum = 0;

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        while(true) {
            displayMenu();
            String action = scanner.nextLine();
            switch (action) {
                case "0":
                    System.out.println("\nBye!");
                    return;
                case "1":
                    addIncome();
                    break;
                case "2":
                    showTypesOfPurchases();
                    String typeOfPurchase = scanner.nextLine();
                    switch (typeOfPurchase) {
                        case "1":

                            break;
                        case "2":

                            break;
                        case "3":

                            break;
                        case "4":

                            break;
                        case "5":
                            break;
                    }
                    addPurchase();
                    break;
                case "3":
                    showListOfPurchases();
                    break;
                case "4":
                    showBalance();
                    break;
                default:
                    System.out.println("\nIncorrect operation. Try again!\n");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");
    }

    public static void addIncome() {
        System.out.println("\nEnter income:");
        while(true) {
            try {
                double income = scanner.nextInt();
                scanner.nextLine();
                balance += income;
                System.out.println("Income was added!\n");
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("\nEnter numbers!");
            }
        }
    }
    public static void addPurchase() {
        double price = 0.0;
        System.out.println("\nEnter purchase name:");
        String x = scanner.nextLine();
        System.out.println("Enter its price:");
        while (true) {
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Purchase was added!\n");
                break;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Incorrect price! Enter numbers. Try again!");
            }
        }
        //dodaj do listy zakupów
        purchasesList.add(String.format("%s $%.2f", x, price));
        //zwiêksz sumê koñcow¹
        sum += price;

    }
    public static void showListOfPurchases() {

        if(purchasesList.size() == 0) {
            System.out.println("\nThe purchase list is empty\n");
            return;
        }
        System.out.println();
        purchasesList.forEach(System.out::println);
        System.out.printf("Total sum: $%.2f\n\n", sum);
    }
    public static void showBalance() {
        System.out.printf("\nBalance: $%.2f\n\n", balance-sum);
    }
    public static void showTypesOfPurchases() {
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
    }
}
