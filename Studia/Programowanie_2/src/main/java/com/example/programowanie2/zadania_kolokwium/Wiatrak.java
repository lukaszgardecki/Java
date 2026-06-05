// U W A G A 
// Wiatrak działa tylko na konsoli, np. PowerShell


package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Thread.sleep;


public class Wiatrak {
    

    public static void main(String[] args) throws Exception {
        
        int czas = 100;
        int ile  =  10;
        
        System.out.print("-"); sleep( czas );
        for( int i=0; i< ile; i++){
            System.out.print("\b\\"); sleep( czas );
            System.out.print("\b|");  sleep( czas );
            System.out.print("\b/");  sleep( czas );
            System.out.print("\b-");  sleep( czas );
        }
     
    }       
}
    

