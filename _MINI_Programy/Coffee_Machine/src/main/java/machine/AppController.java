package machine;

import machine.drinks.Cappuccino;
import machine.drinks.Coffe;
import machine.drinks.Espresso;
import machine.drinks.Latte;
import machine.exception.NoSuchOptionException;
import machine.io.DataReader;
import machine.io.Printer;

import java.util.InputMismatchException;

public class AppController {
    private final DataReader reader;
    private final Printer printer;
    private final CoffeeMachine machine;

    public AppController() {
        this.reader = new DataReader();
        this.printer = new Printer();
        this.machine = new CoffeeMachine();
    }

    void mainLoop() {
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option) {
                case EXIT -> exit();
                case BUY -> buy();
                case FILL -> fill();
                case TAKE -> take();
                case REMAINING -> displaySupplies();
            }
        } while (option != Option.EXIT);
    }

    private void printOptions() {
        printer.println("Choose an option:");
        for (Option value : Option.values()) {
            printer.println(value.toString());
        }
    }

    private Option getOption() {
        boolean optionOK = false;
        Option option = null;
        while (!optionOK) {
            try {
                option = Option.createFromInt(reader.getInt());
                optionOK = true;
            } catch (NoSuchOptionException e) {
                printer.println(e.getMessage());
            } catch (InputMismatchException e) {
                printer.println("Wprowadzono wartoœæ, która nie jest liczb¹, podaj ponownie: ");
            }
        }
        return option;
    }

    private void take() {
        printer.printTakeMoneyMessage(machine.getMoney());
        machine.takeMoney();
    }

    private void exit() {
        printer.println("Bye bye!");
    }

    private void fill() {
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


    private void buy() {
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

    private void displaySupplies() {
        printer.println(machine);
    }

    private void displaySteps() {
        printer.printSteps();
    }

    private void makeCoffee(Coffe coffee) {
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
