package pl.mojastrona.zad_3_wstrzykiwaniezaleznosci;

import java.util.Scanner;

public class ConsoleMessageProducer implements MessageProducer {

    @Override
    public String getMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text ot print:");
        return scanner.nextLine();
    }
}
