package wzorce.strukturalne.kompozyt.Zadanie2;

/**
 * Zadanie 2: menu aplikacji
 *
 * Cel: utworzyć hierarchię menu i podmenu
 *
 * - PozycjaMenu (liść) reprezentuje pojedynczą opcję
 * - Menu (kompozyt) zawiera elementy menu i podmenu
 * - Metoda wypisz() wypisuje strukturę menu z odpowiednimi wcięciami
 * - Rozszerzenie: dodanie akcji wykonywanej po wyborze pozycji menu
 */
public class Zadanie2 {
    public static void main(String[] args) {
        ElementMenu opcja1 = new PozycjaMenu("Nowy plik");
        ElementMenu opcja2 = new PozycjaMenu("Zapisz");
        ElementMenu opcja3 = new PozycjaMenu("Zamknij");

        Menu menuPlik = new Menu("Plik");
        menuPlik.dodaj(opcja1);
        menuPlik.dodaj(opcja2);
        menuPlik.dodaj(opcja3);

        ElementMenu opcja4 = new PozycjaMenu("Kopiuj");
        ElementMenu opcja5 = new PozycjaMenu("Wklej");

        Menu menuEdycja = new Menu("Edycja");
        menuEdycja.dodaj(opcja4);
        menuEdycja.dodaj(opcja5);

        Menu menuGlowne = new Menu("Glowne menu");
        menuGlowne.dodaj(menuPlik);
        menuGlowne.dodaj(menuEdycja);

        menuGlowne.wypisz("");
    }
}
