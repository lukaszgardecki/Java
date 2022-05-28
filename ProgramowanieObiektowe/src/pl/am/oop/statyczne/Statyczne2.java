package pl.am.oop.statyczne;

import static pl.am.oop.statyczne.Pracownik.NAZWA_FIRMY;
import static pl.am.oop.statyczne.Pracownik.infoFirma;

public class Statyczne2 {
    public static void main(String[] args) {

        new Pracownik("Jan", "Kowalski");
        new Pracownik("Jan", "Kowalski");
        new Pracownik("Jan", "Kowalski");
        new Pracownik("Jan", "Kowalski");
        new Pracownik("Jan", "Kowalski");

        System.out.println(NAZWA_FIRMY);
        System.out.println(infoFirma());
    }
}
