package wzorce.behawioralne.polecenie.Zadanie1;

/**
 * Zadanie 1: Edytor tekstu z poleceniami
 *
 *  - zaimplementuj polecenia: DodajTekst, UsunTekst, ZmienStyl
 *  - każde poelcenie powinno działać na obiekcie Dokument
 *  - dodaj możliwość cofania (Undo) i ponawiania (Redo) operacji
 *  - przykład: użytkownik wpisuje tekst, usuwa fragment, zmienia czcionkę, a następnie cofa ostatnie akcje
 */
public class Main {
    public static void main(String[] args) {
        Dokument dokument = new Dokument();

        Polecenie dodaj = new DodajTekst(dokument, "Witaj świecie!");
        Polecenie usun = new UsunTekst(dokument, 8);
        Polecenie styl = new ZmienStyl(dokument, "kursywa");

        System.out.println("Wykonanie poleceń:");
        dodaj.wykonaj();
        usun.wykonaj();
        styl.wykonaj();
        dokument.pokaz();

        System.out.println("\nCofnięcie poleceń:");
        usun.cofnij();
        dokument.pokaz();
    }
}
