package machine.io;

import machine.CoffeeMachine;
import machine.Option;

public class Printer {

    public void println() {
        System.out.println();
    }

    public void println(String text) {
        System.out.println(text);
    }
    public void println(CoffeeMachine machine) {
        System.out.println(machine);
    }


    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }


    public void printTakeMoneyMessage(int moneyInMachine) {
        printf("\nI gave you $%d\n", moneyInMachine);
        println();
    }

    public void printBuyMessage() {
        println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }

    public void printSteps() {
        String text = """
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some milk into the cup
                Coffee is ready!
                """;
        println(text);
    }

    public void printOptions() {
        println("Choose an option:");
        for (Option value : Option.values()) {
            println(value.toString());
        }
    }
}
