package imagehandling;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class ImageHandlingDemo {
    public static void main(String[] args) throws IOException {
        int width = 963;
        int height = 640;

        BufferedImage image = null;

        image = readFromFile(width, height, image);

        writeToFile(image);
    }

    private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
        try {
            File sampleFile = new File("C:\\Users\\lukas_000\\Desktop\\leki.jpg");

            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            //reading input file
            image = ImageIO.read(sampleFile);

            System.out.println("Reading complete." + image);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return image;
    }

    private static void writeToFile(BufferedImage image) {
        try {
            //okreœlamy gdzie chcemy zapisaæ nowy obrazek
            File output = new File("C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\Cwiczenie_Kurs_JavaZaawansowana\\src\\imagehandling\\out.jpg");

            // obrazek "image" zapisz z rozszerzeniem "jpg" w lokalizacji "output"
            ImageIO.write(image, "jpg", output);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
