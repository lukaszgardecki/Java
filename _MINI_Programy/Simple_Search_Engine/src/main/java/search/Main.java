package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static ArrayList<String> peopleList = new ArrayList<>();
    static SortedMap<String, ArrayList<Integer>> invertedIndexMap = new TreeMap<>();
    static SortedSet<String> set = new TreeSet<>();

    public static void main(String[] args) {
        readFile(args);
        createInvertedIndex();
        play();
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            String choice = scanner.nextLine().toLowerCase();
            switch (choice) {
                case "0":
                    System.out.println("\nBye!");
                    return;
                case "1":
                    System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
                    String choice2 = scanner.nextLine().toLowerCase();
                    switch(choice2) {
                        case "all":
                            all();
                            break;
                        case "any":
                            any();
                            break;
                        case "none":
                            none();
                            break;
                        default:
                            System.out.println("\nIncorrect option! Try again!");
                    }
                    break;
                case "2":
                    printAllPeople();
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again!");
            }
        }
    }

    //wyúwietl menu
    public static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    //wyúwietla tylko te pozycje, ktÛre zawierajπ wszystkie wprowadzone s≥owa
    public static void all() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter a name or email to search all suitable people.");
            String searchFor = scanner.nextLine().toLowerCase();

        // ------   WERSJA 2 - ZNAJDè TYLKO TE POZYCJE, KT”RE POSIADAJ• WSZYSTKIE WPROWADZONE S£OWA
        for (String el : peopleList) {
            if (el.toLowerCase().contains(searchFor)) {
                    set.add(el);
            }
        }

        if (set.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.printf("\n%d persons found:\n", set.size());
            set.forEach(System.out::println);
        }
        set.clear();
    }

    //wyúwietl wszystkie osoby (ca≥π zawartoúÊ pliku.txt)
    public static void printAllPeople() {
        System.out.println("\n=== List of people ===");
        for(String el : peopleList) {
            System.out.println(el);
        }
    }

    //czytanie pliku tekstowego z argumentÛw programu
    public static void readFile(String[] args) {
        String importPath = "";
        //int counter = 0;

        for(int i = 0; i < args.length; i += 2) {
            if (args[i].equals("--data")) {
                importPath = args[i+1];
            }
        }

        File file = new File(importPath);
        try (Scanner importScanner = new Scanner(file)) {
            while (importScanner.hasNextLine()) {
                peopleList.add(importScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    //stworzenie Inverted Index
    public static void createInvertedIndex() {
        for (int i = 0; i < peopleList.size(); i++) {
            String[] temp = peopleList.get(i).trim().split("\\s+");

            for (String s : temp) {

                String el = s.toLowerCase();

                if (invertedIndexMap.containsKey(el)) {
                    //pojedyncza lista wystπpieÒ dla konkretnego s≥owa
                    ArrayList<Integer> li = invertedIndexMap.get(el);
                    li.add(i);
                    invertedIndexMap.replace(el, li);
                } else {
                    ArrayList<Integer> li2 = new ArrayList<>();
                    li2.add(i);
                    invertedIndexMap.putIfAbsent(el, li2);
                }
            }
        }
    }

    //wyúwietlanie pozycji, ktÛre ZAWIERAJ• PRZYNAJMNIEJ JEDNO wprowadzone s≥owo
    public static void any() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");
        //String searchFor = scanner.nextLine().toLowerCase();
        String[] searchTab = scanner.nextLine().toLowerCase().split("\\s+");

        // ------   WERSJA 1 - ODNAJDYWANIE NAWET JEDNEGO ZNAKU
        for (Map.Entry<String, ArrayList<Integer>> el : invertedIndexMap.entrySet()) {
            for (String n : searchTab) {
                if (el.getKey().equals(n)) {
                    //counter += el.getValue().size();

                    for (int i = 0; i < el.getValue().size(); i++) {
                        int indexOfPeople = el.getValue().get(i);
                        String human = peopleList.get(indexOfPeople);
                        set.add(human);
                    }
                }
            }
        }

        if (set.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.printf("\n%d persons found:\n", set.size());
            set.forEach(System.out::println);
        }
        set.clear();
    }

    //wyúwietlanie pozycji, ktÛre NIE ZAWIERAJ• wprowadzonych s≥Ûw
    public static void none() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");
        String[] searchTab = scanner.nextLine().toLowerCase().split("\\s+");

        // ------   WERSJA 1 - ODNAJDYWANIE NAWET JEDNEGO ZNAKU
        for (String el : peopleList) {
            boolean isNone = true;
            for (String n : searchTab) {
                if (el.toLowerCase().contains(n)) {
                    isNone = false;
                    break;
                }
            }
            if(isNone) {
                    set.add(el);
            }
        }

        if (set.size() == 0) {
            System.out.println("No matching people found.");
        } else {
            System.out.printf("\n%d persons found:\n", set.size());
            set.forEach(System.out::println);
        }
        set.clear();
    }
}
