package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_3;

import java.io.FileInputStream;

public class ReadBytesAsChars {
    public static void main(String[] args) {
        StringBuffer cont = new StringBuffer();

        try {
            FileInputStream in = new FileInputStream(args[0]);
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
