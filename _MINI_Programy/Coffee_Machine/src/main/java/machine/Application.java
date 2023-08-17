package machine;

import machine.drinks.Cappuccino;
import machine.drinks.Coffe;
import machine.drinks.Espresso;
import machine.drinks.Latte;
import machine.io.DataReader;
import machine.io.Printer;

public class Application {
    private static int waterInMachine = 400;
    private static int milkInMachine = 540;
    private static int beansInMachine = 120;
    private static int cupsInMachine = 9;
    private static int moneyInMachine = 550;
    private static DataReader reader = new DataReader();
    private static Printer printer = new Printer();

    public static void main(String[] args) {
        while(true) {
            printer.printActionMenu();
            String action = reader.getString();


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
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> take();
                case "remaining" -> displaySupplies();
                case "exit" -> {
                    return;
                }
                default -> printer.println("Proszê wpisaæ poprawne polecenie!");
            }
        }
    }

    public static void take() {
        printer.printTakeMoneyMessage(moneyInMachine);
        moneyInMachine = 0;
    }

    public static void fill() {
        printer.println("\nWrite how many ml of water you want to add:");
        int addWater = reader.getInt();
        printer.println("Write how many ml of milk you want to add:");
        int addMilk = reader.getInt();
        printer.println("Write how many grams of coffee beans you want to add:");
        int addBeans = reader.getInt();
        printer.println("Write how many disposable cups of coffee you want to add:");
        int addCups = reader.getInt();

        waterInMachine += addWater;
        milkInMachine += addMilk;
        beansInMachine += addBeans;
        cupsInMachine += addCups;
    }


    public static void buy() {
        while (true) {
            printer.printBuyMessage();
            String choice = reader.getString();

            switch (choice) {
                case "1" ->makeCoffee(new Espresso());
                case "2" -> makeCoffee(new Latte());
                case "3" -> makeCoffee(new Cappuccino());
                case "back" -> {
                    return;
                }
                default -> printer.println("Wrong input!");
            }
        }

    }

    public static void displaySupplies() {
//        printer.printSupplies();
    }

    public static void displaySteps() {
        printer.printSteps();
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
            printer.println("I have enough resources, making you a coffee!");
            waterInMachine -= coffee.getAmountOfWater();
            milkInMachine -= coffee.getAmountOfMilk();
            beansInMachine -= coffee.getAmountOfBeans();
            cupsInMachine--;
            moneyInMachine += coffee.getPrice();
        } else if (coffiesOfWater == 0) {
                printer.println("Sorry, not enough water!");
        } else if (coffiesOfMilk == 0) {
            printer.println("Sorry, not enough milk!");
        } else if (coffiesOfBeans == 0) {
            printer.println("Sorry, not enough beans!");
        } else if (cupsInMachine == 0) {
            printer.println("Sorry, not enough cups!");
        }
    }
}
