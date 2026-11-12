package wzorce.strukturalne.dekorator.Zadanie4;

import wzorce.strukturalne.dekorator.Zadanie4.dekoratory.AuraMagii;
import wzorce.strukturalne.dekorator.Zadanie4.dekoratory.TarczaEnergetyczna;
import wzorce.strukturalne.dekorator.Zadanie4.postacie.Mag;

/**
 * Zadanie 4: system modyfikatorów postaci w grze RPG
 *
 * - zaprojektuj system modyfikatorów postaci, w którym bohater może być dynamicznie wzmacniany przez efekty (np. zbroja, miksture, zaklęcie, aura)
 * - Wymagania:
 *      - intefejs Postac z metodami int atak(), int obrona(), String opis()
 *      - klasa bazowa: Wojownik, Mag
 *      - dekoratory: Zbroja, MiksturaSily, AuraMagii, TarczaEnergetyczna
 * - Rozszerzenie:
 *      -dodaj dekorator CZasowyEfekt, który działa tylko przez okresloną liczbę tur
 */
public class Zadanie4 {
    public static void main(String[] args) {
//        Postac postac = new MiksturaSily(new Zbroja(new Wojownik()));
        Postac postac = new AuraMagii(new TarczaEnergetyczna(new Mag()));

        System.out.println("Opis: " + postac.opis());
        System.out.println("Atak: " + postac.atak());
        System.out.println("Obrona: " + postac.obrona());
    }
}
