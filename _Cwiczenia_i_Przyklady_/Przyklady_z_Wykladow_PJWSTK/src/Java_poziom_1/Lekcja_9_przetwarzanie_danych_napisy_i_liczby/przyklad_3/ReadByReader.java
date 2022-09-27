package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_3;

import java.io.FileReader;

public class ReadByReader {
    public static void main(String[] args) {
        StringBuffer cont = new StringBuffer();

        try {
            FileReader in = new FileReader(args[0]);
            int c;
            while ((c = in.read()) != -1) cont.append((char) c);
            in.close();
        } catch(Exception exc) {
            System.out.println(exc.toString());
            System.exit(1);
        }
        String s = cont.toString();
        System.out.println(s);
    }
}
