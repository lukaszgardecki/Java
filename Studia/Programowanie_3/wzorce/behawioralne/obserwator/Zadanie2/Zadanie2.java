package wzorce.behawioralne.obserwator.Zadanie2;

import wzorce.behawioralne.obserwator.Zadanie2.nadawcy.KanalWideo;
import wzorce.behawioralne.obserwator.Zadanie2.obserwatorzy.Subskrybent;

/**
 * Zadanie 2: kanał wideo i subskrybenci
 *
 * Cel: praktyka z dynamicznym zarządzaniem obserwatorami
 *
 * - zaimplementuj klasę KanalWideo, która informuje subskrybentów (Subskrybent) o nowych filmach
 * - Wymagania:
 *      - KanalWideo jako Podmiot
 *      - Syubskrybent jako Obserwator
 *      - metoda dodajFilm(String tytul) powinna powiadamiać wszystkich subskrybentów
 */
public class Zadanie2 {
    public static void main(String[] args) {
        KanalWideo kanal = new KanalWideo();
        kanal.dodajObserwatora(new Subskrybent("Ala"));
        kanal.dodajObserwatora(new Subskrybent("Jan"));

        kanal.dodajFilm("Jakiś film");
    }
}
