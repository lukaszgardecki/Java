package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;


public class WhatTriangle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double a, b, c;
        boolean equi = false, isosc = false, right = false;
        int error = 0;
        
        System.out.print( "Podaj długości 3 boków trójkąta: ");
        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();
        
       

/*
        a = Double.parseDouble( JOptionPane.showInputDialog("Podaj pierwszy bok trójkąta: "));
        b = Double.parseDouble( JOptionPane.showInputDialog("Podaj drugi bok trójkąta: "));
        c = Double.parseDouble( JOptionPane.showInputDialog("Podaj trzeci bok trójkąta: "));
*/
        if( a+b>c && a+c>b && b+c>a) {
            if(a==b && a==c && a==b) equi = true;
            if(a==b || a==c || b==c) isosc = !equi; // isosc = true;
            if(a*a+b*b == c*c || a*a+c*c == b*b || c*c+b*b == a*a) right = true; 
        } 
        else error = -1;
    
//        if( equi && isosc ) isosc = false;
/*
        String wynik = "";
        
        if( error == -1 ) wynik = "Boki nie definiują trójkąta";
        else{
            if( equi  ) wynik = wynik + "równoboczny ";
            if( isosc ) wynik = wynik + "równoramienny ";
            if( right ) wynik = wynik + "prostokątny ";
            if( !(equi || isosc || right) ) wynik = "żaden";
            System.out.println();
        }  
        JOptionPane.showMessageDialog(null, wynik );
*/

        if( error == -1 ) System.out.print("Boki nie definiują trójkąta");
        else{
            if( equi  ) System.out.print("równoboczny ");
            if( isosc ) System.out.print("równoramienny ");
            if( right ) System.out.print("prostokątny ");
            if( !(equi || isosc || right) ) System.out.print("żaden");
        }  
        System.out.println();

    }   
}
