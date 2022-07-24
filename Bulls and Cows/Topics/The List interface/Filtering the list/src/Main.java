import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        final String[] tab = scanner.nextLine().split("\\s+");

        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(tab)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int y = (list.size() + 1) / 2;

            for (int i = 0; i < y; i++) {
                list.remove(i);
            }
        Collections.reverse(list);
        list.forEach(e -> System.out.print(e + " "));

    }
}