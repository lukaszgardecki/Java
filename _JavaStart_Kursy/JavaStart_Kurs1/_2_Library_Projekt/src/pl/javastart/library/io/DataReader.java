package pl.javastart.library.io;

import pl.javastart.library.model.Book;
import pl.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);

    public Book readAndCreateBook() {
        System.out.println("Tytu�:");
        String title = scanner.nextLine();
        System.out.println("Autor:");
        String author = scanner.nextLine();
        System.out.println("Wydawnictwo:");
        String publisher = scanner.nextLine();
        System.out.println("ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Rok wydania:");
        int releaseDate = getInt();
        System.out.println("Liczba stron:");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytu�:");
        String title = scanner.nextLine();
        System.out.println("Wydawnictwo:");
        String publisher = scanner.nextLine();
        System.out.println("J�zyk:");
        String language = scanner.nextLine();
        System.out.println("Rok wydania:");
        int year = getInt();
        System.out.println("Miesi�c:");
        int month = getInt();
        System.out.println("Dzie�:");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }

    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public void close() {
        scanner.close();
    }
}
