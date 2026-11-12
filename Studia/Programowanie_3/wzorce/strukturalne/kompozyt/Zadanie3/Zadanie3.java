package wzorce.strukturalne.kompozyt.Zadanie3;

/**
 * Zadanie 3: wyrażenia arytmetyczne
 *
 * Cel: zbudować drzewo wyrażeń matematycznych
 *
 * - liście: Liczba
 * - kompozyty: Dodawanie, Mnożenie, Odejmowanie
 * - metoda oblicz() zwraca wynik całego wyrażenia
 * - Rozszerzenie: dodanie dzielenia z obsługą wyjątków (np. dzielnie przez zero)
 */
public class Zadanie3 {
    public static void main(String[] args) {
        Wyrazenie w1 = new Liczba(8);
        Wyrazenie w2 = new Liczba(2);
        Wyrazenie w3 = new Dodawanie(w1, w2); // 8 + 2

        Wyrazenie w4 = new Liczba(5);
        Wyrazenie w5 = new Mnozenie(w3, w4); // (8 + 2) * 5

        Wyrazenie w6 = new Liczba(10);
        Wyrazenie w7 = new Dzielenie(w5, w6); // ((8 + 2) * 5) / 10
        System.out.println("Wynik wyrazenia: " + w7.oblicz());
    }
}
