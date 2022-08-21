import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static String path = "src/baza.txt";
    static File file = new File(path);
    static Map<Integer, ArrayList<String[]>> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        Groups.createMap();
        new Window();
        loadData();

    }

    public static void loadData() {
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tab = line.split("_");
                int numOfGroup = Integer.parseInt(tab[2]);

                map.get(numOfGroup).add(tab);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void saveData() {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("T£UMACZENIE POLSKIE_T£UMACZENIE ANGIELSKIE_NR GRUPY_ILOŒÆ B£ÊDNYCH ODPOWIEDZI_ILOŒÆ POPRAWNYCH ODPOWIEDZI");

            for (String[] tab : map.get(0)) {
                String line = Arrays.toString(tab)
                        .replace("[", "")
                        .replace("]", "")
                        .replace(", ", "_");
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
