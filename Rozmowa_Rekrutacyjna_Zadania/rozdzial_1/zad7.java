package rozdzial_1;

import java.util.Arrays;
import java.util.Set;

public class zad7 {

     /*
     * Napisz algorytm, który jeśli jakiś element macierzy o wymiarach MxN ma wartość zero,
     * ustawia cały wiersz i kolumnę tego elementu na 0.
     */

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 0, 8}, {9, 10, 11, 12}};
        printArray(a);
        printArray(a);

    }


    private static void printArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                if (j == ints.length - 1) System.out.println(ints[j]);
                else System.out.print(ints[j] + " ");
            }
        }
    }
}
