package rozdzial_1;

import java.util.Arrays;

public class zad6 {

     /*
     * Dany jest rysunek reprezentowany przez macierz o wymiarach NxN, w którym kazdy piksel
     * jest reprezentowany pza pomocą czterech bajtów. Napisz metodę, która rotuje rysunek
     * o 90 stopni. Czy potrafisz wykonać tę operację w miejscu?
     */

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotate = rotate(a);
        System.out.println(Arrays.deepToString(rotate));

    }

    private static int[][] rotate(int[][] arr) {
        // Przyjęto rotację w prawo o 90stopni.
        // dla uproszczenia piksel (4 bajty) zastąpiono liczbą całkowitą

        int[][] temp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp[j][arr.length-i-1] = arr[i][j];
            }
        }
        return temp;
    }
}
