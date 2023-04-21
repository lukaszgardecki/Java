package rozdzial_1;

public class zad3 {

     /*
     * Napisz metodę, która przyjmuje dwa łańcuchy znaków i określa, czy jeden jest permutacją drugiego.
     */

    public static void main(String[] args) {
        String s1 = "asdf";
        String s2 = "fsadf";

        System.out.println(isPermutation(s1, s2));
    }

    private static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            String ch1 = String.valueOf(s1.charAt(i));
            s2 = s2.replace(ch1, "");
        }
        return s2.equals("");
    }
}
