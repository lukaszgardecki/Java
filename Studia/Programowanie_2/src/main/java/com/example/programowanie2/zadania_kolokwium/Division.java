
package com.example.programowanie2.zadania_kolokwium;

import java.math.BigInteger;
import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        
        System.out.print( "Input a number: " );
        Scanner input = new Scanner(System.in);
        
        BigInteger number;
        BigInteger digitSum,
                   THREE = new BigInteger("3");
        
        number = new BigInteger(input.next());
        System.out.print( number );
        
        do{
            digitSum = BigInteger.ZERO;
            while(!number.equals( BigInteger.ZERO )){
                digitSum = digitSum.add( number.mod( BigInteger.TEN ) );
                number   = number.divide( BigInteger.TEN );
            }
            number = digitSum;
            System.out.print( " --> " + number );
        } while(number.compareTo( BigInteger.TEN) >= 0 );
        
        if( number.mod(THREE).equals(BigInteger.ZERO))
             System.out.println( "\nThe number is divisible by 3" );
             else System.out.println( "\nThe number is indivisible by 3" );       
    }
        }
