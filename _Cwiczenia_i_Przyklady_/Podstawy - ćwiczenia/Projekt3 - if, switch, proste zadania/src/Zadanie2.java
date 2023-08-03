import java.util.Scanner;

public class Zadanie2 {
    /*
        Użytkownik wprowadza 3 liczby od 1 do 100. Wydrukuj je w kolejności rosnącej.
     */
    public static void main(String[] args) {

        Scanner zmienna = new Scanner(System.in);
        int a, b, c;

        //Wprowadzenie przeż użytkownika liczb:
        System.out.println("Wprowadz liczbe nr 1: ");
        a = zmienna.nextInt();
        System.out.println("Wprowadz liczbe nr 2: ");
        b = zmienna.nextInt();
        System.out.println("Wprowadz liczbe nr 3: ");
        c = zmienna.nextInt();

        if (a < b && b < c)
            System.out.println("Liczby w kolejnosci rosnacej: " + a + ", " + b + ", " + c + ".");
        else if (c < b && b < a)
            System.out.println("Liczby w kolejnosci rosnacej: " + c + ", " + b + ", " + a + ".");
        else if (a < c && c < b)
            System.out.println("Liczby w kolejnosci rosnacej: " + a + ", " + c + ", " + b + ".");
        else if (c < a && a < b)
            System.out.println("Liczby w kolejnosci rosnacej: " + c + ", " + a + ", " + b + ".");
        else if (b < c && c < a)
            System.out.println("Liczby w kolejnosci rosnacej: " + b + ", " + c + ", " + a + ".");
        else if (b < a && a < c)
            System.out.println("Liczby w kolejnosci rosnacej: " + b + ", " + a + ", " + c + ".");

//        {
//            if (c > b)
//            System.out.println("Liczby w kolejnosci rosnacej: " + a + ", " + b + ", " + c + ".");
//        else if (c > a)
//            System.out.println("Liczby w kolejnosci rosnacej: " + a + ", " + c + ", " + b + ".");
//        else
//            System.out.println("Liczby w kolejnosci rosnacej: " + c + ", " + a + ", " + b + ".");




    }
}
