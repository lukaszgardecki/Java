package zad2._13;

    //Przekroczenie zakresu w trakcie dzia³ania kodu
public class Main {
    public static void main(String[] args) {
        int wartosc = 2147483647;
        int wartosc1 = wartosc + 1;
        int wartosc2 = wartosc + wartosc;
        System.out.println("wartosc = " + wartosc);
        System.out.println("wartosc + 1 = " + wartosc1);
        System.out.println("wartosc + wartosc = " + wartosc2);
    }
}
