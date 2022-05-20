import java.util.Scanner;

public class Zadanie {
    /*
    * Użytkownik podaje 3 wartości liczbowe typu int. Sprawdź, czy te podane 3 cyfry mogą być ramionami trójkąta
    * */

    public static void main (String[] args) {
        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a=");
        a = scanner.nextInt();
        System.out.print("b=");
        b = scanner.nextInt();
        System.out.print("c =");
        c = scanner.nextInt();

        if (a < b+c || b < a+c || c < a+b) {
            System.out.println("Tak");
        } else {
            System.out.println("Nie");
        }
    }
}
