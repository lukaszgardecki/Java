package stringhandling;

import java.util.Arrays;

public class StringHandlingDemo {
    public static void main(String[] args) {
        String str1 = "Ja sobie studiujê ";
        String str2 = "na jakiejœ uczelni";

        System.out.println("D³ugoœæ str1 to: " + str1.length());

        String result = str1.concat(str2);
        System.out.println("Konkatenacja stringów: " + result);

        String strngFormat = String.format("Imiê studenta to: %s" + ", jego wiek to: %d",
                "Jan Kowalski", 134);
        System.out.println(strngFormat);

        System.out.println(str1.charAt(5));

        if (str1.equals(str2)) {
            System.out.println("oba wyrazy s¹ takie same");
        } else {
            System.out.println("wyrazy s¹ ró¿ne");
        }

        System.out.println("indeks litery 'y': " + str1.indexOf('y'));
        System.out.println("zamiana litery 's' na 'r': " + str1.replace('s', 'r'));

        String[] arr = str1.split(" ");
        Arrays.asList(arr).forEach(System.err::println);

        String newStr1 = str1.substring(1, 5);
        System.out.println(newStr1);
    }


}
