import java.util.Arrays;
import java.util.Optional;

public class Main {

    /**
     * Zdefiniuj klasę, a w niej użytkowe metody do operacji na tablicach:
     *
     *   - przyjmuje dwie tablice dwuwymiarowe liczb całkowitych i zwraca tę, w której suma liczb jest większa,
     *   - przyjmuje dwie tablice z napisami i zwraca tę z nich, w której łączna liczba znaków we wszystkich słowach
     *     jest większa. Przykładowo dla tablic ["aa", "bb"], ["aaa", "bbb"] zwrócona zostanie druga
     *     tablica, bo łączna liczba znaków wynosi w niej 6,
     *   - zwraca największą liczbę z tablicy typu int[],
     *   - zwraca najmniejszą liczbę z tablicy typu int[],
     *   - przyjmuje dwuwymiarową tablicę liczb typu int[][] i zwraca tablicę jednowymiarową, w której suma
     *     elementów jest największa (największy wiersz). Przykładowo dla tablicy[[1, 2, 3], [7, 8, 9], [3, 4, 5]],
     *     powinna zostać zwrócona tablica [7, 8, 9].
     *
     * Zakładamy, że do metod nikt nie przekaże wartości null, ani pustych tablic.
     *
     * W osobnej klasie przetestuj działanie każdej metody na co najmniej jednym przykładowych danych.
     */

    public static void main(String[] args) {

        int[][] tab1 = {{3, 2, 3}, {4, 5, 6}, {1, 2, 3}, {2, 3, 4}};
        int[][] tab2 = {{2, 2, 3}, {4, 5, 6}, {1, 2, 3}, {2, 3, 4}};
        int[][] arrayWithGreaterTotalSum = Tablica.getArrayWithGreaterTotalSum(tab1, tab2);
        System.out.println(Arrays.deepToString(arrayWithGreaterTotalSum));

        String[] tab3 = {"aa", "bb"};
        String[] tab4 = {"aaa", "bbb"};
        String[] arrayWithGreaterTotalSumOfCharacters = Tablica.getArrayWithGreaterTotalSumOfCharacters(tab3, tab4);
        System.out.println(Arrays.toString(arrayWithGreaterTotalSumOfCharacters));

        int[] tab5 = {5, 1, 1, 99, 0, -1, 190};
        long theGreatestNum = Tablica.getTheGreatestNum(tab5);
        System.out.println(theGreatestNum);

        long theLowestNum = Tablica.getTheLowestNum(tab5);
        System.out.println(theLowestNum);

        int[][] tab6 = {{3, 2, 3}, {4, 5, 6}, {1, 2, 31}, {2, 3, 4}};
        int[] ints = Tablica.getArrayWithTheGreatestTotalSumOfSubArray(tab6);
        System.out.println(Arrays.toString(ints));

    }
}
