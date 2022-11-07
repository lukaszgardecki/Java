package pl.kurs.mp3reader;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TagException, IOException {

        File file = new File("src/scott_holmes_music_stylish_groove.mp3");
        MP3File mp3File = new MP3File(file);

        if (mp3File.hasID3v2Tag()) {
            // odczyt tytułu
            String title = mp3File.getID3v2Tag().getSongTitle();
            // odczyt autora
            String author = mp3File.getID3v2Tag().getLeadArtist();
            //odczyt nazwy albumu
            String albumName = mp3File.getID3v2Tag().getAlbumTitle();
            //odczyt gatunku
            String genre = mp3File.getID3v2Tag().getSongGenre();
            //odczyt roku wydania
            String yearReleased = mp3File.getID3v2Tag().getYearReleased();

            System.out.println("Tytuł: " + title);
            System.out.println("Autor: " + author);
            System.out.println("Nazwa albumu: " + albumName);
            System.out.println("Gatunek: " + genre);
            System.out.println("Rok wydania: " + yearReleased);
        } else {
            System.out.println("Brak tagów ID3v2.");
        }


    }
}
