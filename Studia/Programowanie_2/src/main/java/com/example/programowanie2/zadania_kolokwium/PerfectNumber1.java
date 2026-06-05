
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class PerfectNumber1 {
 
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         long number, sum, divisor;
         
         System.out.print( "Input a number: " );
         number = input.nextLong();  
         
         sum = 1;
         System.out.print( "1" );
         divisor = 2;
         while( divisor <= (number / 2) ){
             // compute divisors and add them
             if( (number % divisor) == 0 ){
                sum += divisor;
                System.out.print( " + " + divisor );
             }   
             divisor++;
         } 
                             
         if( sum == number ) System.out.println( " = " + number + "\nThis is a perfect number" ); 
         else System.out.println( " = " + sum + " != " + number + "\nThis is not a perfect number" );
    }     
}
    
