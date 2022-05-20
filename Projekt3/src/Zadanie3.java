import java.util.Scanner;

public class Zadanie3 {

    /*
        Stwórz system do obliczania punktów. Użytkownik wprowadza po kolei 3 ilości, punkty za styl, punkty za efekty i punkty ze rezultat. Punkty za styl pomnóż przez 0.2, punkty za efekty przez 0.3, a punkty za rezultat przez 0.5 i wydrukuj sumę tych działań.
     */
    public static void main (String[] args) {
        Scanner dane = new Scanner(System.in);

        System.out.println("--- SYSTEM OBLICZANIA PUNKTOW ---");
        System.out.println("Wpisz punkty za styl: ");
        int styl = dane.nextInt();

        System.out.println("Wpisz punkty za efekty: ");
        int efekty = dane.nextInt();

        System.out.println("Wpisz punkty za rezultat: ");
        int rezultat = dane.nextInt();

        float stylSuma = styl * 0.2f;
        float efektySuma = efekty * 0.3f;
        float rezultatSuma = rezultat * 0.5f;
        float Suma = stylSuma + efektySuma + rezultatSuma;

        System.out.println("---------------------");
        System.out.println("WYNIKI:");
        System.out.println("---------------------");
        System.out.println("-styl: " + stylSuma);
        System.out.println("-efekty: " + efektySuma);
        System.out.println("-rezultat: " + rezultatSuma);
        System.out.println("---------------------");
        System.out.println("RAZEM: " + Suma);
        System.out.println("---------------------");
    }

}
