import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        SortedMap<Character, Integer> word1 = new TreeMap<>();
        SortedMap<Character, Integer> word2 = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        String w1 = scanner.nextLine().toLowerCase();
        String w2 = scanner.nextLine().toLowerCase();

        for (int i = 0; i < w1.length(); i++) {
            int counter = 0;
            for (int j = 0; j < w1.length(); j++) {
                if (Objects.equals(w1.charAt(i), w1.charAt(j))) counter++;
            }
            word1.put(w1.charAt(i), counter);
        }
        for (int i = 0; i < w2.length(); i++) {
            int counter = 0;
            for (int j = 0; j < w2.length(); j++) {
                if (Objects.equals(w2.charAt(i), w2.charAt(j))) counter++;
            }
            word2.put(w2.charAt(i), counter);
        }
        if (Objects.equals(word1, word2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}