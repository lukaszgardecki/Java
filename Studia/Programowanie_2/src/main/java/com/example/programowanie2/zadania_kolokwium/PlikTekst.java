package com.example.programowanie2.zadania_kolokwium;

import java.io.*;
import java.util.Scanner;

public class PlikTekst {

    public static void main(String[] args) throws IOException {

        tworzPlik("Plik.txt");
        czytajPlik("Plik.txt");
    }

    public static void tworzPlik( String plik ) throws IOException{
        Scanner in;
        PrintWriter out = null;
        String l;

        System.out.println("Podaj zawarto�� pliku:");
        try{
            in  = new Scanner( System.in );
            out = new PrintWriter(
                    new FileWriter( plik ));

            while(!(l = in.nextLine()).equals("")){
                out.println(l);
                System.out.println('"'+l+'"');
            }
        }
        finally{
            if(out != null) out.close();
        }
    }

    public static void czytajPlik( String plik ) throws IOException{
        BufferedReader in = null;
        String l;

        System.out.println("Zawarto�� pliku:");
        try{
            in = new BufferedReader(
                    new FileReader( plik ));

            while((l = in.readLine())!=null)
                System.out.println('"'+l+'"');
        }
        finally{
            if(in != null) in.close();
        }
    }

}
