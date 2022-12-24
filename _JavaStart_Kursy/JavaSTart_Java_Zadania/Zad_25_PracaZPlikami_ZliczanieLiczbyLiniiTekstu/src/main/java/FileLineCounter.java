import java.io.*;

/**
 * Stwórz program który zliczy liczbę linii tekstu dla wszystkich plików w wskazanym folderze.
 *
 * Wynikiem powinna być lista plików wraz z informacją o liczbie linii oraz suma wszystkich linii w folderze.
 * Program powinien przeszukiwać folder rekursywnie.
 */

public class FileLineCounter {
    private int totalCounter;
    private String baseDir;

    public static void main(String[] args) throws IOException {
        new FileLineCounter().run();
    }

    private void run() throws IOException {
        String path = "C:\\Users\\lukas_000\\Desktop\\Java_Projekty\\Java\\_JavaStart_Kursy\\JavaSTart_Java_Zadania\\Zad_25_PracaZPlikami_ZliczanieLiczbyLiniiTekstu\\files";
        File dir = new File(path);
        if(dir.exists()) {
            baseDir = path;
            processDirectory(dir);
            System.out.println("W sumie " + totalCounter + " linii.");
        } else {
            System.out.println("Wskazany folder nie istnieje");
        }
    }

    private void processDirectory(File dir) throws IOException {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                processDirectory(file);
            } else {
                int lines = countLinesForFile(file);
                totalCounter += lines;
                String relativeName = file.getAbsolutePath().replace(baseDir, "");
                System.out.println(relativeName + " --> " + lines);
            }
        }
    }

    private int countLinesForFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int counter = 0;
        while (reader.readLine() != null) {
            counter++;
        }
        return counter;
    }
}
