
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class PerfectNumber2 {
 
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
         int number, sum, maxNum;
         
         System.out.print( "Input the max number: " );
         maxNum = input.nextInt();  
         
         System.out.println( "Perfect numbers:" );
         for( number = 1; number <= maxNum; number++ ){
            sum = 0;
            for( int n = 1; n <= number / 2; n++ )
                // compute divisors and add them
                if( ((number/n) * n) == number ) sum += n; 
                             
            if( sum == number ) System.out.println( number ); 
         } 
         System.out.println( "\nThe end!\n" ); 
    }     
}
    
