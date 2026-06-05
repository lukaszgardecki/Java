
package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;


public class Miesiące {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int month, year;
        int noOfDays;
        
        System.out.print( "Podaj miesiąc: " );
        month = input.nextInt();

//          month = Integer.parseInt(JOptionPane.showInputDialog("Podaj miesiąc: "));

        System.out.print( "Podaj rok (>1600): " );
        year  = input.nextInt();
//          year = Integer.parseInt(JOptionPane.showInputDialog("Podaj rok: "));
 
/*
        if( year < 1600 || year > 2200 ) noOfDays = -1;
        else
            if(month == 2 ) noOfDays = year % 400 == 0 || 
                                       year % 4 == 0 && year % 100 != 0 ? 
                                       29 : 28;
            else 
                if(month == 4 || month == 6 || month == 9 || month == 11) noOfDays = 30;
                else noOfDays = 31;
*/                    
            
/*            
            noOfDays = switch( month ) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 4, 6, 9, 11           -> 30;
                case 2 -> ( year % 400 == 0 || 
                            year % 4 == 0 && year % 100 != 0) ? 29 : 28;
                default -> -1;
            };
/*  */     
             switch( month ) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: noOfDays = 31; break;
                case 4:
                case 6:
                case 9:
                case 11: noOfDays = 30; break;
                case 2: if ( year % 400 == 0 
                          || year % 4 == 0 && year % 100 != 0) noOfDays = 29;
                        else noOfDays = 28; break;
                default: noOfDays = -1;
            }
    /*  
  
*/

        System.out.println( "Liczba dni: " + noOfDays );
//        JOptionPane.showMessageDialog(null, "Liczba dni: " + noOfDays);
    }   
}
