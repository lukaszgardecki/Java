package app;

import app.comparator.NicknameComparatorAsc;
import app.comparator.NicknameComparatorDesc;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    /**
     * Piszemy fragment aplikacji, w której będziemy przechowywali statystyki graczy pewnej gry komputerowej.
     *
     * Każdy gracz posiada swój pseudonim (nickname) i liczbę punktów.
     *
     * W programie utwórz tablicę zawierającą kilku graczy, oraz zdefiniuj kilka algorytmów sortujących.
     * Powinna istnieć możliwość sortowania po ilości punktów i pseudonimie zarówno rosnąco jak i malejąco.
     * Domyślny sposób sortowania to po ilości punktów malejąco. Przetestuj działanie zdefiniowanych przez siebie
     * algorytmów i wyświetl wynik po każdym sortowaniu na ekranie.
     *
     * Program napisz w dwóch wersjach:
     *
     *     klasyczna wersja z wykorzystaniem interfejsów Comparable i Comparator (osobne klasy lub klasy anonimowe),
     *     wersja z wykorzystaniem możliwości jakie dają nam nowości wprowadzone w Javie 8.

     */
    public static void main(String[] args) {
        Player[] players = {
            new Player("jan90", 134),
            new Player("mala3", 43),
            new Player("andi1222", 52),
            new Player("mikolaj22", 155),
            new Player("klakson", 2),
        };


        // PIERWSZA WERSJA ZADANIA - TRADYCYJNIE PRZY UŻYCIU COMPARABLE I COMPARATOR:
        Arrays.sort(players);
        System.out.println("Lista graczy posortowana po punktach (malejąco):");
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p1.getScore(), p2.getScore());
            }
        });
        System.out.println("Lista graczy posortowana po punktach (rosnąco):");
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, new NicknameComparatorAsc());
        System.out.println("Lista graczy posortowana alfabetycznie (rosnąco):");
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, new NicknameComparatorDesc());
        System.out.println("Lista graczy posortowana alfabetycznie (malejąco):");
        System.out.println(Arrays.toString(players));


        System.out.println();
        System.out.println();

        // DRUGA WERSJA ZADANIA - LAMBDY I COMPARATOR.COMPARING
        Arrays.sort(players);
        System.out.println("Lista graczy posortowana po punktach (malejąco):");
        System.out.println(Arrays.toString(players));

        //wersja z lambdą:
        Arrays.sort(players, (p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()));
        System.out.println("Lista graczy posortowana po punktach (rosnąco):");
        System.out.println(Arrays.toString(players));
        //wersja z referencją do metody:
        Arrays.sort(players, Comparator.comparingInt(Player::getScore));
        System.out.println("Lista graczy posortowana po punktach (rosnąco):");
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, Comparator.comparing(Player::getNickname));
        System.out.println("Lista graczy posortowana alfabetycznie (rosnąco):");
        System.out.println(Arrays.toString(players));

        Arrays.sort(players, Comparator.comparing(Player::getNickname).reversed());
        System.out.println("Lista graczy posortowana alfabetycznie (malejąco):");
        System.out.println(Arrays.toString(players));
    }
}
