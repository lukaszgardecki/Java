import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyFileReader {
    public static final String CSV_DELIMITER = ";";
    public static final String FILE_STORAGE_PATH = "files";
    private final Printer printer = new Printer();


    public List<User> createUserListFromFile(File file) {
        List<User> users = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(CSV_DELIMITER);
                User user = createUser(split);
                users.add(user);
            }
        } catch (IOException e) {
            printer.println("Nie znaleziono pliku");
        }
        return  users;
    }

    public File getStartFile(File file) {
        File[] filesInside = file.listFiles();
        return Arrays.stream(filesInside)
                .filter(f -> f.getName().contains("start"))
                .findFirst()
                .get();
    }

    public List<File> getExchangeDirectoriesList() {
        File file1 = new File(FILE_STORAGE_PATH);
        File[] files = file1.listFiles();

        return Arrays.stream(files)
                .filter(f -> Objects.requireNonNull(f.listFiles()).length != 0)
                .toList();
    }

    public int getCamps(File file) {
        String name = file.getName();
        String numStr = name.substring(name.indexOf("#") + 1).split("\\.")[0];
        return Integer.parseInt(numStr);
    }

    public List<File> getSectorFileList(File file) {
        return Arrays.stream(Objects.requireNonNull(file.listFiles()))
                .filter(f -> !f.getName().contains("start"))
                .sorted(sortByAdditionNum())
                .toList();
    }

    private Comparator<File> sortByAdditionNum() {
        return (a, b) -> {
            int additionNumIndexStart = a.getName().indexOf("(") + 1;
            int additionNumIndexEnd = a.getName().indexOf(")");
            int additionNumA = Integer.parseInt(a.getName().substring(additionNumIndexStart, additionNumIndexEnd));
            int additionNumB = Integer.parseInt(b.getName().substring(b.getName().indexOf("(") + 1, b.getName().indexOf(")")));
            return Integer.compare(additionNumA, additionNumB);
        };
    }

    private User createUser(String[] split) {
        User user = new User();
        user.setId(Long.parseLong(split[0]));
        user.setName(split[1]);
        user.setNegotiations(Integer.parseInt(split[2]));
        user.setBattles(Integer.parseInt(split[3]));
        user.setTotalScore(Integer.parseInt(split[4]));
        return user;
    }
}
