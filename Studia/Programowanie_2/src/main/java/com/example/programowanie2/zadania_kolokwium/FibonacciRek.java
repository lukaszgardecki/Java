package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class FibonacciRek {

    static long fib( int n ){

        return n==0 ? 0 :
                n==1 ? 1 :
                        fib( n-2 ) + fib( n-1 );

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n;

        System.out.print("Podaj numer elementu: ");
        n = input.nextInt();

        System.out.println( "Fib( " + n + " ) = " + fib( n ) );
    }
}
