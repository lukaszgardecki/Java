package budget;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 0;
    static Map<Integer, TypesOfProducts> map = new HashMap<>();
    static TypesOfProducts products;

    public static void main(String[] args) {
        map.put(1, TypesOfProducts.FOOD);
        map.put(2, TypesOfProducts.CLOTHES);
        map.put(3, TypesOfProducts.ENTERTAINMENT);
        map.put(4, TypesOfProducts.OTHER);
        map.put(5, TypesOfProducts.ALL);

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
        System.out.println("\nChoose your action:");
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
        double price;

        while(true) {
            //wybierz numer pozycji menu
            showTypesOfPurchases1();
            int typeOfPurchase = scanner.nextInt();
            scanner.nextLine();
            if (typeOfPurchase == 5) return;

            System.out.println("\nEnter purchase name:");
            String x = scanner.nextLine();
            System.out.println("Enter its price:");

            while (true) {
                try {
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Purchase was added!");
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Incorrect price! Enter numbers. Try again!");
                }
            }

            //weŸ dan¹ kategoriê z mapy:
            products = map.get(typeOfPurchase);

            //weŸ dan¹ listê tej kategorii
            ArrayList<String> list = products.getBoughtProducts();

            //zmieñ sumê w tej kategorii
            products.setSum(products.getSum() + price);

            //dodaj zakupione rzeczy do listy w tej kategorii
            list.add(String.format("%s $%.2f", x, price));

            //dodaj tê rzecz równie¿ do listy wszystkich zakupionych rzeczy:
            map.get(5).getBoughtProducts().add(String.format("%s $%.2f", x, price));
            map.get(5).setSum(map.get(5).getSum() + price);
        }
    }


    public static void showListOfPurchases() {
        while(true) {
            if (map.get(5).getBoughtProducts().size() == 0) {
                System.out.println("\nThe purchase list is empty!");
                return;
            }
            //wyœwietl menu
            showTypesOfPurchases2();

            int choice = scanner.nextInt();
            scanner.nextLine();

            //cofnij
            if (choice == 6) return;

            //rozmiar listy danej kategorii
            int vol = map.get(choice).getBoughtProducts().size();
            ArrayList<String> list = map.get(choice).getBoughtProducts();
            double sum = map.get(choice).getSum();

            System.out.printf("\n%s:", map.get(choice).getName());
            if (vol == 0) {
                System.out.println("\nThe purchase list is empty!");

            } else {
                System.out.println();
                list.forEach(System.out::println);
                System.out.printf("Total sum: $%.2f\n", sum);
            }
        }
    }
    public static void showBalance() {
        double sumAll = map.get(5).getSum();
        System.out.printf("\nBalance: $%.2f\n", balance - sumAll);
    }
    public static void showTypesOfPurchases1() {
        System.out.println("\nChoose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) Back");
    }
    public static void showTypesOfPurchases2() {
        System.out.println("\nChoose the type of purchases");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");
        System.out.println("5) All");
        System.out.println("6) Back");
    }
}
