
package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Math.random;
import java.util.Scanner;


public class TabZnakLosSortTab2Wym {

    public static void main(String[] args) {
       
        Scanner input = new Scanner( System.in );

        char[] tabChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' ,'I', 'J', 'K', 'L', 'M', 
                            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        
        int[][]  liczniki = new int[ 128 ][ 2 ];

        for( int nr = 0; nr < liczniki.length; nr++){
            liczniki[ nr ][ 0 ] = nr;
            liczniki[ nr ][ 1 ] = 0;
        }       
        
        System.out.print("Podaj wielko�� tablicy (liczb� znak�w): "); 
        int size = input.nextInt();
        
        char[] znaki = new char[ size ];
        
        for( int nr = 0; nr < znaki.length; nr++) 
           znaki[ nr ] = tabChars[(int)(random()*62)]; 
        
        for( int nr = 0; nr < znaki.length; nr++ )
           liczniki[ znaki[ nr ] ][ 1 ]++;           

        int[] pom;
        for( int nr1 = 0; nr1 < liczniki.length - 1; nr1++)
            for( int nr2 = nr1 + 1; nr2 < liczniki.length; nr2++)
                 if( liczniki[ nr1 ][ 1 ] < liczniki[ nr2 ][ 1 ])
                    { pom             = liczniki[ nr1 ];
                      liczniki[ nr1 ] = liczniki[ nr2 ];
                      liczniki[ nr2 ] = pom;
                    }
        
        System.out.println("Znaki:");
        for( int nr = 0; nr < znaki.length; nr ++) 
           System.out.print( znaki[ nr ] + " ");
        System.out.println();

        System.out.println("Liczniki:");
        for (int[] liczniki1 : liczniki) {
            if (liczniki1[1] > 0) {
                System.out.println("'" + (char) liczniki1[0] + "': " + liczniki1[1]);
            }
        }
    }   
}
