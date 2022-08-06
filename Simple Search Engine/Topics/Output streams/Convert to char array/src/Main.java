import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) {

        char[] arr = {};
        try (CharArrayWriter charArrayWriter = new CharArrayWriter()) {
            for (int i = 0; i < words.length; i++) {
                charArrayWriter.write(words[i].toCharArray());
            }
            arr = charArrayWriter.toCharArray();
        } catch (IOException ignored) {
        }
        return arr;
    }
}