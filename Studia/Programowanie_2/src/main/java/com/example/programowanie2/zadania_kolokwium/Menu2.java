package com.example.programowanie2.zadania_kolokwium;

import java.util.Arrays;
import java.util.Scanner;

public class Menu2 {

    static String[] czytDane(){

        System.out.println("\nWczytywanie danych (�a�cuchy w jednej linii, rozdzielone spacjami)\n");
        return new Scanner( System.in ).nextLine().trim().split(" +");

    }

    static void piszTab( String[] tab){

        System.out.println("\nWypisywanie zawarto�ci tablicy\n");

        if( tab != null){
            System.out.println("\nZawarto�� tablicy:");
            for( String word: tab )
                System.out.println( word );
        }
        else System.out.println("\nBrak tablicy!");
        System.out.println();

    }

    static void sortLex( String[] tab ){

        System.out.println("\nSortowanie leksykograficzne\n");

        if( tab != null) Arrays.sort( tab );
        else System.out.println("\nBrak tablicy!");

    }

    static void sortLen( String[] tab ){
        System.out.println("\nSortowanie wed�ug d�ugo�ci �a�cuch�w\n");

        if( tab != null) {
            for( int nr1 = 0; nr1 < tab.length - 1; nr1++ ){
                for( int nr2 = 0; nr2 < tab.length - 1; nr2++ )
                    if( tab[ nr2 ].length() > tab[ nr2 + 1 ].length() ){
                        String aux = tab[ nr2 ];
                        tab[ nr2 ] = tab[ nr2 + 1 ];
                        tab[ nr2 + 1 ] = aux;
                    }
            }
        }
        else System.out.println("\nBrak tablicy!");

    }

    public static void main(String[] args) {
        String[] arr = null;
        Scanner in = new Scanner( System.in );
        int nr;

        do{
            System.out.println("\n MENU");
            System.out.println("------");
            System.out.println("1. Wczytaj dane");
            System.out.println("2. Wypisz tablic�");
            System.out.println("3. Sortuj leksykograficznie");
            System.out.println("4. Sortuj wed�ug d�ugo�ci �a�cuch�w");
            System.out.println("0. Koniec");
            do{
                System.out.print("Wybierz 0-4: ");
                nr = in.nextInt();
            }
            while( nr < 0 || nr > 4 );
            switch( nr ){
                case 1 -> arr = czytDane();
                case 2 -> piszTab( arr );
                case 3 -> sortLex( arr );
                case 4 -> sortLen( arr );
                default -> System.out.print("\nKONIEC\n");
            }
        }
        while( nr != 0 );
    }
}
