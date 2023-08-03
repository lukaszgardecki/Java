package fileClass;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        String path = "src/fileClass/in.txt";
        File file = new File(path);

        if (file.exists()) {
            System.out.println("Plik istnieje i ma siê dobrze.");
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.isFile());
        } else {
            System.out.println("Ten plik nie istnieje.");
        }

    }
}
