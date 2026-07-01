package com.example.programowanie2.zadania_kolokwium;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciInf {

    static BigInteger fib2(long n ){
        BigInteger x, y, z;
        long n1;

        if( n==0 ) return BigInteger.ZERO;
        else if( n==1 ) return BigInteger.ONE;
        else {
            x = BigInteger.ZERO;
            y = BigInteger.ONE;
            z = BigInteger.ZERO;

            for( n1 = 2; n1<= n; n1++) {
                z = x.add( y );
                x = y;
                y = z;
            }
            return z;
        }
    }

    static long fib1( long n ){
        long x, y, z;
        long n1;

        if( n==0 ) return 0;
        else if( n==1 ) return 1;
        else {
            x = 0;
            y = 1;
            z = 0;

            for( n1 = 2; n1<= n; n1++) {
                z = x + y;
                x = y;
                y = z;
            }
            return z;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long n;
        System.out.print("Podaj numer elementu: ");
        n = input.nextLong();


        System.out.println( "Fib( " + n + " ) = " + fib1( n ) );
        System.out.println( "Fib( " + n + " ) = " + fib2( n ) );
    }
}
