package Zad_75_Strumienie;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Zadanie {
    public static void main(String[] args) {

        /**
         * Utw�rz strumie� kolejnych liczb ca�kowitych zaczynaj�c od 0. Nast�pnie korzystaj�c z metody filter() wybierz tylko te z nich, kt�re s� wi�ksze od 100, mniejsze od 1000 i podzielne przez 5. Wy�wietl na ekranie pierwszych 10 liczb tego strumienia pomno�onych przez 3
         *
         * Nie wykorzystuj w programie ani jednej p�tli.
         */

        IntStream.iterate(0, x -> x + 1)
                .filter(num -> num > 100 && num < 1000 && num % 5 == 0)
                .limit(10)
                .map(num -> num * 3)
                .forEach(System.out::println);
    }

}
