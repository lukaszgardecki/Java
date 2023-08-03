package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class ByteStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream inStream = null;
        FileOutputStream outStream = null;

        try {
            inStream = new FileInputStream("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\io\\in.txt");
            outStream = new FileOutputStream("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\io\\out.txt");


            //czyta kolejno bajty, jeœli dojdzie do koñca pliku zwraca -1

            int content;
            while ((content = inStream.read()) != -1) {
                outStream.write((byte) content );
            }
        } finally {
            if (inStream != null) {
                inStream.close();
            }
            if (outStream != null) {
                outStream.close();
            }
        }
    }
}
