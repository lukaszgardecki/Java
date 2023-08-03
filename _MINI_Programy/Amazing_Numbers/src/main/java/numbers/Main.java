package numbers;
import java.util.Scanner;


public class Main {
    //tatic Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Enter a natural number:");
        Number num = new Number();

        if (!num.isNatural()) {
            System.out.println("This number is not natural!");
        } else {
            System.out.printf(
                    "Properties of %d"          + "\n" +
                                "even: %b"      + "\n" +
                                "odd: %b"       + "\n" +
                                "buzz: %b"      + "\n" +
                                "duck: %b"      + "\n",
                    num.getNum(),
                    num.isEven(),
                    num.isOdd(),
                    num.isBuzzNumber(),
                    num.isDuckNumber());
        }


    }


}
