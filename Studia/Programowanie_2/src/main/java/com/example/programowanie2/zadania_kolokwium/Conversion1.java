package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class Conversion1 {

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        
        long number, radix;
        long digit;
        String result = "";
        
        
        System.out.print( "Podaj liczb�: " );
        number = input.nextLong();
        System.out.print( "Podaj podstaw� liczenia: " );
        radix  = input.nextLong();
        
        while( number > 0){
            digit = number % radix;
            if( digit > 9 ) digit = digit - 10 + 'A';
            else digit += '0';
            result = (char)digit + result;
            number /= radix;
        }
        if( result.equals("") ) result = "0"; 
 

//    result =  Long.toString( number, (int)radix).toUpperCase();

        System.out.println( "Wynik: " + result );
    }   
}
