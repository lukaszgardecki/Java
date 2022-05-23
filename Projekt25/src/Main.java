public class Main {

    // Rekurencja - czyli odwoływanie się do samego siebie, tzn metoda może odwoływać się do samej siebie
    //algorytmy rekurencyjne

    public static void main(String[] args) {
        //ustalamy zmienną:
        final int LICZBA = 3;
        //licz czas
        long start = System.nanoTime();
        //wyświetl silnie z liczby
        System.out.println(silnia(LICZBA));
        long elapsed = System.nanoTime() - start;
        System.out.println("Czas: " + elapsed);

        System.out.println();

        //    Rekurencja:
        start = System.nanoTime();
        System.out.println(silniaRek(LICZBA));
        elapsed = System.nanoTime() - start;
        System.out.println("Czas: " + elapsed);

    }


    //metoda odwołuje się do samej siebie, rekurencja w tym przypadku jest dużo szybsza
    private static long silniaRek(int x) {
        if (x <= 1) {
            return 1;
        } else {
            return x * silniaRek(x - 1);
        }

    }


    private static long silnia(int x) {
            long wynik = 1;
            while (x > 1) {
                wynik *= x;
                x--;
            }
            return wynik;
    }

}
