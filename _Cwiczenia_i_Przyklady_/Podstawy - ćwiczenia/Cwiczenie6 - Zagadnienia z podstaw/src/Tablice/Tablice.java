package Tablice;

public class Tablice {
    public static void main(String[] args) {

        int[] tablica = {1, 5, 8, 7, 3, 55, 7, 0};

        for (int i = 0; i < tablica.length; i++) {
            System.out.println("P�tla for: " + i);
        }

        for (int jakasmojanazwa : tablica) {
            System.out.println("P�tla each for " + jakasmojanazwa);
        }


    }
}
