package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static double words = 0;
    private static double characters = 0;
    private static double sentences = 0;
    private static double syllables = 0;
    private static double polysyllables = 0;
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<String> textList = new ArrayList<>();
    private static String path = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Readability Score\\Readability Score\\task\\src\\readability\\text.txt";
    //private static String path = args[0];







    public static void main(String[] args) {
        readTextFile(path);

        System.out.println("The text is:");
        textList.forEach(System.out::println);

        System.out.printf("Words: %.0f\n", words);
        System.out.printf("Sentences: %.0f\n", sentences);
        System.out.printf("Characters: %.0f\n", characters);
        System.out.printf("Syllables: %.0f\n", syllables);
        System.out.printf("Polysyllables: %.0f\n", polysyllables);

        System.out.print("\nEnter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String scoreType = scanner.nextLine().toLowerCase();

        printScores(scoreType);
    }






    public static void readTextFile(String path) {
        File input = new File(path);

        try (Scanner inputSc = new Scanner(input)) {
            while (inputSc.hasNextLine()) {
                String line = inputSc.nextLine();
                textList.add(line);
                String[] sentTab = line.split("[.!?]\\s+");
                characters += sentTab.length-1;
                sentences += sentTab.length;
                for (String s : sentTab) {
                    String[] wordsTab = s.split("\\s+");
                    words += wordsTab.length;
                    for (String w : wordsTab) {
                        characters += w.length();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static String getAge(int score) {
        String age = "";
        switch (score) {
            case 1:
                age = "6"; break;
            case 2:
                age = "7"; break;
            case 3:
                age = "8"; break;
            case 4:
                age = "9"; break;
            case 5:
                age = "10"; break;
            case 6:
                age = "11"; break;
            case 7:
                age = "12"; break;
            case 8:
                age = "13"; break;
            case 9:
                age = "14"; break;
            case 10:
                age = "15"; break;
            case 11:
                age = "16"; break;
            case 12:
                age = "17"; break;
            case 13:
                age = "18"; break;
            case 14:
                age = "22"; break;
        }
        return age;
    }
    public static double getARI() {
        return 4.71 * (characters/words) + 0.5 * (words/sentences) - 21.43;
    }
    public static double getFleschKincaid() {
        return 0.39 * (words/sentences) + 11.8 * (syllables/words) - 15.59;
    }
    public static double getSmog() {
        return 1.043 *(Math.sqrt(polysyllables*(30/sentences))) + 3.1291;
    }
    public static double getColemanLiau() {
        double L = characters / words * 100;
        double S = sentences / words * 100;
        return 0.0588 * L - 0.296 * S - 15.8;
    }
    public static double countAverage() {

    }
    public static void printScores(String scoreType) {
        System.out.println();
        switch (scoreType) {
            case "ari":
                System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).\n",
                        getARI(), getAge((int) Math.ceil(getARI())));
                break;
            case "fk":
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n",
                        getFleschKincaid(), getAge((int) Math.ceil(getARI())));
                break;
            case "smog":
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n",
                        getSmog(), getAge((int) Math.ceil(getARI())));
                break;
            case "cl":
                System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n", getColemanLiau(),
                        getAge((int) Math.ceil(getARI())));
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).\n",
                        getARI(), getAge((int) Math.ceil(getARI())));
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n",
                        getFleschKincaid(), getAge((int) Math.ceil(getARI())));
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n",
                        getSmog(), getAge((int) Math.ceil(getARI())));
                System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n",
                        getColemanLiau(), getAge((int) Math.ceil(getARI())));
                break;
        }
        System.out.println();

        // System.out.printf("The score is: %.2f\n", score);
        System.out.printf("This text should be understood in average by %s-year-olds", age);
    }
}
