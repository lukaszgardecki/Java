package phonebook;

import java.io.IOException;
import java.util.*;

import static phonebook.Option.*;

public class TeleBookController {
    private TeleBook teleBook;
    private Scanner input = new Scanner(System.in);

    public TeleBookController() {
        teleBook = FileUtils.read();
    }

    public void loop() {
        Option op = null;
        do {
            showOptions();
            try {
                op = chooseOption();
                executeOption(op);
            } catch (NoSuchElementException e) {
                System.out.println("Niepoprawna opcja. Spróbuj ponownie.");
            }
        } while (op != EXIT);
    }

    private int getInt() {
        Integer op = null;
        do {
            try {
                op = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Wprowadź liczbę!");
                input.nextLine();
            }
        } while (op == null);
        return op;
    }

    private void showOptions() {
        System.out.println("--- Wybierz opcję:");
        Arrays.stream(values()).forEach(System.out::println);
    }

    private Option chooseOption() {
        int choice = getInt();
        return convertToOption(choice);
    }

    private void executeOption(Option op) {
        switch (op) {
            case ADD -> addContact();
            case FIND_BY_NAME -> searchByName();
            case FIND_BY_TELEPHONE -> searchByTelephone();
            case DELETE -> delete();
            case EXIT -> close();
        }
    }

    private void delete() {
        System.out.println("Podaj nazwę rekordu do usunięcia:");
        String name = input.nextLine();
        boolean isRemoved = teleBook.remove(name);
        if (isRemoved) {
            System.out.println("Rekord usunięty.");
        } else {
            System.out.println("Nie ma rekordu o takiej nazwie.");
        }
    }

    private void searchByTelephone() {
        System.out.println("Podaj numer telefonu lub jego fragment");
        String telFragment = input.nextLine();
        List<Contact> contacts = teleBook.findByTelephone(telFragment);
        if (contacts.isEmpty()) {
            System.out.println("Brak wyników wyszukiwania.");
        } else {
            System.out.println("Znalezione rekordy:");
            contacts.forEach(System.out::println);
        }
    }

    private void searchByName() {
        System.out.println("Podaj fragment nazwy:");
        String nameFragment = input.nextLine();
        List<Contact> contacts = teleBook.findByName(nameFragment);
        if (contacts.isEmpty()) {
            System.out.println("Brak wyników wyszukiwania.");
        } else {
            System.out.println("Znalezione kontakty:");
            contacts.forEach(System.out::println);
        }
    }

    private void addContact() {
        System.out.println("Podaj nazwę kontaktu:");
        String name = input.nextLine();
        System.out.println("Podaj nr telefonu:");
        String telephone = input.nextLine();

        try {
            boolean isAdded = teleBook.add(name, telephone);
            if (isAdded) {
                System.out.println("Rekord dodany.");
            } else {
                System.out.println("nie można dodać rekordu. Wpis o takiej nazwie już istnieje.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Nazwa ani numer telefonu nie mogą być puste.");
        }
    }

    private void close() {
        input.close();
        try {
            FileUtils.save(teleBook);
        } catch (IOException e) {
            System.err.println("Nie udało się zapisac zmian.");
        }
        System.out.println("Zamykanie programu...");
    }
}
