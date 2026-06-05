package com.example.programowanie2.zadania_kolokwium;

import java.util.Random;
import java.util.Scanner;

public class Arr2DDiag {
    
    static void printTab( int[][] arr ){
        
        for( int row = 0; row < arr.length; row++ ){            
            for( int col = 0; col < arr[row].length; col++ )
                System.out.format( "%5d", arr[ row ][ col ] );
            System.out.println();            
        }      
    }

    public static void main(String[] args) {
 
        Scanner input = new Scanner( System.in );
        Random  rnd   = new Random();
       
        int col, row;
       
        System.out.print( "Podaj wielko�� tablicy: " );
        int noRows = input.nextInt();
 
        int[][] arr = new int[ noRows ][ noRows ];
       
        for( row = 0; row < noRows; row++ )            
            for( col = 0; col < noRows; col++ )
               arr[ row ][ col ] = rnd.nextInt(201)-100;

        System.out.println("Tablica oryginalna:");
        printTab( arr );     
        
        for( row = 0; row < noRows; row++ )           
            arr[ row ][ row ] = 0;
            
        System.out.println("\nTablica po wyzerowaniu g��wnej przek�tnej:");
        printTab( arr );     
               
        for( row = 0; row < noRows; row++ )           
            arr[ noRows - row - 1 ][ row ] = 0;
        
        System.out.println("\nTablica po wyzerowaniu obu przek�tnych:");
        printTab( arr );     
    }
}