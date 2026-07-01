package com.example.programowanie2.zadania_kolokwium;

import java.io.*;

public class PlikDanych2 {

    public static void main(String[] args) throws Exception {

        BufferedReader inTxt = null;
        String l;
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

            while((l = inTxt.readLine())!=null){
                outBin.writeUTF( l );
                outBin.writeInt( Integer.parseInt(inTxt.readLine()));
                outBin.writeDouble( Double.parseDouble(inTxt.readLine()));
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
                koszt  = lSztuk * cena;
                outTxt.println("Zamówiłeś " + lSztuk + " sztuk produktu " + towar + " po " + cena
                        + " co daje " + koszt );
                suma += koszt;
            }
        }
        catch (EOFException e){ // koniec pliku
            if( inBin  != null) inBin.close();
            if( outTxt != null) outTxt.close();
            System.out.println("Zapłaciłeś " + suma);
        }
    }
}
