package unit3;

public class MethodReferenceExample1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> printMessage());
        t.start();

        Thread t2 = new Thread(MethodReferenceExample1::printMessage);
        t2.start();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}
