package com.example.programowanie2.cwiczenia.zaliczenia.zad15_pliki_liczby;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class Zadanie_15 {
    public static void main(String[] args) {
        new PlikiTekstowe().run();
    }
}


class PlikiTekstowe {
    void run() {
        Writer writer = new Writer();
        MyRandomIntArray randomInts = new MyRandomIntArray(1000, -5000, 5000);
        writer.writeArrayToFile(randomInts.getAll(), "liczby_wszystkie.txt");
        writer.writeArrayToFile(randomInts.getIntsLessThenAverage(), "liczby_mniejsze.txt");
        writer.writeArrayToFile(randomInts.getIntsGreaterThenAverage(), "liczby_wieksze.txt");
    }
}


class MyRandomIntArray {
    private final int[] array;

    MyRandomIntArray(int size, int from, int to) {
        this.array = new Random().ints(size, from, to + 1).toArray();
    }

    int[] getAll() {
        return array;
    }

    int[] getIntsLessThenAverage() {
        double average = average();
        return Arrays.stream(array)
                .filter(el -> el < average)
                .toArray();
    }

    int[] getIntsGreaterThenAverage() {
        double average = average();
        return Arrays.stream(array)
                .filter(el -> el > average)
                .toArray();
    }

    private double average() {
        return Arrays.stream(array)
                .average()
                .orElse(0.0);
    }
}


class Writer {
    void writeArrayToFile(int[] array, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            Arrays.stream(array).forEach(writer::println);
            System.out.println("Tablica została zapisana do pliku " + fileName);
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisu: " + e.getMessage());
        }
    }
}