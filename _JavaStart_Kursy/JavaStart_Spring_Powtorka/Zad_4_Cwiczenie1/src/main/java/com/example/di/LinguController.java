package com.example.di;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

@Controller
public class LinguController {
    private static final int TEST_SIZE = 10;
    private final ConsoleOutputWriter writer;
    private final EntryRepository entryRepository;
    private final FileService fileService;
    private final Scanner scanner;

    public LinguController(ConsoleOutputWriter writer, EntryRepository entryRepository, FileService fileService, Scanner scanner) {
        this.writer = writer;
        this.entryRepository = entryRepository;
        this.fileService = fileService;
        this.scanner = scanner;
    }

    void mainLoop() {
        writer.println("Witaj w aplikacji LinguApp");
        Option option = null;
        do {
            printMenu();
            try {
                option = chooseOption();
                executeOption(option);
            } catch (IllegalArgumentException e) {
                writer.println(e.getMessage());
            }
        } while (option != Option.EXIT);
    }

    private Option chooseOption() {
        int option = scanner.nextInt();
        scanner.nextLine();
        return Option.fromInt(option);
    }

    private void executeOption(Option option) {
        switch (option) {
            case ADD_ENTRY -> addEntry();
            case START_TEST -> startTest();
            case EXIT -> close();
        }
    }

    private void startTest() {
        if(entryRepository.isEmpty()) {
            writer.println("Dodaj przynajmniej jedną frazę do bazy.");
            return;
        }
        final int testSize = Math.min(entryRepository.size(), TEST_SIZE);
        Set<Entry> randomEntries = entryRepository.getRandomEntries(testSize);
        int score = 0;
        for (Entry entry : randomEntries) {
            writer.println(String.format("Podaj tłumaczenie dla :\"%s\"", entry.getOriginal()));
            String translation = scanner.nextLine();
            if(entry.getTranslation().equalsIgnoreCase(translation)) {
                writer.println("Odpowiedź poprawna");
                score++;
            } else {
                writer.println("Odpowiedź niepoprawna - " + entry.getTranslation());
            }
        }
        writer.println(String.format("Twój wynik: %d/%d", score, testSize));
    }

    private void addEntry() {
        writer.println("Podaj oryginalną frazę");
        String original = scanner.nextLine();
        writer.println("Podaj tłumaczenie");
        String translation = scanner.nextLine();
        Entry entry = new Entry(original, translation);
        entryRepository.add(entry);
    }

    private void close() {
        try {
            fileService.saveEntries(entryRepository.getAll());
            writer.println("Zapisano stan aplikacji");
        } catch (IOException e) {
            writer.println("Nie udało się zapisać zmian");
        }
        writer.println("Bye Bye!");
    }

    private void printMenu() {
        writer.println("Wybierz opcję:");
        for (Option option : Option.values()) {
            writer.println(option.toString());
        }
    }
    private static enum Option {
        ADD_ENTRY(1, "Dodaj tekst z tłumaczeniem"),
        START_TEST(2, "Rozpocznij test"),
        EXIT(3, "Koniec programu");

        private final int optionNumber;
        private final String description;

        Option(int optionNumber, String description) {
            this.optionNumber = optionNumber;
            this.description = description;
        }

        static Option fromInt(int option) {
            if (option < 0 || option > values().length) {
                throw new IllegalArgumentException("Opcja o takim numerze nie istnieje");
            }
            return values()[option - 1];
        }

        @Override
        public String toString() {
            return String.format("%d - %s", optionNumber, description);
        }
    }
}
