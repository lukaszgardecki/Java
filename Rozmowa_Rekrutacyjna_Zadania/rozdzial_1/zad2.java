package rozdzial_1;

public class zad2 {

     /*
     * Zaimplementuj w języku C lub C++ funkcję void reverse(char* str),
     * która odwraca znaki w łańcuchu zakończonym znakiemn null.
     */

    public static void main(String[] args) {
        String s1 = "asdf";
        String s2 = "asdfnull";

        System.out.println(reverse(s1));
        System.out.println(reverse(s2));
    }

    private static String reverse(String s) {
        if (s.endsWith("null")) {
            s = s.substring(0, s.length() - 4);
            return new StringBuffer(s).reverse().toString();
        }
        return s;
    }
}
