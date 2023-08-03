package BigNum;

import java.util.Scanner;

public class SilniaMala {

    public static long silnia(int n) {
        long s = 1;
        for (int i = 1; i <= n; i++) {
            s = s * i;
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
