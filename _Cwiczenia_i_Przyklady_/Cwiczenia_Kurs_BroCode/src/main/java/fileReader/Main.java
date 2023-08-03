package fileReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "src/fileReader/art.txt";
        File file = new File(path);

        try (FileReader reader = new FileReader(file)) {
            int data = reader.read();

            while (data != -1) {
                System.out.print((char)data);
                data = reader.read();
            }
        } catch (IOException e) {
            System.out.println("Nie znaleziono plilku");
        }
    }
}
