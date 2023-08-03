package pl.am.oop.punkt;

public class OlegloscPunktProsta {

    //Obliczenie odleg³osci punktu od prostej

    public static double obliczOdleglosc(Punkt p1, Prosta prosta1) {
        double licznik = Math.abs(prosta1.A*p1.x + prosta1.B*p1.y + prosta1.C);
        double mianownik = Math.sqrt(prosta1.A * prosta1.A + prosta1.B * prosta1.B);

        return licznik / mianownik;
    }

    public static void main(String[] args) {

        Punkt p1 = new Punkt();
        Prosta prosta1 = new Prosta();

        p1.x = 1;
        p1.y = 4;
        prosta1.A = 1;
        prosta1.B = 1;
        prosta1.C = 1;

        double odleglosc = obliczOdleglosc(p1, prosta1);
        System.out.println();
        System.out.println("Odleg³oœæ punktu o wspó³rzêdnych x=" + p1.x + " i y=" + p1.y + " od prostej o parametrach A=" + prosta1.A + ", B=" + prosta1.B + ", C=" + prosta1.C + ", wynosi " + odleglosc);


    }
}
