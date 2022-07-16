import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] text = inputStream.readAllBytes();
        for (byte b : text) {
            System.out.print(b);
        }

        Reader reader = new Reader() {
            @Override
            public int read(char[] chars, int i, int i1) throws IOException {
                return 0;
            }

            @Override
            public void close() throws IOException {

            }
        };


    }
}