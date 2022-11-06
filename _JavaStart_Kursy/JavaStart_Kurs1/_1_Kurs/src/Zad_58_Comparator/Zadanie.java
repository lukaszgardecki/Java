package Zad_58_Comparator;

import java.util.Arrays;
import java.util.Comparator;

class Zadanie {
    public static void main(String[] args) {

        Integer[] numbers = new Integer[]{-45, 0, 23, 5, 4, 88, 7, -1, -4, -100, 100, 101, 55, 34, 86, 9, 67, 69, 4, 1};

        System.out.println("Tablica stan oryginalny:");
        System.out.println(Arrays.toString(numbers));

        System.out.println("Tablica sortowanie rosn¹ce:");
        Arrays.sort(numbers, new Comparator<>() {

            @Override
            public int compare(Integer n1, Integer n2) {
                if (n1 > n2) {
                    return 1;
                } else if (n2 > n1) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(numbers));

        System.out.println("Tablica sortowanie malej¹ce:");
        Arrays.sort(numbers, new Comparator<>() {

            @Override
            public int compare(Integer n1, Integer n2) {
                if (n1 > n2) {
                    return -1;
                } else if (n2 > n1) {
                    return 1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(numbers));
    }
}
