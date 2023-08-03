public class Zadanie6 {

    /*
    * 1. Przy pomocy pętli wydrukuj na ekranie coś takiego:

     *
     **
     ***
     ****
     *****
     ******
     *******
     ********
     *********
     **********

    * */

    public static void main (String[] args) {
        String as = "";
        for (int i = 0; i < 10; i++) {
            as = as + "*";
            System.out.println(as);
        }
    }
}
