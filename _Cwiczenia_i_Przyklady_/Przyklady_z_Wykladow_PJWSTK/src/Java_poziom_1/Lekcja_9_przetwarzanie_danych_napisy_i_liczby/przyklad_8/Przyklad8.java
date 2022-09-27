package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_8;

import java.util.regex.Pattern;

public class Przyklad8 {
    public static void main(String[] args) {
        // og�lny wzorzec separator�w do wyr�niania s��w:
        // separatorem jest 1 lub wi�cej "bia�ych znak�w" lub znak�w interpunkcji
        String regex = "[\\s\\p{Punct}]+";

        // Tekst wej�ciowy
        String txt = "Ala(11), kot,; pies-1 <kot2>[mr�wka]";

        // Kompilacja wzorca
        Pattern pattern = Pattern.compile(regex);
        String[] words = pattern.split(txt);     // inaczej wo�ane ni�  split() z klasy String

        System.out.println("Liczba wyr�nionych s��w: " + words.length);
        for (String w : words) {
            System.out.println(w);
        }
    }
}
