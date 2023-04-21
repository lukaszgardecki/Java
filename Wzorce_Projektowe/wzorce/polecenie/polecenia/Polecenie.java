package wzorce.polecenie.polecenia;

/**
 * Wszystkie obiekty-polecenia współpracujące z pilotem posiadają
 * zaimplementowany interfejs Polecenie, który składa się z dwóch
 * metod: wykonaj() i wycofaj(). Obiekty-polecenia dokonują
 * hermetyzacji danego zestawu operacji, który będzie realizowany
 * przez określoną klasę sterującą. Pilot inicjuje realizaję takich
 * operacji (takiego żądania) poprzez wywołanie metody wykonaj().
 * Naciśnięcie przycisku Wycofaj na pilocie powoduje anulowanie
 * (wycofanie) ostatniego żadania poprzez wywołanie metody wycofaj().
 */
public interface Polecenie {

    void wykonaj();
    void wycofaj();
}
