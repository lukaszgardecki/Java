public class Funkcje {
    public static void main(String[] args) {
        //Wywołanie funkcji 1:
        String tekst = wyswietl();
        System.out.println(tekst);

        //Wywołanie funkcji 2:
        wyswietl2();

        //Wywołanie funkcji 3:
        System.out.println(dodaj());

        //Wywołanie funkcji 4:
        System.out.println(dodaj(5));

        //Wywołanie funkcji 5:
        System.out.println(dodaj(5, 10));

    }

    //Funkcja (metoda) 1:
    static String wyswietl() {
        return "nie Witam";
    }

    //Funkcja (metoda) 2:
    static void wyswietl2() {
        System.out.println("Witam");
    }

    //Funkcja (metoda) 3:
    static int dodaj() {
        return 0;
    }

    //Funkcja (metoda) 4:
    static int dodaj(int x) {
        return ++x;
    }

    //Funkcja (metoda) 5:
    static int dodaj(int x, int y) {
        return x + y;
    }




}
