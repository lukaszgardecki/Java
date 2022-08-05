package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static ArrayList<String> resultList = new ArrayList<>();
    static ArrayList<String> peopleList = new ArrayList<>();
    static SortedMap<String, ArrayList<Integer>> invertedIndexMap = new TreeMap<>();



    public static void main(String[] args) {
        readFile(args);
        createInvertedIndex();
        play();
    }

    public static void play() {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter the number of people:");
//        int amount = scanner.nextInt();
//        scanner.nextLine();
//        peopleTab = new String[amount];
//
//        System.out.println("Enter all people:");
//        for(int i = 0; i < amount; i++) {
//            peopleTab[i] = scanner.nextLine();
//        }

        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "0":
                    System.out.println("\nBye!");
                    return;
                case "1":
                    findPerson();
                    break;
                case "2":
                    printAllPeople();
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again!");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    public static void findPerson() {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("\nEnter the number of search queries:");
        //int howManyQueries = scanner.nextInt();
        //scanner.nextLine();

        //for (int i = 0; i < howManyQueries; i++) {

            //System.out.println("\nEnter data to search poeple:");
            System.out.println("\nEnter a name or email to search all suitable people.");
            String searchFor = scanner.nextLine().toLowerCase();

            for (String el : peopleList) {
                if (el.toLowerCase().contains(searchFor)) {
                    resultList.add(el);

                }
            }

            if (resultList.size() == 0) {
                System.out.println("No matching people found.");
            } else {
                //System.out.println("\nFound people:");


                // TUTAJ TRZEBA ZMIENIÆ SEARCH FOR ¯EBY W MAPIE NIE SZUKAÆ PO TYM SO SIÊ WPISZE
                //DLA ZNAKU @ NPE
                // JEST KILKA WYNIKÓW NIE JEDEN
                int amount = invertedIndexMap.get(searchFor).size();




                System.out.printf("\n%d persons found:\n", amount);

                resultList.forEach(System.out::println);
            }
            resultList.clear();
        //}
    }

    public static void printAllPeople() {
        System.out.println("\n=== List of people ===");
        for(String el : peopleList) {
            System.out.println(el);
        }
    }

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

    public static void createInvertedIndex() {
        for (int i = 0; i < peopleList.size(); i++) {
            String[] temp = peopleList.get(i).split("\\s+");

            for (int k = 0; k < temp.length; k++) {

                String el = temp[k].toLowerCase();

                if(invertedIndexMap.containsKey(el)) {
                    //pojedyncza lista wyst¹pieñ dla konkretnego s³owa
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

        //System.out.println(invertedIndexMap);
    }

}
