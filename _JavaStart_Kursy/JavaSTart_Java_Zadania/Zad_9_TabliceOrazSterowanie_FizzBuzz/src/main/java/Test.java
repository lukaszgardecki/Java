import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    /**
     * Napisz program, który w przypadku liczb podzielnych przez 3 wyświetli liczbę i słowo "Fizz",
     * podzielnych przez 5 wyświetli liczbę i słowo "Buzz", a podzielnych zarówno przez 3 i 5 wyświetli
     * liczbę i słowo "FizzBuzz". Pozostałe liczby nie powinny być wyświetlane.
     * Zakładamy, że pracujemy na liczbach z przedziału <1; 100>.
     *
     * Program napisz w dwóch wersjach:
     *     - klasycznej iteracyjnej,
     *     - z wykorzystaniem strumieni z Javy 8
     * Zagadnienia przydatne do rozwiązania: pętle, instrukcje sterujące, strumienie
     */


    public static final String DIVIDE_BY_3 = "Fizz";
    public static final String DIVIDE_BY_5 = "Buzz";
    public static final String DIVIDE_BY_3_AND_5 = "FizzBuzz";

    public static void main(String[] args) {

        // sposób 1 (pętla):
        System.out.println(">>> sposób 1 - pętla:");
        for (int i = 1; i <= 100; i++) {
            fizzBuzz(i);
        }

        // sposób 2 (strumień):
        System.out.println(">>> sposób 2 - strumień:");
        IntStream.iterate(1, i -> i+1)
                .limit(100)
                .forEach(Test::fizzBuzz);

        // sposób 3 (strumień):
        System.out.println(">>> sposób 3 - strumień:");
        IntStream.rangeClosed(1, 100)
                .forEach(Test::fizzBuzz);
    }


    private static void fizzBuzz(int num) {
            if(num % 15 == 0)
                System.out.println(num + " " + DIVIDE_BY_3_AND_5);
            else if(num % 3 == 0)
                System.out.println(num + " " + DIVIDE_BY_3);
            else if(num % 5 == 0)
                System.out.println(num + " " + DIVIDE_BY_5);
    }
}
