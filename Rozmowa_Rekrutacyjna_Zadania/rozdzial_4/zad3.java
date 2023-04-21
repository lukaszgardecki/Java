package rozdzial_4;

public class zad3 {

/*
* Napisz kod, który przyjmuje dodatnią liczbę całkowitą i wyświetla najbliższą mniejszą i większą
* wartość o tej samej liczbie jedynek w reprezentacji binarnej.
*/
    public static void main(String[] args) {
        System.out.println(getBext(5123441));
    }


    static int getBext(int n) {
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while (((c & 1) == 0) && (c != 0)) {
            c0++;
            c >>= 1;
        }
        while ((c & 1) == 1) {
            c1++;
            c >>=1;
        }
//        Błąd: jeśli n == 11..1100..00, nie istnieje większa wartość o tej samej liczbie jedynek
        if (c0  + c1 == 31 || c0 + c1 == 0) return -1;

        int p = c0 + c1; // pozycja ostatniego zera

        n |= (1 << p); //zmiana wartości ostatniego zera, po którym następują jedynki
        n &= ~((1 << p) - 1); // zerowanie wszystkich bitów na prawo od p
        n |= (1 << (c1 - 1)) - 1; //wstawianie (c1 - 1) jedynek na końcu liczby
        return n;

    }
}
