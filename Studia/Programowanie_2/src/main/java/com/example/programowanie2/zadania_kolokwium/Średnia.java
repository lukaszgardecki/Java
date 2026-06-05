
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;


public class Średnia {

    public static void main(String[] args) {
        int lEl = 0;
        int suma = 0;
        int liczba, średnia;
 
        Scanner wej = new Scanner(System.in);
        
        System.out.print("Podaj liczbe (999 konczy): ");
        liczba = wej.nextInt();
        
        while( liczba != 999 ){
            suma += liczba;
            lEl++;

            System.out.print("Podaj liczbe (999 konczy): ");
            liczba = wej.nextInt();
        }
        if( lEl > 0 ){
            średnia = suma / lEl;
            System.out.println("Srednia liczb wynosi: " + średnia);
        } else System.out.println("Ciag pusty");

        
        
    }
    
}
