
package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Thread.sleep;

class Znak1 {
  
  public static void main (String args[])throws Exception {
      
        for(char znak=0; znak<31; znak++){
            System.out.print((int)znak + "-->" + znak + "  ");
            sleep(1000);
        }
        
        System.out.println(); 
  }
}