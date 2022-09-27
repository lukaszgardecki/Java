package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_2;

import java.io.*;
import static javax.swing.JOptionPane.*;

public class CopyFile {

    public static void main(String[] args) {

        FileInputStream in = null;   // plik wejœciowy
        FileOutputStream out = null; // plik wyjœciowy

        try {
            in = new FileInputStream("in1");
            out = new FileOutputStream("out1");
            int c;
            while ((c = in.read()) != -1)  out.write(c);    // kopiowanie
        } catch (ArrayIndexOutOfBoundsException exc) {    // brak argumentu
            System.out.println("Syntax: CopyFile in out");
            System.exit(1);
        } catch (FileNotFoundException exc) {             // nieznany plik
            System.out.println("Plik wejœciowy nie istnieje.");
            System.exit(2);
        } catch (IOException exc) {                       // inny b³¹d wejœcia- wyjœcia
            System.out.println(exc.toString());
            System.exit(3);
        } finally {                     // zawsze zamykamy pliki
            try {                       // niestety close mo¿e zg³osiæ wyjatek kontrolowany - trzeba u¿yæ try
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException exc) {
                System.out.println(exc.toString());
            }
        }
    }
}
