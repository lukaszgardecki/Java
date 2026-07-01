
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;


public class Menu1 {

    static void poz1(){
        System.out.println("\nPozycja 1\n");
    }
    
    static void poz2(){
        System.out.println("\nPozycja 2\n");
    }
    
    static void poz3(){
        System.out.println("\nPozycja 3\n");
    }
    
    static void poz4(){
        System.out.println("\nPozycja 4\n");
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner( System.in );
        int nr;
        
        do{
            System.out.println(" MENU");
            System.out.println("------");
            System.out.println("1. Pozycja 1");
            System.out.println("2. Pozycja 2");
            System.out.println("3. Pozycja 3");
            System.out.println("4. Pozycja 4");
            System.out.println("0. Koniec");
            do{
                System.out.print("Wybierz 0-4: ");
                nr = in.nextInt();
            }
            while( nr < 0 || nr > 4 );
            switch( nr ){
                case 1 -> poz1();
                case 2 -> poz2();
                case 3 -> poz3();
                case 4 -> poz4();
                default -> System.out.print("\nKONIEC\n");
            } 
        }
        while( nr != 0 );
    }

}
    
