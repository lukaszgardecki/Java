package zad4._4;

public class Main {
    public static void main(String[] args) {
        Punkt punkt = new Punkt();
        Punkt pomocniczyPunkt;

        pomocniczyPunkt = punkt.pobierzWspolrzedne();

        System.out.println("Przed ustawieniem wspó³rzêdnych:");
        System.out.println("Wspó³rzêdna x = " + pomocniczyPunkt.x);
        System.out.println("Wpó³rzêdna y = " + pomocniczyPunkt.y);

        punkt.ustawWspolrzedne(1, 10);
        pomocniczyPunkt = punkt.pobierzWspolrzedne();

        System.out.println("Po ustawieniu wspó³rzêdnych:");
        System.out.println("Wspó³rzêdna x = " + pomocniczyPunkt.x);
        System.out.println("Wpó³rzêdna y = " + pomocniczyPunkt.y);
    }
}
