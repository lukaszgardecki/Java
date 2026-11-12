package wzorce.strukturalne.kompozyt.Zadanie1;

/**
 * Zadanie 1: system plików
 *
 * Cel: zaimplementować strukturę katalogów i plików
 *
 * - Plik (liść) przechowuje nazwę i rozmiar
 * - Katalog (kompozyt) może zawierać pliki i inne katalogi
 * - metoda pobierzRozmiar() sumuje rozmiary zawartości
 * - Rozszerzenie: dodaj metody wypisz(), która wypisuje hierarchię
 */
public class Zadanie1 {
    public static void main(String[] args) {
        ElementSystemuPlikow plik1 = new Plik("dokument.txt", 120);
        ElementSystemuPlikow plik2 = new Plik("zdjecie.jpg", 850);
        ElementSystemuPlikow plik3 = new Plik("muzyka.mp3", 3200);

        Katalog katalogMuzyka = new Katalog("Muzyka");
        katalogMuzyka.dodaj(plik3);

        Katalog katalogGlowny = new Katalog("Pulpit");
        katalogGlowny.dodaj(plik1);
        katalogGlowny.dodaj(plik2);
        katalogGlowny.dodaj(katalogMuzyka);

        katalogGlowny.wypisz("");
        System.out.println("Całkowity rozmiar: " + katalogGlowny.pobierzRozmiar() + " KB");
    }
}
