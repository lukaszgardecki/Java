public class Main {

    /**
     * Napisz program, w którym dodasz do siebie trzy liczby zmiennoprzecinkowe a sumę wyświetlisz na ekranie.
     * Program napisz w dwóch wersjach:
     *
     *     bez wykorzystywania zmiennych
     *     z wykorzystaniem zmiennych do przechowywania liczb oraz wyniku dodawania
     *
     * Przy wyświetlaniu zaokrąglij wynik do dwóch miejsc po przecinku. Wynik powinien być wyświetlony w formie:
     *                          A + B + C = WYNIK
     */

    public static void main(String[] args) {
        System.out.println(">>> wersja bez wykorzystania zmiennych:");
        System.out.println("2.45 + 1.13 + 1.1 = " + (2.45+1.13+1.1));


        System.out.println(">>> wersja z wykorzystaniem zmiennych");
        double a = 2.45;
        double b = 1.13;
        double c = 1.1;
        double result = a + b + c;
        System.out.println(a + " + " + b + " + " + c + " = " + result);


    }
}
