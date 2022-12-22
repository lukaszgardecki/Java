public class Test {

    /**
     * W programie stwórz klasę reprezentującą pojedynczą piosenkę. Każda piosenka powinna mieć informację o
     * nazwie oraz czasie trwania wyrażoną w sekundach.
     *
     * W osobnej klasie, np. Playlist, zdefiniuj metodę, która przyjmuje dowolną liczbę piosenek (jako osobne argumenty)
     * i zwraca łączny czas odtwarzania w sekundach.
     *
     * Stwórz klasę testową, w której wyświetlisz czas odtwarzania w postaci HH:mm:ss gdzie H to godziny, m to minuty, a s to sekundy.
     */

    public static void main(String[] args) {
        Song song1 = new Song("Ulalala", 308770);
        int playlistLength = Playlist.playlistLength(song1);

        Song song2 = new Song("Ulalala", 3440);
        Song song3 = new Song("Nothing else matters", 6770);
        int playlistLength2 = Playlist.playlistLength(song2, song3);

        Playlist.displayTime(playlistLength);
        Playlist.displayTime(playlistLength2);
    }


}
