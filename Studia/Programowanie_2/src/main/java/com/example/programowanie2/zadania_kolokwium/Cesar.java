package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class Cesar {


    static String cezar( String lancuch, int oIle ){
        char[] slownik = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X' ,'Y', 'Z', ' '};

        String wynik = "";
        String blad = ">> blad! <<";
        char zn, zn1;

        if( oIle < -100 || oIle > 100 ) return blad;
        else {
            for( int nr = 0; nr < lancuch.length(); nr++ ){
                zn =lancuch.charAt( nr );
                if( zn >= 'a' && zn <= 'z' ) zn1 = (char)( zn - 'a' );
                else
                if( zn >= 'A' && zn <= 'Z' ) zn1 = (char)(zn - 'A' + 26);
                else
                if( zn == ' ' ) zn1 = 52;
                else return blad;
                wynik += slownik[ ((zn1 + oIle) + 2 * slownik.length) % slownik.length ];
//                wynik += slownik[ ((zn1 + oIle) % slownik.length + slownik.length) % slownik.length ];
            }
        }
        return wynik;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        System.out.print("Podaj lancuch: ");
        String lancuch = input.nextLine();

        System.out.print("Podaj przesuniecie: ");
        int oIle = input.nextInt();

        System.out.println( "Wynik: " + cezar( lancuch, oIle) );

    }

}
