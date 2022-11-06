package Zad_77_Strumienie3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Zadanie {
    public static void main(String[] args) {
        File file = new File("src/Zad_77_Strumienie3/plik.txt");
        List<String> words = createWordsListFrom(file);
        words = ridOfSignsFromList("[.,]", words);
        long wordsStartFrom = getWordsStartFrom("s", words);
        long wordsOfLength = getWordsOfLength(5, words);


        System.out.println("Liczba s³ów rozpoczynaj¹ca siê od litery \"s\" to: " + wordsStartFrom);
        System.out.println("Liczba s³ów sk³adaj¹cych siê z 5 znaków to: " + wordsOfLength);
    }

    private static List<String> ridOfSignsFromList(String regex, List<String> words) {
        return words.stream()
                .map(word -> word.replaceAll(regex, ""))
                .collect(Collectors.toList());

    }

    private static List<String> createWordsListFrom(File file) {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines()
                    .map(line -> line.split(" "))
                    .forEach(tab -> words.addAll(List.of(tab)));
        } catch (IOException e) {
            System.out.println("B³¹d.");
        }
        return words;
    }

    private static long getWordsOfLength(int length, List<String> words) {
        return words.stream()
                .map(ridOfSigns("[.,:;!?]"))
                .filter(wordsOfLength(length))
                .count();
    }

    private static long getWordsStartFrom(String sign, List<String> words) {
        return words.stream()
                .map(ridOfSigns("[.,:;!?]"))
                .filter(wordsStartWith(sign))
                .count();
    }

    private static Predicate<String> wordsStartWith(String sign) {
        return word -> word.startsWith(sign);
    }

    private static Predicate<String> wordsOfLength(int length) {
        return word -> word.length() == length;
    }

    private static Function<String, String> ridOfSigns(String regex) {
        return word -> word.replaceAll(regex, "");
    }


}
