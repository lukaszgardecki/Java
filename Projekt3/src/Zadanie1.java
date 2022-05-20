import java.util.Scanner;

public class Zadanie1 {
    /*
        Sprawdź, czy wprowadzona przez użytkownika liczba jest pierwsza (0 i 1 nie są pierwsze, 2 jest liczbą pierwszą, dalej standardowa definicja). Do sprawdzenia użyj prostego algorytmu sprawdzającego, czy liczba dzieli się przez wszystkie liczby mniejsze od jej połowy. Jeśli dzieli się przez którąkolwiek, nie jest pierwsza.
     */
    public static void main (String[] args) {
        System.out.println("Podaj liczbe: ");
        Scanner podajLiczbe = new Scanner(System.in);
        int liczba = podajLiczbe.nextInt();
        int polowa = liczba / 2;
        boolean warunek = false;
        int x;

        for (x = 2; x < polowa; x++) {
            if (liczba % x == 0) {
                warunek = true;
            }
        }

        if (liczba == 0 || liczba == 1)
            System.out.println(liczba + " nie jest liczbą pierwsza");
        else if (liczba == 2 || liczba == 3)
            System.out.println(liczba + " jest liczba pierwsza");
        else if(warunek == true){
            System.out.println(liczba + " nie jest liczba pierwsza");
        }
        else{
            System.out.println(liczba + " jest liczba pierwsza");
        }
    }
}
