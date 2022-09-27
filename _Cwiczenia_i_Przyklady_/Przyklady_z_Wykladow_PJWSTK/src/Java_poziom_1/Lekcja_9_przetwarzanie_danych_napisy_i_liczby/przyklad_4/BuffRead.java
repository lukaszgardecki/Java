package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BuffRead {
    public static void main(String[] args) {
        File file = new File("src/Java_poziom_1/Lekcja_9_przetwarzanie_danych_napisy_i_liczby/przyklad_4/in1.txt");

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line).append('\n');
            }
            in.close();
            System.out.println(sb);
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }
}
