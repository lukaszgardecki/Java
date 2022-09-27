package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_7;

import static javax.swing.JOptionPane.showInputDialog;

public class TestWords {
    public static void main(String[] args) {
        String txt;
        while ((txt = showInputDialog("Wpisz tekst")) != null) {
            Words w = new Words(txt);
            int n = w.getWordsCount();
            System.out.println("Liczba s��w: " + n);
            System.out.println("Kolejne slowa: ");
            for (int i=1; i <= n; i++) System.out.println(w.getWord(i));
            int iw = Integer.parseInt(showInputDialog("Podaj numer s�owa:"));
            System.out.println("S�owo o numerze " + iw + ": " + w.getWord(n+1));
            System.out.println("Kolejne slowa: ");
            String[] words = w.getWords();
            for (String wrd : words) System.out.println(wrd);
            System.out.println("Najdlu�sze s�owo: " + w.getMaxLenWord());
            System.out.println("Najkr�tsze s�owo: " + w.getMinLenWord());
        }
    }
}
