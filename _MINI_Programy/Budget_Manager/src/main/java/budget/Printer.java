package budget;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Printer {


    public void println() {
        System.out.println();
    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void printf(String format, Object... args) {
        System.out.format(format, args);
    }

    public void displayMenu() {
        String firstLine = "Choose your action:\n";
        String content = Arrays.stream(Option.values())
                .map(Option::toString)
                .collect(Collectors.joining("\n"));
        println(firstLine + content);
    }

    public void printTypesOfPurchases() {

    }

    public void showSortTypes() {
        String text = """
                How do you want to sort?
                1) Sort all purchases           
                2) Sort by type
                3) Sort certain type
                4) Back
                """;
        println(text);
    }
}
