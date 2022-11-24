package pl.mojastrona.zad_3_wstrzykiwaniezaleznosci;

public class Main {
    public static void main(String[] args) {
        MessageProducer messageProducer = new ConsoleMessageProducer();
        
        MessagePrinter messagePrinter = new MessagePrinter(messageProducer);
        messagePrinter.printMessage();
    }
}
