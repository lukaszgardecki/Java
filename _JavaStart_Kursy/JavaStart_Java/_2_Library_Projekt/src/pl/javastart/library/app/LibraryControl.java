package pl.javastart.library.app;

import pl.javastart.library.exception.*;
import pl.javastart.library.io.ConsolePrinter;
import pl.javastart.library.io.DataReader;
import pl.javastart.library.io.file.FileManager;
import pl.javastart.library.io.file.FileManagerBuilder;
import pl.javastart.library.model.*;

import java.util.Comparator;
import java.util.InputMismatchException;

class LibraryControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library;
    private FileManager fileManager;


    LibraryControl() {
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            library = fileManager.importData();
            printer.printLine("Zaimportowano dane z pliku.");
        } catch (DataImportException | InvalidDataException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano now¹ bazê.");
            library = new Library();
        }
    }

    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case DELETE_BOOK -> deleteBook();
                case DELETE_MAGAZINE -> deleteMagazine();
                case ADD_USER -> addUser();
                case PRINT_USERS -> printUsers();
                case FIND_BOOK -> findBook();
                case EXIT -> exit();
                default -> System.out.println("Nie ma takiej opcji, wprowadŸ ponownie.");
            }
        } while (option != Option.EXIT);
    }

    private void findBook() {
        printer.printLine("Podaj tytu³ publikacji:");
        String title = dataReader.getString();
        String notFoundMessage = "Brak publikacji o takim tytule.";
        library.findPublicationByTitle(title)
                .map(Publication::toString)
                .ifPresentOrElse(System.out::println, () -> System.out.println(notFoundMessage));

    }

    private void printUsers() {
        printer.printUsers(library.getSortedUsers(
//                (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName())
                Comparator.comparing(User::getLastName, String.CASE_INSENSITIVE_ORDER)
        ));
    }

    private void addUser() {
        LibraryUser libraryUser = dataReader.createLibraryUser();
        try {
            library.addUser(libraryUser);
        } catch (UserAlreadyExistsException e) {
            printer.printLine(e.getMessage());
        }
    }


    private Option getOption() {
        boolean optionOK = false;
        Option option = null;
        while (!optionOK) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOK = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartoœæ, która nie jest liczb¹, podaj ponownie: ");
            }
        }
        return option;
    }

    private void printMagazines() {
        printer.printMagazines(library.getSortedPublications(
//                (p1, p2) -> p1.getTitle().compareToIgnoreCase(p2.getTitle())
                Comparator.comparing(Publication::getTitle, String.CASE_INSENSITIVE_ORDER)
        ));
    }



    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie uda³o siê utworzyæ magazynu, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osi¹gniêto limit pojemnoœci, nie mo¿na dodaæ kolejnego magazynu.");
        }
    }

    private void deleteMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazine)) {
                printer.printLine("Usuniêto magazyn.");
            } else {
                printer.printLine("Brak wskazanego magazynu.");
            }
        } catch (InputMismatchException e) {
            printer.printLine("Nie uda³o siê utworzyæ magazynu, niepoprawne dane.");
        }
    }

    private void exit() {
        try {
            fileManager.exportData(library);
            printer.printLine("Export danych do pliku zakoñczony powodzeniem");
        } catch (DataExportException e) {
            printer.printLine(e.getMessage());
        }
        printer.printLine("Koniec programu!");
        dataReader.close();
    }

    private void printBooks() {
        printer.printBooks(library.getSortedPublications(
//                (p1, p2) -> p1.getTitle().compareToIgnoreCase(p2.getTitle())
                Comparator.comparing(Publication::getTitle, String.CASE_INSENSITIVE_ORDER)
        ));
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie uda³o siê utworzyæ ksi¹¿ki, niepoprawne dane.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osi¹gniêto limit pojemnoœci, nie mo¿na dodaæ kolejnej ksi¹¿ki.");
        }
    }

    private void deleteBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            if (library.removePublication(book)) {
                printer.printLine("Usuniêto ksi¹¿kê.");
            } else {
                printer.printLine("Brak wskazanej ksi¹¿ki.");
            }
        } catch (InputMismatchException e) {
            printer.printLine("Nie uda³o siê utworzyæ ksi¹¿ki, niepoprawne dane.");
        }
    }

    private void printOptions() {
        printer.printLine("Wybierz opcjê:");
        for (Option value : Option.values()) {
            printer.printLine(value.toString());
        }
    }


    private enum Option {
        EXIT(0, "wyjœcie z programu"),
        ADD_BOOK(1, "dodanie nowej ksi¹¿ki"),
        ADD_MAGAZINE(2, "dodanie nowego magazynu"),
        PRINT_BOOKS(3, "wyœwietl dostêpne ksi¹¿ki"),
        PRINT_MAGAZINES(4, "wyœwietl dostêpne magazyny"),
        DELETE_BOOK(5, "usuñ ksi¹¿kê"),
        DELETE_MAGAZINE(6, "usuñ magazyn"),
        ADD_USER(7, "dodaj czytelnika"),
        PRINT_USERS(8, "wyœwietl czytelników"),
        FIND_BOOK(9, "wyszukaj ksi¹¿kê");

        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }
        }

    }



}
