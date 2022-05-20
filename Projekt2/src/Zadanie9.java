public class Zadanie9 {

    /*
     Utwórz 10-elementową tablicę i przypisz jej komórkom wartości 11, 22 itd. do 110, a następnie wydrukuj.
     */

    public static void main(String[] args) {
        int tab[] = new int[10];

        tab[0] = 11;
        tab[1] = 22;
        tab[2] = 33;
        tab[3] = 44;
        tab[4] = 55;
        tab[5] = 66;
        tab[6] = 77;
        tab[7] = 88;
        tab[8] = 99;
        tab[9] = 110;

        for (int i = 0; i < 10; i++) {
            System.out.println(tab[i]);
        }
    }

}
