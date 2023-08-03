public class Zadanie8 {
    /*
    Wydrukuj litery alfabetu od a do z przy pomocy pętli
     */

    public static void main (String [] args) {
        char lita = 'a';
        char litz = 'z';

        do {
            System.out.println(lita);
            lita++;
        } while (lita <= litz);
    }
}
