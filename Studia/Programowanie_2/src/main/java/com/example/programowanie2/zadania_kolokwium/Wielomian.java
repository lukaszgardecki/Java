
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class Wielomian {

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        
        int n;
        double a, x = 0;
        double p = 0;
        
        System.out.print("Podaj stopień wielomianu: ");
        n = input.nextInt();
        if( n> 0 ){
            System.out.print("Podaj x: ");
            x = input.nextDouble();
        }
            
        while( n > 0 ){
            System.out.print("Podaj a" + n + ": ");
            a = input.nextInt();
            p = (p + a) * x;
            n--;
        }
        
        System.out.print("Podaj a" + n + ": ");
        a = input.nextInt();
        p = p + a;
        
        System.out.println( "Wartość wielomianu: " + p );        
 
    }
    
}