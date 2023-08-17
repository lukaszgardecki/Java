package machine.io;

public class Printer {

    public void println() {
        System.out.println();
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public void printActionMenu() {
        println();
        println("Write action (buy, fill, take, remaining, exit):");
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

//    //drukowanie maszyny więc to powinno drukować maszynę!
//    public void printSupplies() {
//        String text = """
//                The coffee machine has:
//                %d ml of water
//                %d ml of milk
//                %d g of coffee beans
//                %d disposable cups
//                $%d of money
//                """;
//        printer.printf(text, waterInMachine, milkInMachine, beansInMachine, cupsInMachine, moneyInMachine);
//    }
}
