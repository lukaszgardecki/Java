package fileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String out = "src/fileWriter/out.txt";


        try {
            FileWriter writer = new FileWriter(out);

            writer.write(
                    "To jest ttttotoootootott"
                    + "\n i to"
                    + "\n tutaj te¿ coœ jest ale nie wiem co"
                    + "\n a tu tym bardziej"
            );
            writer.append("\n\n\n_madeByL");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }
}
