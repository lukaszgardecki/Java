import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        text = text.trim();

        if (text.isBlank()) {
            System.out.println(0);
        } else {
           int length = text.split("\\s+").length;
            System.out.println(length);
        }
        reader.close();







    }
}