package pl.javastart.library.app;

import pl.javastart.library.io.DataReader;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;
import pl.javastart.library.model.Magazine;

class LibraryControl {
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;
    private static final int PRINT_BOOKS = 3;
    private static final int PRINT_MAGAZINES = 4;
    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadŸ ponownie.");
            }
        } while (option != EXIT);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void exit() {
        System.out.println("Koniec programu!");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void printOptions() {
        System.out.printf("""
                
                Wybierz opcjê:
                %s - wyjœcie z programu
                %s - dodanie nowej ksi¹¿ki
                %s - dodanie nowego magazynu
                %s - wyœwietl dostêpne ksi¹¿ki
                %s - wyœwietl dostêpne magazyny
                
                """, EXIT, ADD_BOOK, ADD_MAGAZINE, PRINT_BOOKS, PRINT_MAGAZINES);
    }
}
