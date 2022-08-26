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
    //private static String path = "F:\\1. S  T  U  D  I  A\\Æwiczenia z programowania\\Java\\Readability Score\\Readability Score\\task\\src\\readability\\text.txt";

    public static void main(String[] args) {
        String path = args[0];
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
                String[] sentTab = line.split("[.!?]+\\s");
                characters += sentTab.length-1;
                sentences += sentTab.length;
                for (String s : sentTab) {
                    String[] wordsTab = s.split("\\s+");
                    words += wordsTab.length;
                    for (String w : wordsTab) {
                        int vovel = 0;
                        characters += w.length();

                        /* ----- find amount of syllables ----- */
                        w = w.replaceAll("e\\b", "")
                                .replaceAll("[Yy]ou", "a")
                                .replaceAll("[aeiouyAEIOUY]{2}", "a")
                                .replaceAll(" th "," a ")
                                .replaceAll(",","")
                                .replaceAll(" w "," a ")
                                .replaceAll("\\d+", "a")
                                .replaceAll("[^aeiouyAEIOUY]", "");

                        for (int k = 0; k < w.length(); k++) {
                            String c = Character.toString(w.charAt(k)).toLowerCase();
                            if (c.matches("[aeiouy]")) vovel++;
                        }

                        if (vovel == 0) syllables++;
                        if (vovel > 2) polysyllables++;
                        syllables += vovel;
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
            case 0:
                age = "5"; break;
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
            default:
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
    public static void printScores(String scoreType) {
        String ariAge = getAge((int) Math.ceil(getARI()));
        String fkAge = getAge((int) Math.ceil(getFleschKincaid()));
        String smogAge = getAge((int) Math.ceil(getSmog()));
        String clAge = getAge((int) Math.ceil(getColemanLiau()));
        int a = Integer.parseInt(ariAge);
        int f = Integer.parseInt(fkAge);
        int s = Integer.parseInt(smogAge);
        int c = Integer.parseInt(clAge);
        double average = (double) (a + f + s + c) / 4;
        String av = String.format("%.2f", average);

        System.out.println();
        switch (scoreType) {
            case "ari":
                System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).\n",
                        getARI(), ariAge);
                break;
            case "fk":
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n",
                        getFleschKincaid(), fkAge);
                break;
            case "smog":
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n",
                        getSmog(), smogAge);
                break;
            case "cl":
                System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n", getColemanLiau(),
                        clAge);
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f (about %s-year-olds).\n",
                        getARI(), ariAge);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s-year-olds).\n",
                        getFleschKincaid(), fkAge);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s-year-olds).\n",
                        getSmog(), smogAge);
                System.out.printf("Coleman–Liau index: %.2f (about %s-year-olds).\n",
                        getColemanLiau(), clAge);
                break;
        }
        System.out.println();
        System.out.printf("This text should be understood in average by %s-year-olds", av);
    }
}
