import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Printer {
    public static final String SECTOR_INFO_HEADER = """
                Sprawdzone sektory:
                    - razem: %s
                    - w tym 3 i mniej obozów: %s
                    - w tym 4 i więcej obozów: %s
                """;
    public static final String USER_LIST_STATS_HEADER = """
            
            Statystyki graczy w czasie wykonywania pomiarów:
            -----
             [W3 - walki max. 3 obozy, W4 - walki min. 4 obozy]
            ----- 
            """;



    public void printUserStats(List<User> users) {
        println(USER_LIST_STATS_HEADER);
        users.forEach(System.out::println);
    }

    public void printSectorStats(List<Sector> sectorList) {
        sectorList.forEach(System.out::println);
    }

    public void printHeaderInfo(List<Sector> sectorList) {
        System.out.printf(SECTOR_INFO_HEADER,
                sectorList.size(),
                sectorList.stream().filter(s -> s.getCamps() <= 3).count(),
                sectorList.stream().filter(s -> s.getCamps() >= 4).count()
        );
    }

    public void saveToTextFile(List<User> users, List<Sector> sectorList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write(String.format(SECTOR_INFO_HEADER,
                    sectorList.size(),
                    sectorList.stream().filter(s -> s.getCamps() <= 3).count(),
                    sectorList.stream().filter(s -> s.getCamps() >= 4).count() )
            );
            for (Sector sector : sectorList) {
                writer.write(sector.toString());
            }
            writer.write(USER_LIST_STATS_HEADER);
            for (User user : users) {
               writer.write(user.toString());
               writer.newLine();
            }

        } catch (IOException e) {
            println("Nie znaleziono pliku");
        }
    }

    public void println(String text) {
        System.out.println(text);
    }
}
