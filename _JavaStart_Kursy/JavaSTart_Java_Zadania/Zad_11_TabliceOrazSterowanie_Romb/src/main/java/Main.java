import java.util.Scanner;

public class Main {

    /**
     * Napisz program, w którym użytkownik podaje liczbę całkowitą,
     * a następnie w konsoli rysowany jest romb, którego boki składają
     * się z tylu gwiazdek co liczba zadana w programie.
     */

    public static void main(String[] args) {
        String sign = "0";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Narysuję romb. Podaj długość boku:");
        int len = scanner.nextInt();

        for (int i = len; i > 0; i--) {
            System.out.println(" ".repeat(i) + sign.repeat(len));
        }
    }
}
