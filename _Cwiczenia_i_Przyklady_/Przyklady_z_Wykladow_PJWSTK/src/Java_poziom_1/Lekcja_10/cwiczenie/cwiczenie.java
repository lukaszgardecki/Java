package Java_poziom_1.Lekcja_10.cwiczenie;


public class cwiczenie {

    public static void main(String[] args) {
        fib1(10);
    }

    private static int fib1(int n) {
        if (n < 0) {
            System.out.print(n + " ");
            return n;
        } else {
            int a = fib1(n-1) + fib1(n-2);
            System.out.print(a + " ");
            return a;
        }
    }
}
