import java.util.Scanner;

public class PrymitywnyKalkulator {
    public static void main(String[] args) {
        double num1;
        double num2;
        double dzialanie;

        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------");
        System.out.println("Kalkulatorek :)");
        System.out.println("-----------------------");

        System.out.println("Wpisz liczbe nr 1: ");
        num1 = sc.nextInt();

        System.out.println("Wpisz liczbe nr 2: ");
        num2 = sc.nextInt();


        System.out.println("-----------------------");
        System.out.println("Co chcesz zrobic? [wcisnij klawisz]");
        System.out.println("- dodawanie [1]");
        System.out.println("- odejmowanie [2]");
        System.out.println("- mnozenie [3]");
        System.out.println("- dzielenie [4]");
        System.out.println("- reszta z dzielenia [5]");
        System.out.println("-----------------------");

        dzialanie = sc.nextInt();

        if(dzialanie == 1) {
            double wynik;
            wynik = num1 + num2;
            System.out.println("Wynik dodawania liczb " + num1 + " i " + num2 + " to: " + wynik + ".");
        } else if (dzialanie == 2) {
            double wynik;
            wynik = num1 - num2;
            System.out.println("Wynik odejmowania liczb " + num1 + " i " + num2 + " to: " + wynik + ".");
        } else if (dzialanie == 3) {
            double wynik;
            wynik = num1 * num2;
            System.out.println("Wynik mnoezenia liczb " + num1 + " i " + num2 + " to: " + wynik + ".");
        } else if (dzialanie == 4) {
            double wynik;
            wynik = num1 / num2;
            System.out.println("Wynik dzielenia liczb " + num1 + " i " + num2 + " to: " + wynik + ".");
        } else if (dzialanie == 5) {
            double wynik;
            wynik = num1 / num2;
            System.out.println("Wynik dzielenia liczb " + num1 + " i " + num2 + " to: " + wynik + ". A reszta z dzielenia to: " + num1 % num2);
        } else
            System.out.println("Proszę wpisać liczbę od 1 do 5.");

    }
}
