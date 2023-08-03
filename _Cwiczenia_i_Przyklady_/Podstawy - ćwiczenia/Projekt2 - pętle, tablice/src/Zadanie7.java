public class Zadanie7 {

    /*
    * Utwórz i wydrukuj na ekranie taką tablicę używając poleceń new int oraz pętli.

                11111
                111
                11111111
    */

    public static void main(String[] args) {
        int tablica[] = new int[3];

        tablica[0] = 11111;
        tablica[1] = 111;
        tablica[2] = 11111111;

        for (int i = 0; i < tablica.length; i++) {
            System.out.println(tablica[i]);
        }
    }
}
