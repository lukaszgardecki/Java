package com.example.programowanie2.zadania_kolokwium;

import java.io.*;

public class PlikDanych5 {


    static public int filmy( String plik ) throws IOException {
        RandomAccessFile inOut = null;
        double maxKoszt = 0;
        int    rokProd, rokWyn = 0;
        String nazw;
        double koszt;
        long   poz;
        char   pierwszaLit;

        try{
            inOut = new RandomAccessFile( plik, "rw" );
            while( true){
                inOut.readUTF();                   //  imię
                poz  = inOut.getFilePointer();
                nazw = inOut.readUTF();            //  nazwisko
                pierwszaLit = nazw.charAt( 0 );
                if( pierwszaLit >= 'a' && pierwszaLit <= 'z' ) pierwszaLit = (char)( pierwszaLit - 32 );
                inOut.seek( poz );
                inOut.writeUTF( pierwszaLit + nazw.substring(1).toLowerCase());
                inOut.readUTF();   //  imię
                rokProd = inOut.readInt();   // rok produkcji
                poz     = inOut.getFilePointer();
                koszt   = inOut.readDouble();
                inOut.seek( poz );
                inOut.writeDouble( koszt*1.25 );
                if( koszt > maxKoszt ){
                    maxKoszt = koszt;
                    rokWyn   = rokProd;
                }
            }
        }
        catch( IOException e ){ return rokWyn; }
        finally{ if(inOut != null) inOut.close();
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = null;
        String l;
        String plikWe  = "Dane.txt";
        String plikRA  = "Filmy.bin";

        int dł,
                maxDł1 = 0,
                maxDł2 = 0;


        RandomAccessFile inOut = null;

        try{
            in = new BufferedReader(
                    new FileReader( plikWe ));

            inOut = new RandomAccessFile( plikRA, "rw" );

            File plikP = new File("Plik.bin");
            if(plikP.exists())plikP.delete();

            while((l = in.readLine())!=null){
                String[] dane = l.split("\\s+");
                inOut.writeUTF( dane[ 0 ] );            // imię
                inOut.writeUTF( dane[ 1 ] );            // nazwisko
                dł = dane[ 0 ].length() + dane[ 1 ].length() + 1;
                if( dł > maxDł1) maxDł1 = dł;

                l = dane[ 2 ];
                int dłD = dane.length-1;
                for( int nr = 3; nr < dłD - 1; nr++)           // tytuł
                    l = l + " " + dane[ nr ];
                inOut.writeUTF( l );
                dł = l.length();
                if( dł > maxDł2) maxDł2 = dł;

                inOut.writeInt( Integer.parseInt(dane[ dłD-1 ]));        // rok
                inOut.writeDouble( Double.parseDouble( dane[ dłD ]));    // koszt
            }
        }
        finally{
            if(in    != null) in.close();
            if(inOut != null) inOut.close();
        }


        int rokProd = filmy( plikRA );


        String imię,
                nazw,
                tytuł;

        try{
            String odst = "                              ";
            inOut = new RandomAccessFile( plikRA, "r" );

            while(true){
                imię = inOut.readUTF();
                System.out.format("%s ",     imię );             //  imię
                nazw = inOut.readUTF();
                System.out.format("%s: ",    nazw );             //  nazwisko
                System.out.format("%s",      odst.substring( 0, maxDł1-(imię+nazw).length() ) );     //  odstęp

                tytuł = inOut.readUTF();
                System.out.format("%s, ",    tytuł );             //  tytuł
                System.out.format("%s",     odst.substring( 0, maxDł2-tytuł.length() ) );           //  odstęp

                System.out.format("%5d, ",   inOut.readInt());    //  rok
                System.out.format("%12.2f\n", inOut.readDouble()); //  koszt
            }
        }
        catch (EOFException e){ // koniec pliku
            if( inOut  != null) inOut.close();

            System.out.println("\nRok produkcji najdroższego filmu: " + rokProd );

        }
    }
}