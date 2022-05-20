import java.util.Scanner;
public class Zadanie5 {

    /*
    Pobierz od użytkownika dowolny tekst, następnie pobierz liczbę. Następnie spytaj, czy wydrukować dany tekst. W zależności od odpowiedzi, 1 oznacza tak, 2 oznacza nie, wykonaj zadanie , tzn. wydrukuj tyle razy, jaką liczbę podał użytkownik. Jeśli użytkownik wpisze coś innego niż 1 lub 2, wypisz „nie zrozumiałem, wybierz odpowiedź jeszcze raz”.
     */

    public static void main(String[] args) {
//        Scanner dane = new Scanner(System.in);
//        String tekst;
//        int liczba;
//        int odp;
//
//        System.out.println("Wpisz dowolny tekst: ");
//        tekst = dane.nextLine();
//
//        System.out.println("Wpisz liczbe calkowita: ");
//        liczba = dane.nextInt();
//
//        System.out.println("Czy wydrukowac wpisany tekst? [1]TAK  [2]NIE     ");
//        odp = dane.nextInt();
//
//        if (odp == 1) {
//            for (int i = 1; i <= liczba; i++) {
//                System.out.println(tekst);
//            }
//        } else if (odp == 2) {
//
//        } else
//            System.out.println("Nie zrozumialem. Wybierz odpowiedz jeszcze raz.");
//            odp = dane.nextInt();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz dowolny tekst: ");
        String text = scanner.nextLine();

        System.out.println("Podaj ilosc powtorzen: ");
        int number=scanner.nextInt();

        int print = 0;
        boolean b = true;

        System.out.println("Czy wydrukowac wpisany tekst? [1]TAK  [2]NIE     ");

        while(b){
            print = scanner.nextInt();

            if (print == 1 || print == 2)
                b = false;
            else
                System.out.println("Nie zrozumiałem , czy wydrukowac wpisany tekst? [1]TAK  [2]NIE ");

        }
        if (print == 1)
            for (int i = 0; i < number; i++)
                System.out.println(text);


    }
}
