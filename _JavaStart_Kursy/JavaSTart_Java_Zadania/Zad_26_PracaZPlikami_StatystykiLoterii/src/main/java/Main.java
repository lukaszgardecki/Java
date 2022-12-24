import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Napisz program, który wyświetli 10 "normalnych" liczb, które najczęściej powtarzały się w
 * losowaniach oraz 3 liczby "mega ball", które losowane były najczęściej.
 */

public class Main {
    private static final int AMOUNT_OF_MOSTPOPULAR_WINNUMS = 10;
    private static final int AMOUNT_OF_MOSTPOPULAR_MEGABALL = 3;
    private static Map<String, Integer> winNumsStats = new HashMap<>();
    private static Map<String, Integer> megaBallStats = new HashMap<>();


    public static void main(String[] args) {
        String path = "Lottery_Mega_Millions_Winning_Numbers__Beginning_2002.csv";
        readData(path);
        printMostPopularNumbers();
        printMostPopularMegaBall();
    }

    private static void printMostPopularMegaBall() {
        System.out.println(AMOUNT_OF_MOSTPOPULAR_MEGABALL + " najpopularnieje mega ball:");
        megaBallStats.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((n1, n2) -> -Integer.compare(n1, n2)))
                .limit(AMOUNT_OF_MOSTPOPULAR_MEGABALL)
                .forEach(System.out::println);
    }

    private static void printMostPopularNumbers() {
        System.out.println(AMOUNT_OF_MOSTPOPULAR_WINNUMS + " najpopularniejszych liczb:");
        winNumsStats.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((n1, n2) -> -Integer.compare(n1, n2)))
                .limit(AMOUNT_OF_MOSTPOPULAR_WINNUMS)
                .forEach(System.out::println);
    }

    private static void readData(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                String[] winNums = split[1].split(" ");
                updateWinNumStats(winNums);
                String megaBall = split[2];
                updateMegaBallStats(megaBall);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Nie znaleziono pliku.");
        }
    }

    private static void updateMegaBallStats(String num) {
        updateCollection(num, megaBallStats);
    }

    private static void updateWinNumStats(String[] nums) {
        for (String num : nums) {
            updateCollection(num, winNumsStats);
        }
    }

    private static void updateCollection(String num, Map<String, Integer> map) {
        if (map.containsKey(num)) {
            Integer oldVal = map.get(num);
            map.replace(num, oldVal, oldVal + 1);
        } else {
            map.put(num, 1);
        }
    }
}
