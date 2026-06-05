package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        
        int a, b, c, d, e;
        int h;
        
        System.out.println("Podaj 5 liczb: ");
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        d = input.nextInt();
        e = input.nextInt();
        
        while( a > b || b > c || c > d || d > e ){
            if( a > b ){ h = a; a = b; b = h;}
            if( b > c ){ h = b; b = c; c = h;}
            if( c > d ){ h = c; c = d; d = h;}
            if( d > e ){ h = d; d = e; e = h;}
        }
        
/*        
        int temp;
        if (a > b) { temp = a; a = b; b = temp; }
        if (a > c) { temp = a; a = c; c = temp; }
        if (a > d) { temp = a; a = d; d = temp; }
        if (a > e) { temp = a; a = e; e = temp; }
        
        if (b > c) { temp = b; b = c; c = temp; }
        if (b > d) { temp = b; b = d; d = temp; }
        if (b > e) { temp = b; b = e; e = temp; }
        
        if (c > d) { temp = c; c = d; d = temp; }
        if (c > e) { temp = c; c = e; e = temp; }
        
        if (d > e) { temp = d; d = e; e = temp; }

*/        
        
        System.out.println( a + " " + b + " " + c + " " + d + " " + e );
    }
}
