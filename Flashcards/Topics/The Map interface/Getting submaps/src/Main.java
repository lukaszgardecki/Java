import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedMap<Integer, String> map = new TreeMap<>();

        String[] rangeTab = scanner.nextLine().split("\\s+");
        int amountOfPairs = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amountOfPairs; i++) {
            String[] tab = scanner.nextLine().split("\\s+");
            map.put(Integer.parseInt(tab[0]), tab[1]);
        }
        map.subMap(Integer.parseInt(rangeTab[0]), Integer.parseInt(rangeTab[1])+1)
                .forEach((i, s) -> System.out.println(i + " " + s));
    }
}