package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_7;

import java.util.StringTokenizer;

public class Words {
    private String[] words;      // tablica sl�w
    private String maxLenWord;   // s�owo o max d�ugo�ci
    private String minLenWord;   // s�owo o minimalnej d�ugo�ci

    // Konstruktor
    public Words(String txt) throws IllegalArgumentException {

        // Sprawdzamy czy przekazano w�a�ciwy argument
        if (txt == null)
            throw new IllegalArgumentException("Wadliwy argument konstruktora Words: null");

        // Uwzgl�dniamy bogaty zestaw separator�w s��w
        StringTokenizer st = new StringTokenizer(txt, " \t\n\r\f.,:;()[]\"'?!-{}");

        int n = st.countTokens();      // ile s��w?
        if (n == 0)
            throw new IllegalArgumentException("Wadliwy argument konstruktora Words: napis nie zawiera s��w");

        words = new String[n];         // utworzenie tablicy s��w
        words[0] = st.nextToken();     // pierwsze s�owo
        int maxL = words[0].length(),  // max i min d�ugo�� (na razie = d�ugo�ci pierwszego s�owa)
                minL = maxL;

        int i = 1;                     // kolejny indeks w tablicy

        while (st.hasMoreTokens()) {   // dop�ki s� slowa
            String s = st.nextToken();
            int len = s.length();
            if (len > maxL) {            // maksymalna d�ugo�� ?
                maxL = len;
                maxLenWord = s;
            }
            if (len < minL) {            // minimalna d�ugo�� ?
                minL = len;
                minLenWord = s;
            }
            words[i++] = s;              // slowo -> do tablicy; zwi�kszenie indeksu
        }
    }

    // Zwraca liczb� s��w
    public int getWordsCount() {
        return words.length;
    }

    // Zwraca i-te s�owo (liczymy od 1)
    // je�li podano wadliwy indeks - zwraca null
    public String getWord(int i) {
        return (i < 1 || i > words.length) ? null : words[i-1];
    }

    // Zwraca tablic� sl�w
    public String[] getWords() {
        return words;
    }

    // Zwraca slowo o max d�ugo�ci
    public String getMaxLenWord() {
        return maxLenWord;
    }
    // Zwraca slowo o min d�ugo�ci
    public String getMinLenWord() {
        return minLenWord;
    }

}
