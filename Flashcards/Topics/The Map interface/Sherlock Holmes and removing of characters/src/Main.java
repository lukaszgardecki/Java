import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String[] w1 = scanner.nextLine().split("");
        String[] w2 = scanner.nextLine().split("");
        String[] w1c = w1.clone();
        String[] w2c = w2.clone();

        for (String value : w1) {
            for (int j = 0; j < w2.length; j++) {
                String s1 = value.toLowerCase();
                String s2 = w2c[j].toLowerCase();
                if (s1.equals(s2)) {
                    w2c[j] = " ";
                    break;
                }
            }
        }

        for (String value : w2) {
            for (int j = 0; j < w1.length; j++) {
                String s1 = value.toLowerCase();
                String s2 = w1c[j].toLowerCase();
                if (s1.equals(s2)) {
                    w1c[j] = " ";
                    break;
                }
            }
        }

        for (String s : w2c) {
            if (!s.equals(" ")) sum++;
        }
        for (String s : w1c) {
            if (!s.equals(" ")) sum++;
        }
        System.out.println(sum);
    }
}