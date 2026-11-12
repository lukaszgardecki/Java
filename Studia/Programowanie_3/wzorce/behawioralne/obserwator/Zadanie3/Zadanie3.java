package wzorce.behawioralne.obserwator.Zadanie3;

import wzorce.behawioralne.obserwator.Zadanie3.nadawcy.DostawcaKursowWalut;
import wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy.AplikacjaMobilna;
import wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy.PanelInternetowy;
import wzorce.behawioralne.obserwator.Zadanie3.obserwatorzy.SystemAlarmowy;

/**
 * Zadanie 3: kursy walut
 *
 * Cel: zastosowanie wzorca w kontekście finansowym
 *
 * - zaprojektuj klasę DostawcaKursowWalut, która informuje różne moduły (AplikacjaMobilna, PanleInternetowy, SystemAlarmowy), o zmianach kursu
 * - Wymagania:
 *      - kurs jako stan obserwowany
 *      - obserwatorzy reagują różnie: np. SystemAlarmowy wysyła alert, PanelInternetowy odświeża dane
 */
public class Zadanie3 {
    public static void main(String[] args) {
        DostawcaKursowWalut dostawca = new DostawcaKursowWalut();
        dostawca.dodajObserwatora(new AplikacjaMobilna());
        dostawca.dodajObserwatora(new SystemAlarmowy());
        dostawca.dodajObserwatora(new PanelInternetowy());

        dostawca.ustawKurs(4.95f);
        dostawca.ustawKurs(5.1f);
        dostawca.ustawKurs(3.2f);
    }
}
