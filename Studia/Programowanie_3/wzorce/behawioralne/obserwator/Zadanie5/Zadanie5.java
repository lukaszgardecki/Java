package wzorce.behawioralne.obserwator.Zadanie5;

import wzorce.behawioralne.obserwator.Zadanie5.nadawcy.RejestrZdarzen;
import wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy.WyswietlanieNaKonsoli;
import wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy.WysylkaMaila;
import wzorce.behawioralne.obserwator.Zadanie5.obserwatorzy.ZapisDoPliku;

/**
 * Zadanie 5: system logowania
 *
 * Cel: pokazanie elastyczności wzorca
 *
 * - zaimplementuj klasę RejestrZdarzen, która informuje różne moduły (ZapisDoPliku, WyswietlanieNaKonsoli, WysylkaMaila) o nowych komunikatach
 * - Wymagania:
 *      - możliwość dynamicznego dodawania nowych typów rejestratorów
 *      - każdy rejestrator reaguje inaczej
 */
public class Zadanie5 {
    public static void main(String[] args) {
        RejestrZdarzen rejestr = new RejestrZdarzen();
        rejestr.dodajObserwatora(new ZapisDoPliku());
        rejestr.dodajObserwatora(new WyswietlanieNaKonsoli());
        rejestr.dodajObserwatora(new WysylkaMaila());

        rejestr.dodajLog("Użytkownik zalogował się.");
        rejestr.dodajLog("Błąd: nieprawidłowe hasło.");
    }
}
