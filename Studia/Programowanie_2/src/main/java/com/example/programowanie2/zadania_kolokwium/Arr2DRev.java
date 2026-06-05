package com.example.programowanie2.zadania_kolokwium;

import java.util.Random;
import java.util.Scanner;

public class Arr2DRev {
    
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
        int aux;
       
        System.out.print( "Podaj wielko�� tablicy: " );
        int noRows = input.nextInt();
 
        int[][] arr = new int[ noRows ][ noRows ];
       
        for( row = 0; row < noRows; row++ )            
            for( col = 0; col < noRows; col++ )
//               arr[ row ][ col ] = rnd.nextInt(201)-100;
               arr[ row ][ col ] = noRows*row+col;

        System.out.println("Tablica przed odwr�ceniem:");
        printTab( arr );     
        
        for( row = 1; row < noRows; row++ )           
            for( col = 0; col < row; col++ ){
                aux = arr[ row ][ col ];
                arr[ row ][ col ] = arr[ col ][ row ];
                arr[ col ][ row ] = aux;
            }
        System.out.println("\nTablica po odbiciu wzgl�dem g��wnej przek�tnej:");
        printTab( arr );     
               
        for( row = 0; row < noRows-1; row++ )           
            for( col = 0; col < noRows-row-1; col++ ){
                aux = arr[ row ][ col ];
                arr[ row ][ col ] = arr[ noRows-col-1 ][ noRows-row-1 ];
                arr[ noRows-col-1 ][ noRows-row-1 ] = aux;
            }
        System.out.println("\nTablica po odbiciu wzgl�dem drugiej przek�tnej:");
        printTab( arr );     
    }
}