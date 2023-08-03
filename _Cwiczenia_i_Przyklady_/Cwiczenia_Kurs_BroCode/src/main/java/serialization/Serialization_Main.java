package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization_Main {
    public static void main(String[] args) throws IOException {

        User user = new User();

        user.name = "Bob";
        user.password = "haslo";

        FileOutputStream fileOut = new FileOutputStream("src/serialization/out.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();

        System.out.println("Zapisano");
    }
}
