package rozdzial_1;

import java.util.Arrays;

public class zad5 {

     /*
     * Zaimplementuj metodę, która przeprowadza prostą kompresję łańcuchów znaków opartą
     * na zliczaniu powtarzających się liter. Na przykład metoda ma przekształcać łańcuch aabcccccaaa
     * na a2b1c5a3. Jeśli "skompresowany" łańcuch znaków nie jest mniejszy od wyjściowego,
     * metoda powinna zwracać pierwotny łańcuch.
     */

    public static void main(String[] args) {
        String s1 = "aabcccttttttttttccaaa";
        System.out.println(compress(s1));
    }

    private static String compress(String s) {
        int counter = 0;
        StringBuilder returnStr = new StringBuilder();

        for (int i = 0; i < s.length()-1;) {
            char sign = s.charAt(i);

            for (int j = i; j < s.length(); j++) {
                char sign2 = s.charAt(j);
                if (sign2 == sign) {
                    counter++;
                    i = j;
                } else {
                    i = j;
                    break;
                }
            }
            returnStr.append(sign).append(counter);
            counter = 0;
        }

        return returnStr.toString();
    }
}
