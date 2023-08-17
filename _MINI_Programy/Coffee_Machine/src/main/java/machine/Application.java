package machine;

import machine.drinks.Cappuccino;
import machine.drinks.Coffe;
import machine.drinks.Espresso;
import machine.drinks.Latte;
import machine.io.DataReader;
import machine.io.Printer;

public class Application {
    private static DataReader reader = new DataReader();
    private static Printer printer = new Printer();
    private static CoffeeMachine machine = new CoffeeMachine();

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
        printer.printTakeMoneyMessage(machine.getMoney());
        machine.takeMoney();
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

        machine.addWater(addWater);
        machine.addMilk(addMilk);
        machine.addBeans(addBeans);
        machine.addCups(addCups);
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
        printer.println(machine);
    }

    public static void displaySteps() {
        printer.printSteps();
    }

    public static void makeCoffee(Coffe coffee) {
        if (machine.hasNotEnoughWaterToPrepare(coffee)) {
            printer.println("Sorry, not enough water!");
        } else if (machine.hasNotEnoughMilkToPrepare(coffee)) {
            printer.println("Sorry, not enough milk!");
        } else if (machine.hasNotEnoughBeansToPrepare(coffee)) {
            printer.println("Sorry, not enough beans!");
        } else if (machine.hasNoCups()) {
            printer.println("Sorry, not enough cups!");
        } else {
            printer.println("I have enough resources, making you a coffee!");
            printer.println("Preparing...");
            machine.prepareDrink(coffee);
            printer.println("Drink is ready!");
        }
    }
}
