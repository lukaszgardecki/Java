package com.example.programowanie2.zadania_kolokwium;

import java.io.*;

public class PlikDanych3 {

    public static void main(String[] args) throws Exception {

        BufferedReader inTxt = null;
        String linia;
        String plikWe    = "PlikWe.txt";
        String plikBin   = "PlikWy.bin";
        String plikWyTxt = "PlikWy.txt";

        DataOutputStream outBin = null;
        String towar;
        double cena;
        int    lSztuk;
        double suma, koszt;

        try{
            inTxt = new BufferedReader(
                    new FileReader( plikWe ));

            outBin = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream( plikBin )));

            while((linia = inTxt.readLine())!=null){
                String[] dane = linia.trim().split(" +");
                outBin.writeUTF( dane[ 0 ] );
                outBin.writeInt( Integer.parseInt( dane[ 1 ]));
                outBin.writeDouble( Double.parseDouble(dane[ 2 ]));
            }
        }
        finally{
            if(inTxt  != null) inTxt.close();
            if(outBin != null) outBin.close();
        }
        PrintWriter     outTxt = null;
        DataInputStream inBin  = null;

        suma = 0;
        try{
            inBin = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream( plikBin )));

            outTxt = new PrintWriter(
                    new FileWriter( plikWyTxt ));

            while (true){
                towar  = inBin.readUTF();
                lSztuk = inBin.readInt();
                cena   = inBin.readDouble(); // uwaga na kolejność danych
                koszt = lSztuk * cena;
                outTxt.println("Zamówiłeś " + lSztuk + " sztuk produktu " + towar + " po " + cena
                        + " co daje " + String.format("%.2f",koszt ));
                suma += koszt;
            }
        }
        catch (EOFException e){ // koniec pliku
            if( inBin  != null) inBin.close();
            if( outTxt != null) outTxt.close();
            System.out.println("Zapłaciłeś " + ((int)(suma*100)/100.0));
        }
    }
}
