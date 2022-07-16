import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        long k = 1;

        if (n == 0) {
            return k;
        } else {
            for (long i = 1; i <= n; i++) {
                k *= i;
            }
            return k;
        }

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}