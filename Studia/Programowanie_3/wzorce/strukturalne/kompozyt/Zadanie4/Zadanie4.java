package wzorce.strukturalne.kompozyt.Zadanie4;

/**
 * Zadanie 4: organizacja firmy
 *
 * Cel: odwzorować hierarchię organizacyjną przedsiębiorstwa
 *
 * - Pracownik (liść) przechowuje dane pracownika i jego pensję
 * - Dzial (kompozyt) zawiera pracowników i inne dzialy
 * - metoda pobierzPensje() zwraca sumę wynagerodzeń w danym dziale
 * - Rozszerzenie: metoda wypiszHierarchie() pokazuje strukturę całej firmy
 */
public class Zadanie4 {
    public static void main(String[] args) {
        ElementOrganizacji p1 = new Pracownik("Anna", 5000);
        ElementOrganizacji p2 = new Pracownik("Bartek", 6200);
        ElementOrganizacji p3 = new Pracownik("Celina", 4800);

        Dzial dzialHR = new Dzial("HR");
        dzialHR.dodaj(p1);
        dzialHR.dodaj(p2);

        Dzial dzialIT = new Dzial("IT");
        dzialIT.dodaj(p3);

        Dzial firma = new Dzial("Firma XYZ");
        firma.dodaj(dzialHR);
        firma.dodaj(dzialIT);

        firma.wypiszHierarchie("");
        System.out.println("Całkowita pensja: " + firma.pobierzPensje());
    }
}
