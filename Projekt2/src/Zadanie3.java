public class Zadanie3 {

    /*
    * Utwórz zmienną typu double o wartości 10.123456789 i wykonaj na niej 10 inkrementacji. Jaka jest teraz wartość zmiennej? Dlaczego tak się dzieje? Jak nazywamy takie zjawisko?
    * */

    public static void main (String[] args) {
        double liczba = 10.123456789;

        for (int i = 0; i < 10; i++ ) {
            liczba = liczba + 1;
            System.out.println(liczba);
        }


    }
}
