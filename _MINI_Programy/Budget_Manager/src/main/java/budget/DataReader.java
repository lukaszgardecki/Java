package budget;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner;
    private final Printer printer;

    public DataReader(Printer printer) {
        this.scanner = new Scanner(System.in);
        this.printer = printer;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public int getInt() {
        boolean intOK = false;
        int num = -1;
        do {
            try {
                num = scanner.nextInt();
                if (num < 0) throw new InputMismatchException();
                intOK = true;
            } catch (InputMismatchException e) {
                printer.println(Message.INCORRECT_INT);
            }
        } while (!intOK);
        return num;
    }


    public Option getOptionFromInt() {
        Option option;
        do {
            int enteredValue = getInt();
            option = Arrays.stream(Option.values())
                    .filter(o -> o.getValue() == enteredValue)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(Message.BAD_OPT_NUM));
        } while (option == null);
        return option;
    }
}
