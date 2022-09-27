package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_8;

import java.util.regex.Pattern;

public class Przyklad8 {
    public static void main(String[] args) {
        // ogólny wzorzec separatorów do wyró¿niania s³ów:
        // separatorem jest 1 lub wiêcej "bia³ych znaków" lub znaków interpunkcji
        String regex = "[\\s\\p{Punct}]+";

        // Tekst wejœciowy
        String txt = "Ala(11), kot,; pies-1 <kot2>[mrówka]";

        // Kompilacja wzorca
        Pattern pattern = Pattern.compile(regex);
        String[] words = pattern.split(txt);     // inaczej wo³ane ni¿  split() z klasy String

        System.out.println("Liczba wyró¿nionych s³ów: " + words.length);
        for (String w : words) {
            System.out.println(w);
        }
    }
}
