
package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Scanner;


public class TablicaZPowtórzeniami {


    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
       
        System.out.print("Podaj rozmiar tablicy: ");
        int size = input.nextInt();
        
        System.out.print("Podaj zakres losowanych wartosci [-z, +z]: ");
        int zakres = 2*input.nextInt()+1;
 
        int[] arr = new int[ size ];
        int nr1, nr2, aux;
        boolean jest;
     
        // Losowanie nieunikalnych wartości

        for(int nr = 0; nr < size; nr++ )
            arr[ nr ] = (int)(random()*zakres) - zakres/2;
               
        System.out.println("---------------------------------");
        System.out.println("Tablica nieposortowana");
           
        for(int nr = 0; nr < size; nr++ )
//           System.out.print( arr[ nr ] + " " ); 
            System.out.format("%4d", arr[nr]);
        System.out.println();
        
        Arrays.sort( arr );
/*        for( nr1 = 0; nr1 < size; nr1++ )
          for( nr2 = nr1+1; nr2 < size; nr2++ )
            if( arr[ nr1 ] > arr[ nr2 ] ){
                aux = arr[ nr1 ];
                arr[ nr1 ] = arr[ nr2 ];
                arr[ nr2 ] = aux;
            }
*/        System.out.println("---------------------------------");
        System.out.println("Tablica posortowana");
           
        for(int nr = 0; nr < size; nr++ )
           System.out.print( arr[ nr ] + " " );        
        System.out.println();
              
        System.out.println("---------------------------------");
        
        jest = false;
        for( nr1 = 0; nr1 < size-1; nr1++ )
                    if(arr[nr1] == arr[nr1+1]){
                        jest = true;
                        break;
                    }
        if( jest ) System.out.println("Sa identyczne elementy, np.: " + nr1 + " i " + (nr1+1) + ": " + arr[nr1]);
        else System.out.println("Brak identycznych elementów");
    }
    
}
