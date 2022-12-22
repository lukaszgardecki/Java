import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    /**
     * Napisz program, w którym przekażesz jako argumenty wywołania dowolną ilość liczb całkowitych. Wyświetl na ekranie:
     *
     *     ilość przekazanych liczb
     *     przekazane liczby
     *     kwadraty przekazanych liczb
     *     sumę wszystkich przekazanych liczb w postaci A+B+C+...+N = SUMA
     *
     * W zadaniu zakładamy, że użytkownik nie przekazuje żadnych argumentów
     *lub przekazuje poprawne argumenty liczbowe (nie musimy się przejmować tym, że argumentem może być np. jakiś napis "abc")
     *
     * Zagadnienia przydatne do rozwiązania: definiowanie zmiennych, tablice, pętle
     */
    public static void main(String[] args) {
        System.out.printf("Ilość przekazanych liczb: %d\n", args.length);
        System.out.printf("Przekazane liczby: %s\n", String.join(", ", args));
        System.out.printf("Kwadraty przekazanych liczb: %s\n",
                Arrays.stream(args)
                        .map(Integer::valueOf)
                        .map(liczba -> liczba * liczba)
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
        );
        System.out.printf("Suma wszystkich przekazanych liczb: %s = %s",
                String.join(" + ", args),
                Arrays.stream(args)
                        .map(Integer::parseInt)
                        .mapToInt(e -> e)
                        .sum()
        );
    }
}
