package Tablice;

import java.util.Arrays;
import java.util.OptionalInt;

public class Tablice2 {
    public static void main(String[] args) {
        int[] mojaTablica = {5, 4, 3, 6, 8, 5, 4, 3, 7, 5};

        int[] kopia = Arrays.copyOf(mojaTablica, mojaTablica.length);

        int suma = 0;


        for (int i = 0; i < kopia.length; i++) {
            suma += kopia[i];
        }
        System.out.println(suma);
    }
}
