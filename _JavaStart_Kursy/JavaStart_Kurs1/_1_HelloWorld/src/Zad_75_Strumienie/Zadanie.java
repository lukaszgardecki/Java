package Zad_75_Strumienie;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Zadanie {
    public static void main(String[] args) {

        /**
         * Utwórz strumieñ kolejnych liczb ca³kowitych zaczynaj¹c od 0. Nastêpnie korzystaj¹c z metody filter() wybierz tylko te z nich, które s¹ wiêksze od 100, mniejsze od 1000 i podzielne przez 5. Wyœwietl na ekranie pierwszych 10 liczb tego strumienia pomno¿onych przez 3
         *
         * Nie wykorzystuj w programie ani jednej pêtli.
         */

        IntStream.iterate(0, x -> x + 1)
                .filter(num -> num > 100 && num < 1000 && num % 5 == 0)
                .limit(10)
                .map(num -> num * 3)
                .forEach(System.out::println);
    }

}
