
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;


public class EquationWithComplex {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        double a, b, c;
        double xR = 0, xI = 0; 
        double delta;
        int numOfSolutions;
        boolean complex = false;
    
        System.out.print("Podaj a b c : ");
        a = input.nextDouble(); 
        b = input.nextDouble(); 
        c = input.nextDouble(); 

        if( a == 0 ) System.out.println( "To nie jest równanie kwadratowe !!!" );
        else{
            delta = b*b-4*a*c;
            xR = -b/(2*a);
            if( delta < 0 ) {
                complex = true;
                delta = -delta;
            }    
            if( delta == 0 ) numOfSolutions = 1;
            else {
                numOfSolutions = 2;
                xI = Math.sqrt( delta )/(2*a); 
            }
            
            System.out.print( "Liczba pierwiastków: " + numOfSolutions + "\nPierwiastki: " );
            if( numOfSolutions == 1 ) System.out.println( xR );
            else 
                if( complex ) 
//                    System.out.println( "(" + xR + "," + -xI + " i) oraz (" + xR + ", " + xI + " i)");
                    System.out.format("  %.2f-%.2f i   oraz   %.2f+%.2f i\n", xR, Math.abs(xI), xR, Math.abs(xI));
                else System.out.println( (xR - xI) + " " + (xR + xI) );
            }
        }    
}    
// 1 1 2,5
// 2 6 17
// -2 0 -2
