package rozdzial_1;

public class zad1 {

     /*
     * Zaimplementuj algorytm określający, czy łańcuch zawiera tylko niepowtarzające się znaki.
     * Jak wykonasz to zadanie,  jeśli nie można stosować dodatkwoych struktur danych?
     */

    public static void main(String[] args) {
        String s1 = "abcdefghijkl";
        String s2 = "aba";

        System.out.println(checkIfCharsAreUnique(s1));
        System.out.println(checkIfCharsAreUnique(s2));
    }

    private static boolean checkIfCharsAreUnique(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (i == j) continue;
                char ch2 = s.charAt(j);
                if (ch1 == ch2) return false;
            }
        }
        return true;
    }
}
