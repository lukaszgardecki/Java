package rozdzial_1;

import java.util.Arrays;

public class zad4 {

     /*
     * Napisz metodę, która zastępuje wszystkie spacje w łańcuchu znaków sekwencją %20.
     * Przyjmij, że na końcu łańcucha dostepne jest miejsce na dodatkowe znaki,
     * a także, że znasz prawdziwą długość łańcucha.
     * Zastosuj tablicę znaków, a by móc wykonać operację w miejscu (bez kopiowania łańcuchów).
     */

    public static void main(String[] args) {
        String s1 = "Pan Jan Nowak       ";
        
        System.out.println(replaceSpaces(s1, 13));
    }

    private static String replaceSpaces(String s1, int len) {
        char[] chars = s1.toCharArray();
        String replace = "%20";
        int amountOfSpaces = 0;
        for (int i = 0; i < len; i++) if (Character.isWhitespace(chars[i])) amountOfSpaces++;
        char[] newArray = new char[len + amountOfSpaces * (replace.length() - 1)];
        for (int i = 0, newArrInd = 0; i < len; i++, newArrInd++) {
            char sign = chars[i];
            if (Character.isWhitespace(sign)) {
                newArray[newArrInd] = '%';
                newArray[++newArrInd] = '2';
                newArray[++newArrInd] = '0';
            } else {
                newArray[newArrInd] = chars[i];
            }
        }
        return Arrays.toString(newArray).replaceAll("[,\\[\\]]", "");
    }
}
