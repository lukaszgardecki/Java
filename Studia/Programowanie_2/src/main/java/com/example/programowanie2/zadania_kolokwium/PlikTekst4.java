package com.example.programowanie2.zadania_kolokwium;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlikTekst4 {

    public static void main(String[] args)  {

        String l;
        String plikWe    = "PlikWe.txt";
        String plikWyTxt = "PlikWy.txt";

        String towar;
        double cena;
        int    lSztuk;
        double suma = 0, koszt;

        try(
                Scanner inTxt = new Scanner( new FileReader( plikWe ));
                PrintWriter outTxt = new PrintWriter(
                        new FileWriter( plikWyTxt ));)
        {
            while(inTxt.hasNextLine()){
                towar  = inTxt.next();
                lSztuk = inTxt.nextInt();
                cena   = inTxt.nextDouble();
                koszt = lSztuk * cena;
                outTxt.println("Zam�wi�e� " + lSztuk + " sztuk produktu " + towar + " po " + cena
                        + " co daje " + koszt );
                suma += koszt;
                if(inTxt.hasNextLine()) inTxt.nextLine();
            }
            outTxt.println("Zap�aci�e� " + suma);
            System.out.println("Zap�aci�e� " + suma);
        }
        catch( Exception e ){System.out.println( e.toString());}
    }
}
