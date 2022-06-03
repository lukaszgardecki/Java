package Czas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Czas {

    public static void main(String[] args) {

        //Liczba sekund jaka up�yn�a od 1 stycznia 1990:
        System.out.println(System.currentTimeMillis());

        //Liczba lat jaka up�yn�a od 1 stycznia 1990:
        System.out.println(System.currentTimeMillis()/(1000*3600*24*365.5));

        //R�nica czasu. W takiej formie wynik wynosi 0 poniewa� mi�dzy t1 a  t1 nic si� nie dzieje wi�c t1 = t2.
        long t1 = System.currentTimeMillis();
        long t2 = System.currentTimeMillis();
        System.out.println("R�nica czasu mi�dzy czasem t2 i t1 wynosi: " + (t2-t1));

        //R�nica czasu.
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1E6; i++) {
            double x1 = Math.pow(Math.random(), 3);
        }
        long koniec1 = System.currentTimeMillis();
        long roznica1 = koniec1 - start1;
        System.out.println("Na wykonanie pot�gi metod� Math.pow, komputer potrzebowa " + roznica1 + " milisekund");

        System.out.println();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1E6; i++) {
            double x1 = Math.random() * Math.random() * Math.random();
        }
        long koniec2 = System.currentTimeMillis();
        long roznica2 = koniec2 - start2;
        System.out.println("Na wykonanie tej samej pot�gi metod� wykonan� przez przemno�enie, komputer potrzebowa " + roznica2 + " milisekund");

        //WNIOSEK: PRZY MA�YCH LICZBACH METODA MATH.POW() JEST WOLNIEJSZA NI� TA SAMA POT�GA WYKONANA PRZEZ PRZEMNO�ENIE. NATOMIAST PRZY DU�YCH POT�GACH SZYBSZA JEST METODA MATH.POW().
        //Przy mno�eniu metod Math.Random() szybsza jest metoda Math.pow().


        Date dzis = new Date();
        System.out.println(dzis);
        //drukowanie daty w formacie:
        System.out.printf("%tc", dzis);

        System.out.println();

        GregorianCalendar dzis2 = new GregorianCalendar();
        GregorianCalendar urodziny = new GregorianCalendar(1994,3,18);
        int rok = dzis2.get(Calendar.YEAR);
        int dzien = dzis2.get(Calendar.DAY_OF_MONTH);

        System.out.println(rok + " " + dzien);
        System.out.println();
        System.out.printf("%tc", urodziny);



    }
}
