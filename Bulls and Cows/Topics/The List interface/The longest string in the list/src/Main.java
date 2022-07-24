import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        // write your code here
        int max = 0;
        int ind = 0;
        for (String word : list) {
            if (word.length() > max) {
                max = word.length();
                ind = list.indexOf(word);
            }
        }

        String j = list.get(ind);

        for (String word : list) {
            list.set(list.indexOf(word), j);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}