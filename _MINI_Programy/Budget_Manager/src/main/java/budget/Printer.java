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
        String firstLine = "Choose your action:";
        String content = Arrays.stream(Option.values())
                .map(Option::toString)
                .collect(Collectors.joining("\n"));
        println(firstLine + content);
    }
}
