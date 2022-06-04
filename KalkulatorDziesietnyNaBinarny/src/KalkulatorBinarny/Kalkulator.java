package KalkulatorBinarny;

import java.util.Scanner;

public class Kalkulator {

    public static void main(String[] args) {
        //Scanner skan = new Scanner(System.in);
        long skan = 10;

        double x = (int) (Math.log(skan) / Math.log(2));
        double bi;
        String wynik = "1";
        long liczba = skan;


        System.out.println("Konwerter liczb dziesiêtnych na binarne");


        System.out.println(x);

        //double liczba = skan - Math.pow(2, x); //==2

        for (double i = x; i >= 0; i--) {

            bi = Math.pow(2, i); //==8


            if () {
               wynik += "1";
            } else {
                wynik += "0";

            }
        }
        System.out.println(wynik);
    }
}
