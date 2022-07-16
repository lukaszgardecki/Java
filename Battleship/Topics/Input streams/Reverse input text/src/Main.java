import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        char[] charsArr = new char[50];
       int count = reader.read(charsArr) - 1;

       for (int i = count; i >= 0; i--) {
           System.out.print(charsArr[i]);
       }



    }
}