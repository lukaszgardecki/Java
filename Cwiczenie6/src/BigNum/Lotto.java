package BigNum;

import java.math.BigInteger;
import java.util.Scanner;

public class Lotto {

    public static BigInteger silnia(int n) {
        BigInteger s = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            s = s.multiply(BigInteger.valueOf(i));
        }
        return s;
    }


    public static void main(String[] args) {
        int n = 49;
        int k = 6;
        BigInteger p = silnia(n).divide(silnia(k).multiply(silnia(n - k)));

        System.out.printf("Prawdopodobieñstwo wynosi 1 : %d", p);

    }
}