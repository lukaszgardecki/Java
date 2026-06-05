package com.example.programowanie2.zadania_kolokwium;

import static java.lang.Math.random;
import java.util.Arrays;
import java.util.Scanner;

class Znak2 implements Comparable<Znak2> {
    
    char znak;
    int  licznik;
    
    Znak2(char zn, int licz){
        znak    = zn;
        licznik = licz;
    }


    @Override
    public int compareTo(Znak2 o) {
        int licz = o.licznik;
        return licznik > licz ? -1 : licznik == licz ? 0 : 1;
    }

    void piszZnak(){
        System.out.println( "'" + znak + "':" + licznik );  
    }
}

public class CharsWithSortObj2 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner( System.in );
        
         char[] tabZnaków = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' ,'I', 'J', 'K', 'L', 'M', 
                            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
       Znak2[] liczniki = new Znak2[256];
        
        for( char zn = 0; zn < liczniki.length; zn++ )
            liczniki[ zn ] = new Znak2(zn, 0);
        
        System.out.print("Podaj wielkosc tablicy (liczbe znakow): "); 
        int size = input.nextInt();
        
        char[] znaki = new char[ size ];
        
        for( int nr = 0; nr < znaki.length; nr ++) 
           znaki[ nr ] = tabZnaków[(int)(random()*62)]; 
        
        for( int nr = 0; nr < znaki.length; nr++ )
           liczniki[ znaki[ nr ] ].licznik++;           
               
        Arrays.sort(liczniki);
                
        
        for( Znak2 zn: liczniki )
            if( zn.licznik > 0 ) zn.piszZnak();
        
    }
}
