package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_7;

import java.util.StringTokenizer;

public class Words {
    private String[] words;      // tablica slów
    private String maxLenWord;   // s³owo o max d³ugoœci
    private String minLenWord;   // s³owo o minimalnej d³ugoœci

    // Konstruktor
    public Words(String txt) throws IllegalArgumentException {

        // Sprawdzamy czy przekazano w³aœciwy argument
        if (txt == null)
            throw new IllegalArgumentException("Wadliwy argument konstruktora Words: null");

        // Uwzglêdniamy bogaty zestaw separatorów s³ów
        StringTokenizer st = new StringTokenizer(txt, " \t\n\r\f.,:;()[]\"'?!-{}");

        int n = st.countTokens();      // ile s³ów?
        if (n == 0)
            throw new IllegalArgumentException("Wadliwy argument konstruktora Words: napis nie zawiera s³ów");

        words = new String[n];         // utworzenie tablicy s³ów
        words[0] = st.nextToken();     // pierwsze s³owo
        int maxL = words[0].length(),  // max i min d³ugoœæ (na razie = d³ugoœci pierwszego s³owa)
                minL = maxL;

        int i = 1;                     // kolejny indeks w tablicy

        while (st.hasMoreTokens()) {   // dopóki s¹ slowa
            String s = st.nextToken();
            int len = s.length();
            if (len > maxL) {            // maksymalna d³ugoœæ ?
                maxL = len;
                maxLenWord = s;
            }
            if (len < minL) {            // minimalna d³ugoœæ ?
                minL = len;
                minLenWord = s;
            }
            words[i++] = s;              // slowo -> do tablicy; zwiêkszenie indeksu
        }
    }

    // Zwraca liczbê s³ów
    public int getWordsCount() {
        return words.length;
    }

    // Zwraca i-te s³owo (liczymy od 1)
    // jeœli podano wadliwy indeks - zwraca null
    public String getWord(int i) {
        return (i < 1 || i > words.length) ? null : words[i-1];
    }

    // Zwraca tablicê slów
    public String[] getWords() {
        return words;
    }

    // Zwraca slowo o max d³ugoœci
    public String getMaxLenWord() {
        return maxLenWord;
    }
    // Zwraca slowo o min d³ugoœci
    public String getMinLenWord() {
        return minLenWord;
    }

}
