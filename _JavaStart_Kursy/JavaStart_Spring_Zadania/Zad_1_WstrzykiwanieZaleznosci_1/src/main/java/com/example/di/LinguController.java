package com.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

@Controller
class LinguController {
    private static final int UNDEFINED = -1;
    private static final int ADD_ENTRY = 0;
    private static final int TEST = 1;
    private static final int CLOSE_APP = 2;

    private final EntryRepository entryRepository;
    private final FileService fileService;
    private final Scanner scanner;
    private final ConsoleOutputWriter writer;

    @Autowired
    public LinguController(EntryRepository entryRepository,
                           FileService fileService,
                           Scanner scanner,
                           ConsoleOutputWriter writer) {
        this.entryRepository = entryRepository;
        this.fileService = fileService;
        this.scanner = scanner;
        this.writer = writer;
    }

    void mainLoop() {
        writer.println("Witaj w aplikacji LinguApp");
        int option = UNDEFINED;
        while(option != CLOSE_APP) {
            printMenu();
            option = chooseOption();
            executeOption(option);
        }
    }

    private void executeOption(int option) {
        switch (option) {
            case ADD_ENTRY -> addEntry();
            case TEST -> test();
            case CLOSE_APP -> close();
            default -> writer.println("Opcja niezdefiniowana");
        }
    }

    private void test() {
        if(entryRepository.isEmpty()) {
            writer.println("Dodaj przynajmniej jedną frazę do bazy.");
            return;
        }
        final int testSize = entryRepository.size() > 10 ? 10 : entryRepository.size();
        Set<Entry> randomEntries = entryRepository.getRandomEntries(testSize);
        int score = 0;
        for (Entry entry : randomEntries) {
            writer.println(String.format("Podaj tłumaczenie dla :\"%s\"\n", entry.getOriginal()));
            String translation = scanner.nextLine();
            if(entry.getTranslation().equalsIgnoreCase(translation)) {
                writer.println("Odpowiedź poprawna");
                score++;
            } else {
                writer.println("Odpowiedź niepoprawna - " + entry.getTranslation());
            }
        }
        writer.println(String.format("Twój wynik: %d/%d\n", score, testSize));
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
        writer.println("0 - Dodaj frazę");
        writer.println("1 - Test");
        writer.println("2 - Koniec programu");
    }

    private int chooseOption() {
        int option;
        try {
            option = scanner.nextInt();
        } catch(InputMismatchException e) {
            option = UNDEFINED;
        } finally {
            scanner.nextLine();
        }
        if(option > UNDEFINED && option <= CLOSE_APP)
            return option;
        else
            return UNDEFINED;
    }
}
