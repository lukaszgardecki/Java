import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> knownWordsSet = new LinkedHashSet<>();
        Set<String> textSet = new LinkedHashSet<>();
        int d = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < d; i++ ) {
            knownWordsSet.add(scanner.nextLine().toLowerCase());
        }
        int l = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < l; i++) {
            String str = scanner.nextLine().toLowerCase();
            textSet.addAll(Arrays.asList(str.split("\\s+")));
        }
        textSet.removeAll(knownWordsSet);
        textSet.forEach(System.out::println);
    }
}