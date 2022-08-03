import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        SortedMap<Integer, String> out = new TreeMap<>(Collections.reverseOrder());
        int first = map.firstKey();
        int last = map.lastKey();

        if (first % 2 != 0) {
            out.putAll(map.subMap(first, first+5));
            return out;
        } else {
            out.putAll(map.subMap(last-4, last+1));
            return out;
        }
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}