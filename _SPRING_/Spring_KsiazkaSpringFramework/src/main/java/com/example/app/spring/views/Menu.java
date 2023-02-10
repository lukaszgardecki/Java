package com.example.app.spring.views;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Component
public class Menu {
    private final String filePath = "src/main/resources/static/menu.txt";
    private final File file = new File(filePath);

    public void printMenu() {
        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
