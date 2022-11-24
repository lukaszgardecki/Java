package pl.mojastrona.zad_3_wstrzykiwaniezaleznosci;

public class MessagePrinter {
    private MessageProducer messageProducer;

    public MessagePrinter(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    void printMessage() {
        String message = messageProducer.getMessage();
        System.out.println(message);
    }
}
