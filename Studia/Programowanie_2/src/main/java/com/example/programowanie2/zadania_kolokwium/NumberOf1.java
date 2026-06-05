package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class NumberOf1 {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
               
       int number;
       int sum = 0;
       int bit;                            
       int maska = 1;
       
       System.out.print("Podaj liczbę: ");
       number = input.nextInt();
       
       for( int bitNo=0; bitNo < 32; bitNo++ ) {
            bit = number & maska;
            maska = maska << 1;

//           sum += bit == 0 ? 0 : 1;

           if( bit != 0 ) sum++;
       }   
       System.out.println( "Liczba jedynek: " + sum );
    }   
}
