package pl.am.oop.punkt;

public class Oleglosc {

    public static double obliczOdleglosc(double p1x, double p1y, double p2x, double p2y) {
        double dx = p1x - p2x;
        double dy = p1y - p2y;

        return Math.sqrt(dx*dx + dy*dy);
    }

    public static void main(String[] args) {
        double p1x = 1;
        double p1y = 4;
        double p2x = 4;
        double p2y = 8;

        double odleglosc = obliczOdleglosc(p1x, p1y, p2x, p2y);
        System.out.println(odleglosc);

    }
}
