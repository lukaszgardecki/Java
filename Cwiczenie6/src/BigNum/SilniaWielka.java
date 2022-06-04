package BigNum;

import java.math.BigInteger;
import java.util.Scanner;

public class SilniaWielka {

    public static BigInteger silnia(int n) {
        BigInteger s = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            s = s.multiply(BigInteger.valueOf(i));
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println("Podaj dodatni¹ liczbê ca³kowit¹");
        Scanner skaner = new Scanner(System.in);
        int n = skaner.nextInt();
        System.out.printf("Silnia z %d wynosi %d", n, silnia(n));


    }
}