package machine.io;

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
        int intNum = 0;
        while (!intOK) {
            try {
                intNum = scanner.nextInt();
                intOK = true;
            } catch (InputMismatchException e) {
                printer.println(Message.INPUT_NOT_INT);
            } finally {
                scanner.nextLine();
            }
        }
        return intNum;
    }
}
