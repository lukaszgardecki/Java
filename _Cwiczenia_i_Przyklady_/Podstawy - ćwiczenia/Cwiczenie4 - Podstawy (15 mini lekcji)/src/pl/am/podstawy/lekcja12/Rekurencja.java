package pl.am.podstawy.lekcja12;

public class Rekurencja {
    public static void metoda1() {
        System.out.println("metoda 1");
        metoda2();
        System.out.println("koniec");
    }

    public static void metoda2() {
        System.out.println("metoda 2");
    }

    public static void rekurencja() {
        rekurencja();
    }

    //rekurencja! metoda wywołuje samą siebie
    public static void odlicz(int i) {
        if (i >= 1) {
            System.out.println(i);
            i--;
            odlicz(i);
        }
        System.out.println("Wyjscie z metody dla i = " + i);
    }

    public static void odlicz2(int i) {
        if (i < 1) return;
            System.out.println(i);
            odlicz(--i);

        System.out.println("Wyjscie z metody dla i = " + i);
    }

    public static void main(String[] args) {
//        metoda1();
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("*********");
        odlicz(5);
    }
}
