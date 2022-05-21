import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i = 0; //zmienna zawierająca ilość prób
        int los;    //zmienna przechowująca liczbę wylosowaną przez komputer
        int odp;    //zmienna przechowująca liczbę, którą wpisuje użytkownik

        //Losowa liczba
        Random rnd = new Random();
        los = rnd.nextInt(10) + 1;

        //Umożliwienie wpisania liczby do konsoli przez użytkownika
        Scanner scanner = new Scanner(System.in);

        System.out.println("Zgadnij liczbę od 1 do 10!");
        do {
            i++;
            System.out.println("Podaj liczbe: ");
            odp = scanner.nextInt();
            if (odp > los) {
                System.out.println("Niestety nie zgadłeś! Moja liczba jes mniejsza.");
            } else if (odp < los) {
                System.out.println("Niestety nie zgadłeś! Moja liczba jes większa.");
            }
        }while (odp != los);
        System.out.println("Brawo odgadłeś za " + i + " razem!");
    }
}
