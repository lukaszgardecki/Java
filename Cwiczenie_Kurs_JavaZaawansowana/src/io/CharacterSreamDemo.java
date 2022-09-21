package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class CharacterSreamDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\io\\in.txt");
            writer = new FileWriter("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\io\\out.txt");

            //odczytuje z pliku i zapisuje do pliku znak po znaku
            int content;
            while ((content = reader.read()) != -1) {
                writer.append((char) content);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
