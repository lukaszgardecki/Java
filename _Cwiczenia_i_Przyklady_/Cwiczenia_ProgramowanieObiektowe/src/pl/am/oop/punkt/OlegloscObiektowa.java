package pl.am.oop.punkt;

public class OlegloscObiektowa {

    public static double obliczOdleglosc(Punkt p1, Punkt p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;

        return Math.sqrt(dx*dx + dy*dy);
    }

    public static void main(String[] args) {

        Punkt p1 = new Punkt();
        Punkt p2 = new Punkt();

        p1.x = 1;
        p1.y = 4;
        p2.x = 4;
        p2.y = 8;

        double odleglosc = obliczOdleglosc(p1, p2);
        System.out.println(odleglosc);


    }
}
