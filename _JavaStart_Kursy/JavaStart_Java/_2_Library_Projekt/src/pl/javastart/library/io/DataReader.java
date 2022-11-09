package pl.javastart.library.io;

import pl.javastart.library.model.Book;
import pl.javastart.library.model.LibraryUser;
import pl.javastart.library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook() {
        printer.printLine("Tytu³:");
        String title = scanner.nextLine();
        printer.printLine("Autor:");
        String author = scanner.nextLine();
        printer.printLine("Wydawnictwo:");
        String publisher = scanner.nextLine();
        printer.printLine("ISBN:");
        String isbn = scanner.nextLine();
        printer.printLine("Rok wydania:");
        int releaseDate = getInt();
        printer.printLine("Liczba stron:");
        int pages = getInt();

        return new Book(title, author, releaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine("Tytu³:");
        String title = scanner.nextLine();
        printer.printLine("Wydawnictwo:");
        String publisher = scanner.nextLine();
        printer.printLine("Jêzyk:");
        String language = scanner.nextLine();
        printer.printLine("Rok wydania:");
        int year = getInt();
        printer.printLine("Miesi¹c:");
        int month = getInt();
        printer.printLine("Dzieñ:");
        int day = getInt();

        return new Magazine(title, publisher, language, year, month, day);
    }

    public LibraryUser createLibraryUser() {
        printer.printLine("Imiê:");
        String firstName = scanner.nextLine();
        printer.printLine("Nazwisko:");
        String lastName = scanner.nextLine();
        printer.printLine("Pesel:");
        String pesel = scanner.nextLine();
        return new LibraryUser(firstName, lastName, pesel);
    }


    public int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public String getString() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
