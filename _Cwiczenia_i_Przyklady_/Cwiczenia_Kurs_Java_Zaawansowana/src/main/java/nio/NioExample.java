package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class NioExample {
    public static void main(String[] args) throws IOException {

        //czytaj z pliku
//        FileInputStream fin = new FileInputStream("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\nio\\input.txt");
//        FileChannel readChannel = fin.getChannel();
//        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
//        int result = readChannel.read(readBuffer);
//        System.out.println("file read successfully: " + result);


        //zapisz do pliku
        FileOutputStream fout = new FileOutputStream("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\nio\\output.txt");
        FileChannel writeChannel = fout.getChannel();
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        String message = "to jest tekst, który zosta³ zapisany";
        writeBuffer.put(message.getBytes());
        writeBuffer.flip();
        writeChannel.write(writeBuffer);
        System.out.println("file written successfully");

    }
}
