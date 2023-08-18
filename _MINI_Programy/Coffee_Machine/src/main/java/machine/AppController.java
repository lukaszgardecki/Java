package machine;

import machine.components.Component;
import machine.drinks.Cappuccino;
import machine.drinks.Coffe;
import machine.drinks.Espresso;
import machine.drinks.Latte;
import machine.exception.NoSuchOptionException;
import machine.io.DataReader;
import machine.io.Message;
import machine.io.Printer;

import java.util.InputMismatchException;
import java.util.List;

public class AppController {
    private final DataReader reader;
    private final Printer printer;
    private final CoffeeMachine machine;

    public AppController() {
        this.printer = new Printer();
        this.reader = new DataReader(printer);
        this.machine = new CoffeeMachine();
    }

    void mainLoop() {
        Option option;
        do {
            printer.printOptions();
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
                printer.println(Message.INPUT_NOT_INT);
            }
        }
        return option;
    }

    private void take() {
        printer.printTakeMoneyMessage(machine.getMoney());
        machine.takeMoney();
    }

    private void exit() {
        printer.println(Message.END_PROGRAM);
    }

    private void fill() {
        machine.getComponentList()
               .forEach(c -> {
                   printer.printf(Message.ADD_COMPONENT, c.getUnit(), c.getName());
                   c.add(reader.getInt());
               });
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

    private void makeCoffee(Coffe coffee) {
        List<Component> missingSupplies = machine.getMissingSupplies(coffee);
        if (missingSupplies.isEmpty()) {
            printer.println("I have enough resources, making you a coffee!");
            printer.println("Preparing...");
            machine.prepareDrink(coffee);
            printer.println("Drink is ready!");
        } else {
            missingSupplies.forEach(el ->
                    printer.printf(Message.MISSING_COMPONENT, el.getName())
            );
        }
    }
}
