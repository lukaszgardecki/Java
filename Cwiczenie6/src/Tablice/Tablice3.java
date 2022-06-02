package Tablice;

import java.util.Arrays;

public class Tablice3 {
    public static void main(String[] args) {
        int[] mojaTablica = {5, 4, 3, 6, 8, 5, 4, 3, 7, 5};

        int[] kopia = Arrays.copyOf(mojaTablica, mojaTablica.length);

        System.out.println(Arrays.toString(mojaTablica));
        System.out.println(Arrays.toString(kopia));

        Arrays.sort(kopia);
        System.out.println(Arrays.toString(kopia));
    }
}
