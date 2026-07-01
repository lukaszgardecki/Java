package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class Conversion2 {

    static long inputNumber(){

        Scanner input = new Scanner( System.in );
        long number = 0;
        boolean right = false;

        do{
            try{
                number = Long.parseLong(input.nextLine());
                right = true;
            }
            catch(NumberFormatException e )
            { System.out.println( "To nie jest poprawna liczba ca�kowita !!!" );
                System.out.print( "Podaj liczb�: " );}
        }
        while( !right );

        return number;
    }
/*
static long inputNumber(){

        Scanner input = new Scanner( System.in );
        long number = 0;
        boolean right = false;

        do{
            try{
                number = input.nextLong();
                right = true;
            }
            catch( InputMismatchException e )
                { System.out.println( "To nie jest poprawna liczba ca�kowita !!!" );
                  input.nextLine();
                  System.out.print( "Podaj liczb�: " );}
        }
        while( !right );

        return number;
    }
*/

    static long inputRadix(){

        long radix = 0;

        do{
            System.out.print("Podaj podstaw� systemu liczenia (2-36): ");
            radix = inputNumber();}
        while( radix < 2 || radix > 36 );

        return radix;
    }

    public static void main(String[] args) {

        long number, radix;
        String result;

        System.out.print( "Podaj liczb�: " );
        number = inputNumber();

        radix = inputRadix();

        result =  Long.toString( number, (int)radix).toUpperCase();

        System.out.println( "Wynik: " + result );
    }
}
