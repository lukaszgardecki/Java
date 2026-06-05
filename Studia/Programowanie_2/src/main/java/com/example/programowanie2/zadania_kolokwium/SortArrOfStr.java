package com.example.programowanie2.zadania_kolokwium;

import java.util.Scanner;

public class SortArrOfStr {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );
       
        int size, nr1, nr2;
        String str, aux;
       
        System.out.print("Podaj lancuchy: ");
        str = input.nextLine();
        
        String[] arr = str.trim().split(" +");
        size = arr.length;     
 
        System.out.println("\nS�owa w oryginalnej kolejno�ci: ");
        for( nr1 = 0; nr1 < size; nr1++ )
           System.out.println( arr[ nr1 ]);
        
        
        
        for( nr1 = 0; nr1 < size - 1; nr1++ )
            for( nr2 = nr1 + 1; nr2 < size; nr2++ )
                if( arr[ nr2 ].compareTo( arr[ nr1 ]) < 0 ){
                   aux = arr[ nr1 ];
                   arr[ nr1 ] = arr[ nr2 ];
                   arr[ nr2 ] = aux;
                }
        
//         Arrays.sort(arr);
            
        System.out.println("\nS�owa w kolejno�ci leksykograficznej: ");
        for( nr1 = 0; nr1 < size; nr1++ )
           System.out.println( arr[ nr1 ]);
       
         
        for( nr1 = 0; nr1 < size - 1; nr1++ )
            for( nr2 = nr1 + 1; nr2 < size; nr2++ )
                if( arr[ nr2 ].length() < arr[ nr1 ].length() ){
                   aux = arr[ nr1 ];
                   arr[ nr1 ] = arr[ nr2 ];
                   arr[ nr2 ] = aux;
                }
        
        System.out.println("\nS�owa posortowane wed�ug d�ugo�ci");
        for( String s: arr )
           System.out.println( s );
    }
}
