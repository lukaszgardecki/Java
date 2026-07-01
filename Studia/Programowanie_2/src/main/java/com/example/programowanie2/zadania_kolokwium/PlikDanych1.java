package com.example.programowanie2.zadania_kolokwium;

import javax.swing.*;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PlikDanych1 {


    public static void main(String[] args) throws IOException {

        String  ł;

        String nazwPlik = "Plik.bin";

        Scanner wej = new Scanner( System.in );

        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream( nazwPlik )));

        out.writeByte( Byte.parseByte(JOptionPane.showInputDialog("Podaj wartość byte:")));
        out.writeShort( Short.parseShort(JOptionPane.showInputDialog("Podaj wartość short:")));
        out.writeInt( Integer.parseInt(JOptionPane.showInputDialog("Podaj wartość int:")));
        out.writeLong( Long.parseLong(JOptionPane.showInputDialog("Podaj wartość long:")));
        out.writeFloat( Float.parseFloat(JOptionPane.showInputDialog("Podaj wartość float:")));
        out.writeDouble( Double.parseDouble(JOptionPane.showInputDialog("Podaj wartość double:")));
        out.writeBoolean( Boolean.parseBoolean(JOptionPane.showInputDialog("Podaj wartość boolean:")));
        out.writeChars( ł = JOptionPane.showInputDialog("Podaj łańcuch:"));
        out.writeUTF(ł );

        out.close();

    }

}
