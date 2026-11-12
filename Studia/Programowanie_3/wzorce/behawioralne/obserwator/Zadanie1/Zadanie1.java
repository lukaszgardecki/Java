package wzorce.behawioralne.obserwator.Zadanie1;

import wzorce.behawioralne.obserwator.Zadanie1.nadawcy.StacjaPogodowa;
import wzorce.behawioralne.obserwator.Zadanie1.obserwatorzy.WyswietlaczStatystyk;
import wzorce.behawioralne.obserwator.Zadanie1.obserwatorzy.WyswietlaczTemperatury;

/**
 * Zadanie 1: stacja pogodowa
 *
 * Cel: zrozumienie podstaw wzorca obserwator
 *
 * - zaprojektuj klsy StacjaPogodowa, WyswietlaczTemperatury i WyswietlaczStatystyk, które współpracują zgodnie ze wzorcem Obserwator
 * - Wymagania:
 *      - interfejs Obserwator z metodą aktualizuj(float temperatura)
 *      - interfejs Podmiot z metodami dodajObserwatora, usunObserwatora, powiadomObserwatorow
 *      - StacjaPogodowa implementuje Podmiot
 *      - obserwatorzy reagują na zmianę temperatury
 */
public class Zadanie1 {
    public static void main(String[] args) {
        StacjaPogodowa stacja = new StacjaPogodowa();
        stacja.dodajObserwatora(new WyswietlaczTemperatury());
        stacja.dodajObserwatora(new WyswietlaczStatystyk());

        stacja.ustawTemperatura(21.0f);
        stacja.ustawTemperatura(23.5f);
        stacja.ustawTemperatura(19.8f);
    }
}
