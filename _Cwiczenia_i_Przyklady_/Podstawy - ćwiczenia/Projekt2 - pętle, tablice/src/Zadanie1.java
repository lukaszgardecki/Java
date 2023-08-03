public class Zadanie1 {

    /*
    * Utwórz dwie zmienne int o nazwach z1 i z2, o wartościach odpowiednio 15 i 5, a następnie wydrukuj na ekranie:
        15+5=
        15-5=
        15*5=
        15/5=
        15%5=
    * */

    public static void main(String[] args) {
        int z1 = 15;
        int z2 = 5;
        int dodawanie = z1 + z2;
        int odejmowanie = z1 - z2;
        int mnozenie = z1 * z2;
        int dzielenie = z1 / z2;
        int reszta = z1 % z2; //reszta z dzielenie

        System.out.println("15+5=" + dodawanie);
        System.out.println("15-5=" + odejmowanie);
        System.out.println("15*5=" + mnozenie);
        System.out.println("15/5=" + dzielenie);
        System.out.println("15%5=" + reszta);
    }
}
