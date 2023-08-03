package pl.am.podstawy.lekcja7;

public class TabliczkaMnozenia {
    public static void main(String[] args) {

        //talbiczka mnozenia wersja 1:
//        for (int i = 1; i <= 10; i++) {
//            for (int j = 1; j <= 10; j++) {
//                int wynik = i * j;
//                System.out.println(i + " * " + j + " = " + wynik);
//            }
//        }
        // tabliczka mnozenia wersja 2:
        for (int j = 1; j <= 10; j++) {
            for (int i = 1; i <= 10; i++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }
    }
}
