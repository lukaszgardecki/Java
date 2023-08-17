package machine.io;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public String getString() {
        return scanner.nextLine();
    }

    public int getInt() {

        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }
}
