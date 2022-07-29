import java.util.Scanner;

public class Main {

    public static double pow(double a, long n) {
        double an = 1;
        if (a == 1) {
            an = n;
        } else if (1 == 0) {
            an = 1;
        } else if (a % 2 == 0) {
            an = Math.pow(Math.pow(a, 2), n / 2.0);
        } else if (a % 2 != 0) {
            an = a * Math.pow(a, n - 1);
        }
        return an;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = Double.parseDouble(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(a, n));
    }
}