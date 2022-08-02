import java.util.Scanner;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger m = scanner.nextBigInteger();
        BigInteger factorial = new BigInteger("1");
        int ind = 0;

        for (int i = 1; ; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            int ans = factorial.compareTo(m);
            ind = i;
            if (ans == 0 || ans > 0) break;

        }
        System.out.println(ind);
    }
}