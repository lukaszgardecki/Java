package zad4._4;

public class Main {
    public static void main(String[] args) {
        Punkt punkt = new Punkt();
        Punkt pomocniczyPunkt;

        pomocniczyPunkt = punkt.pobierzWspolrzedne();

        System.out.println("Przed ustawieniem wsp�rz�dnych:");
        System.out.println("Wsp�rz�dna x = " + pomocniczyPunkt.x);
        System.out.println("Wp�rz�dna y = " + pomocniczyPunkt.y);

        punkt.ustawWspolrzedne(1, 10);
        pomocniczyPunkt = punkt.pobierzWspolrzedne();

        System.out.println("Po ustawieniu wsp�rz�dnych:");
        System.out.println("Wsp�rz�dna x = " + pomocniczyPunkt.x);
        System.out.println("Wp�rz�dna y = " + pomocniczyPunkt.y);
    }
}
