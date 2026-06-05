
package com.example.programowanie2.zadania_kolokwium;

import java.util.*;

public class Sinus {

    public static void main(String[] args) {
        int i, dokł;
        double x; // Math.PI/8;
        double EPS; // = 0.00000001;
        double sin1, cos1, skł;
        
        // Stworzenie obiektu klasy Scanner z parametrem System.in
        // Ten obiekt posłuży do wczytywania liczb (danych)
        Scanner in = new Scanner(System.in);
    
        System.out.print("Podaj kąt w stopniach: ");
        x = in.nextDouble() / 180 * Math.PI; 
                              
        System.out.print("Podaj dokładność (liczbę cyfr dokładnych) 1-16: ");
        dokł = in.nextInt(); 
        
        EPS = Math.pow(10, -dokł); 
                              
        i = 0;
        sin1 = skł = x;
        while(Math.abs(skł) >= EPS){
          i++;
          skł = skł * (-(x * x )/ (2*i*(2*i+1)));
          sin1 = sin1 + skł; 
        }
        System.out.format("i =%2d,  eps  = %20.16f\n", i, EPS);
        System.out.format("        sin1 = %20.16f\n", sin1);
        System.out.format("        sin  = %20.16f\n\n",  Math.sin(x));
        
       System.out.println("i = " + i + " eps  = " + EPS);
       System.out.println("        sin1 = " + sin1);
       System.out.println("        sin  = " + Math.sin(x) + "\n\n");
       
        
        i = 0;
        cos1 = skł = 1;
        while(Math.abs(skł) > EPS){
          i++;
          skł = -skł * x * x / (2*i*(2*i-1));
          cos1 = cos1 + skł; 
        }
        System.out.format("i =%2d,  eps  = %20.16f\n", i, EPS);
        System.out.format("        cos1 = %20.16f\n", cos1);
        System.out.format("        cos  = %20.16f\n",  Math.cos(x));

    }
}
