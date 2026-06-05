
package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Scanner;


public class TablicaBezPowtórzeń {


    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );        
 
        System.out.print("Podaj zakres losowanych wartosci [-z, +z]: ");
        int zakres = 2*input.nextInt()+1;
        
         int size;
        do{
            System.out.print("Podaj rozmiar tablicy (mniejszy od " + (zakres+1) + "): ");
            size = input.nextInt();
        }    
        while(size > zakres);
        
        int[] arr = new int[ size ];
        int nr1, nr2, aux;
        boolean jest;
     
        // Losowanie unikalnych wartości
        
        arr[ 0 ] = (int)(random()*zakres) - zakres/2;
        for( nr1 = 1; nr1 < size; nr1++ )
            do{
                aux = (int)(random()*zakres) - zakres/2;
                jest = false;
                for(nr2 = 0; nr2 < nr1; nr2++)
                    if(arr[nr2] == aux){
                        jest = true;
                        break;
                    }
                if( !jest ) arr[ nr1 ] = aux;
            }    
            while( jest );
         
        System.out.println("---------------------------------");
        System.out.println("Tablica nieposortowana");
           
        for(int nr = 0; nr < size; nr++ )
           System.out.print( arr[ nr ] + " " );        
        System.out.println();
        
        Arrays.sort( arr );

        System.out.println("---------------------------------");
        System.out.println("Tablica posortowana");
           
        for(int nr = 0; nr < size; nr++ )
//           System.out.print( arr[ nr ] + " " );
            System.out.format("%4d", arr[nr]);

        System.out.println();
              
        System.out.println("---------------------------------");
        
        jest = false;
        for( nr1 = 1; nr1 < size; nr1++ )
                    if(arr[nr1-1] == arr[nr1]){
                        jest = true;
                        break;
                    }
        if( jest ) System.out.println("Sa identyczne elementy: " + (nr1-1) + " i " + nr1 + ": " + arr[nr1]);
        else System.out.println("Brak identycznych elementow");
    }
    
}
