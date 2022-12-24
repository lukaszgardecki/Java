import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    /**
     * Napisz program, który z pliku w formacie csv postaci:
     *
     * nazwa1;ilość1
     * nazwa2;ilość2
     * itd.
     *
     * wczyta informację o stanie magazynowym hurtowni (nazwy produktów oraz aktualną ilość produktów na stanie).
     * Zakładamy, że maksymalna ilość produktów to 100.
     *
     * Program powinien wyświetlić w konsoli wykres procentowy w postaci gwiazdek w formie zbliżonej do tej przedstawionej poniższej.
     *
     * Każda gwiazdka odpowiada za 10% zaopatrzenia, czyli 100 produktów = 100%, a np. 28 = 30% (zaokrąglamy do
     * najbliższej pełnej dziesiątki). Lista produktów powinna być posortowana alfabetycznie (pomijamy polskie znaki).
     *
     * Nazwa pliku powinna być wczytana od użytkownika z konsoli.
     */

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<String> db = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Podaj nazwę pliku z danymi:");
        String file = scanner.nextLine();
        readData(file);
    }

    private static void readData(String file) {
        File f = new File(file);
        try (Scanner s = new Scanner(f)) {
            addDataToDB(s);
            printData();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printData() {
        for (String item : db) {
            String[] split = item.split(";");
            String name = split[0];
            String percentage = split[1];
            String diagram = "*".repeat(Math.round(Float.parseFloat(percentage)/10));
            System.out.printf("%-30s (%s) %s%n", name, percentage, diagram);
        }
    }

    private static void addDataToDB(Scanner s) {
        while (s.hasNextLine()) {
            String line = s.nextLine();
            db.add(line);
        }
        Collections.sort(db);
    }
}
