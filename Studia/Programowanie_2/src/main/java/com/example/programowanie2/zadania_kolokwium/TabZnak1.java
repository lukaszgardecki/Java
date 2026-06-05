
package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Math.random;
import java.util.Scanner;

public class TabZnak1 {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        char[] tabChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' ,'I', 'J', 'K', 'L', 'M', 
                            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        
        int[] counters = new int[ 128 ];
        for( int nr = 0; nr < counters.length; nr++) counters[ nr ] = 0;       
        
        System.out.print("Podaj wielkosc tablicy (liczbe znakow): "); 
        int size = input.nextInt();
        
        char[] chars = new char[ size ];
        
        for( int nr = 0; nr < chars.length; nr ++) 
           chars[ nr ] = tabChars[(int)(random()*62)]; 
        
        for( int nr = 0; nr < chars.length; nr++ )
           counters[ chars[ nr ] ]++;           

        System.out.println("Znaki:");
        for( int nr = 0; nr < chars.length; nr ++) 
           System.out.print( chars[ nr ] + " ");
        System.out.println();

        System.out.println("Liczniki:");
        for( int nr = 0; nr < counters.length; nr++ )
               if( counters[ nr ] > 0 )
                  System.out.println((char)nr + ": " + counters[ nr ] );

    }
    
}
