package Zad_78_Strumienie4;

import java.util.List;
import java.util.stream.Collectors;

class MusicCollection {
    public static void main(String[] args) {
        List<Song> songs = List.of(
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("No One", 248, "Alicia Keys", Song.Genre.POP),
                new Song("Nothing Else Matters", 386, "Metallica", Song.Genre.METAL),
                new Song("Believer", 216, "Imagine Dragons", Song.Genre.ROCK),
                new Song("Fear of The Dark", 438, "Iron Maiden", Song.Genre.METAL),
                new Song("Enter Sandman", 346, "Metallica", Song.Genre.METAL),
                new Song("The Unforgiven", 348, "Metallica", Song.Genre.METAL),
                new Song("Girl on Fire", 404, "Alicia Keys", Song.Genre.POP)
        );

        Song.Genre genre = Song.Genre.ROCK;
        String artist = "Metallica";

        System.out.printf(
                        """
                        £¹czny czas piosenek %sowych na playliœcie (w sekundach): %d
                        Liczba piosenek zespo³u "%s" na playliœcie: %d
                        Piosenki bez %1$s%6$s:
                        %s
                        """,
                genre.toString().toLowerCase(),
                getTotalLengthOfGenre(songs, genre),
                artist,
                getNumOfSongsOfArtist(songs, artist),
                getSongsWithoutGenre(songs, genre),
                genre.equals(Song.Genre.ROCK) ? "a" : "u"
        );
    }

    private static String getSongsWithoutGenre(List<Song> songs, Song.Genre genre) {
        return songs.stream()
                .filter(song -> song.getGenre() != genre)
                .map(Song::toString)
                .distinct()
                .collect(Collectors.joining());
    }

    private static long getNumOfSongsOfArtist(List<Song> songs, String artist) {
        return songs.stream()
                .filter(song -> song.getArtist().equals(artist))
                .count();
    }

    private static int getTotalLengthOfGenre(List<Song> songs, Song.Genre genre) {
        return songs.stream()
                .filter(song -> song.getGenre() == genre)
                .mapToInt(Song::getLength)
                .sum();
    }
}
