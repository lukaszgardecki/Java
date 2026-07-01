package com.example.programowanie2.zadania_kolokwium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PlikTekst3 {

    public static void main(String[] args) throws Exception {

        String l;
        String plikWe    = "PlikWe.txt";
        String plikWyTxt = "PlikWy.txt";

        String towar;
        double cena;
        int    lSztuk;
        double suma = 0, koszt;

        try(
                BufferedReader inTxt = new BufferedReader(
                        new FileReader( plikWe ));
                PrintWriter outTxt = new PrintWriter(
                        new FileWriter( plikWyTxt ));)
        {
            while((l = inTxt.readLine())!=null){
                String[] towary = l.trim().split(" +");
                towar  = towary[ 0 ];
                lSztuk = Integer.parseInt(towary[ 1 ]);
                cena   = Double.parseDouble(towary[ 2 ]);
                koszt = lSztuk * cena;
                outTxt.println("Zam�wi�e� " + lSztuk + " sztuk produktu " + towar + " po " + cena
                        + " co daje " + koszt );
                suma += koszt;
            }
            outTxt.println("Zap�aci�e� " + suma);
            System.out.println("Zap�aci�e� " + suma);
        }
    }
}
