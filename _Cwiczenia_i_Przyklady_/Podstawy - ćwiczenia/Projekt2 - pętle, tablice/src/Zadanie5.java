public class Zadanie5 {

    /*
    * Oblicz obwód i pole koła o promieniu 47.
    * */

    public static void main (String[] args) {
        int r = 2;
        double pi = 3.14;
        double obw = 2 * pi * r;
        double pole = pi * Math.pow(r, 2); //funkcja potegująca. w nawiasy wstawiamy najpierw liczbę, która będzie potęgowana, a później liczbę reprezentującą potęgę.

        System.out.println("Obwod kola o promieniu " + r + " wynosi: " + obw);
        System.out.println("Pole kola o promieniu " + r + " wynosi: " + pole);
    }

}
