import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();

        for (String value : strings) {
            int counter = 0;
            String s = value;
            for (String string : strings) {
                if (s.equals(string)) {
                    counter++;
                }
            }
            map.putIfAbsent(value, counter);
        }
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        map.forEach((letter, num) -> System.out.println(letter + " : " + num));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}