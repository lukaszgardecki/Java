package Czas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Czas {

    public static void main(String[] args) {

        //Liczba sekund jaka up³ynê³a od 1 stycznia 1990:
        System.out.println(System.currentTimeMillis());

        //Liczba lat jaka up³ynê³a od 1 stycznia 1990:
        System.out.println(System.currentTimeMillis()/(1000*3600*24*365.5));

        //Ró¿nica czasu. W takiej formie wynik wynosi 0 poniewa¿ miêdzy t1 a  t1 nic siê nie dzieje wiêc t1 = t2.
        long t1 = System.currentTimeMillis();
        long t2 = System.currentTimeMillis();
        System.out.println("Ró¿nica czasu miêdzy czasem t2 i t1 wynosi: " + (t2-t1));

        //Ró¿nica czasu.
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1E6; i++) {
            double x1 = Math.pow(Math.random(), 3);
        }
        long koniec1 = System.currentTimeMillis();
        long roznica1 = koniec1 - start1;
        System.out.println("Na wykonanie potêgi metod¹ Math.pow, komputer potrzebowa " + roznica1 + " milisekund");

        System.out.println();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1E6; i++) {
            double x1 = Math.random() * Math.random() * Math.random();
        }
        long koniec2 = System.currentTimeMillis();
        long roznica2 = koniec2 - start2;
        System.out.println("Na wykonanie tej samej potêgi metod¹ wykonan¹ przez przemno¿enie, komputer potrzebowa " + roznica2 + " milisekund");

        //WNIOSEK: PRZY MA£YCH LICZBACH METODA MATH.POW() JEST WOLNIEJSZA NI¯ TA SAMA POTÊGA WYKONANA PRZEZ PRZEMNO¯ENIE. NATOMIAST PRZY DU¯YCH POTÊGACH SZYBSZA JEST METODA MATH.POW().
        //Przy mno¿eniu metod Math.Random() szybsza jest metoda Math.pow().


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
