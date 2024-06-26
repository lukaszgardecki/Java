package com.example.zad_7a_wlasnosci_plikiproperties.producer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@Service
@Profile("file")
class FileMessageProducer implements MessageProducer {

    @Override
    public String getMessage() {
        Path path = getPath();
        try {
             return String.join(" ", Files.readAllLines(path));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    private Path getPath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę pliku z komunikatem do odczytania:");
        String fileName = scanner.nextLine();
        return Path.of(fileName);
    }
}
