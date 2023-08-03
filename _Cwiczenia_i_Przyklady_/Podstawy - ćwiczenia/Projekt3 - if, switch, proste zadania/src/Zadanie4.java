import java.util.Scanner;

public class Zadanie4 {

    /*
    Zadanie po angielsku. Stwórz system do robienia wizytówek. Odpytaj użytkownika o imię (name), nazwisko (surname), numer telefonu (telephone w typie int). Następnie wydrukuj to w ładny sposób, tzn ramka i może jakieś efekty, wedle woli i chęci.
     */

    public static void main(String[] args) {
        Scanner dane = new Scanner(System.in);

        String name, surname;
        int telephone;

        System.out.println("Welcome my friend!");
        System.out.println();
        System.out.println("Enter your name: ");
        name = dane.next();
        System.out.println("Enter your surname: ");
        surname = dane.next();
        System.out.println("Enter your phone number: ");
        telephone = dane.nextInt();

        System.out.println("              ======================================");
        System.out.println("            |                                        |");
        System.out.println("            |      " + name);
        System.out.println("            |                                        |");
        System.out.println("            |            " + surname);
        System.out.println("            |                                        |");
        System.out.println("            |    tel: " + telephone);
        System.out.println("              =======================================");


    }
}
