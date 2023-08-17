package wzorce.dekorator2;

import java.io.*;

public class InputTest {
    public static void main(String[] args) {
        int c;
        File file = new File("");
        try {
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(file)));

            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
