
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner; 

public class Podziel {

    public static void main(String[] args) {
        long liczba;
        long sumaCyfr;
        Scanner wej = new Scanner( System.in );
        
        System.out.print("Podaj liczbe: ");
        liczba = wej.nextInt();
               
        System.out.print( liczba );
        while( liczba >= 10 ){
            sumaCyfr = 0;
            do{
                sumaCyfr = sumaCyfr + liczba % 10;
                liczba   = liczba / 10;
            } while(liczba>0);
            System.out.print(" --> " + sumaCyfr );
            liczba = sumaCyfr;
        } 
        
        switch((int)liczba){
            case 0, 3, 6, 9 -> System.out.println("\nLiczba jest podzielna przez 3");
            default -> System.out.println("\nLiczba nie jest podzielna przez 3");
        }
    }
}
