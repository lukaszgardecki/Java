package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static int waterInMachine = 400;
    private static int milkInMachine = 540;
    private static int beansInMachine = 120;
    private static int cupsInMachine = 9;
    private static int moneyInMachine = 550;

    static Coffe espresso = new Coffe("Espresso", 250, 0, 16, 4);
    static Coffe latte = new Coffe("Latte", 350, 75, 20, 7);
    static Coffe cappuccino = new Coffe("Cappuccino", 200, 100, 12, 6);

    public static void main(String[] args) {
        while(true) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            if ("buy".equalsIgnoreCase(action)) {
                action = "buy";
            } else if ("fill".equalsIgnoreCase(action)) {
                action = "fill";
            } else if ("take".equalsIgnoreCase(action)) {
                action = "take";
            } else if ("remaining".equalsIgnoreCase(action)) {
                action = "remaining";
            } else if ("exit".equalsIgnoreCase(action)) {
                action = "exit";
            }

            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    displaySupplies();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Proszê wpisaæ poprawne polecenie!");
            }
        }
    }

    public static void take() {
        System.out.printf("\nI gave you $%d\n", moneyInMachine);
        System.out.println();
        moneyInMachine = 0;
    }

    public static void fill() {
        System.out.println("\nWrite how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCups = scanner.nextInt();

        waterInMachine += addWater;
        milkInMachine += addMilk;
        beansInMachine += addBeans;
        cupsInMachine += addCups;

        scanner.nextLine();
    }


    public static void buy() {
        while (true) {
            System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    makeCoffee(espresso);
                    return;
                case "2":
                    makeCoffee(latte);
                    return;
                case "3":
                    makeCoffee(cappuccino);
                    return;
                case "back":
                    return;
                default:
                    System.out.println("Wrong input!");
            }
        }

    }


    public static void displaySupplies() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water", waterInMachine);
        System.out.printf("\n%d ml of milk", milkInMachine);
        System.out.printf("\n%d g of coffee beans", beansInMachine);
        System.out.printf("\n%d disposable cups", cupsInMachine);
        System.out.printf("\n$%d of money", moneyInMachine);
        System.out.println();
    }


    public static void displaySteps() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void makeCoffee(Coffe coffee) {
        //PÓNIEJ USUN¥Æ I ZAMIENIEÆ NA 1 JE¯ELI MASZYNA BÊDZIE ROBIÆ TYLKO JEDN¥ KAWÊ
        int howMuchCoffees = 1;

        int milk = coffee.getAmountOfMilk();
        int water = coffee.getAmountOfWater();
        int beans = coffee.getAmountOfBeans();

        if (milk == 0) {
            milk = 1;
        }

        int coffiesOfWater = waterInMachine / water;
        int coffiesOfMilk = milkInMachine / milk;
        int coffiesOfBeans = beansInMachine / beans;
        int coffiesOfCups = cupsInMachine / howMuchCoffees;
        int amountOfAvailableCoffees = Math.min(Math.min(coffiesOfWater, coffiesOfMilk),Math.min(coffiesOfCups, coffiesOfBeans));

        if (amountOfAvailableCoffees >= howMuchCoffees) {
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= coffee.getAmountOfWater();
            milkInMachine -= coffee.getAmountOfMilk();
            beansInMachine -= coffee.getAmountOfBeans();
            cupsInMachine--;
            moneyInMachine += coffee.getPrice();
        } else if (coffiesOfWater == 0) {
                System.out.println("Sorry, not enough water!");
        } else if (coffiesOfMilk == 0) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffiesOfBeans == 0) {
            System.out.println("Sorry, not enough beans!");
        } else if (cupsInMachine == 0) {
            System.out.println("Sorry, not enough cups!");
        }
    }
}
