package wzorce.behawioralne.obserwator.Zadanie4;

import wzorce.behawioralne.obserwator.Zadanie4.nadawcy.ZarzadcaZdarzenGry;
import wzorce.behawioralne.obserwator.Zadanie4.obserwatorzy.Gracz;
import wzorce.behawioralne.obserwator.Zadanie4.obserwatorzy.LicznikPunktow;

/**
 * Zadanie 4: zdarzenia w grze
 *
 * Cel: integracja wzorca z logiką gry
 *
 * - zaprojektuj system, w którym ZarzadcaZdarzenGry informuje obiekty Gracz, Przeciwnik, LicznikPunktow o zdarzeniach takich jak "pokonano bossa" lub "awans na poziom"
 * - Wymagania:
 *     - zdarzenia jako typy powiadomien
 *     - obserwatorzy reagują selektywnie na konkretne zdarzenia
 */
public class Zadanie4 {
    public static void main(String[] args) {
        ZarzadcaZdarzenGry zarzadca = new ZarzadcaZdarzenGry();
        zarzadca.dodajObserwatora(new Gracz());
        zarzadca.dodajObserwatora(new LicznikPunktow());

        zarzadca.wystapiloZdarzenie("pokonano bossa");
        zarzadca.wystapiloZdarzenie("awans na poziom");
    }
}
