import java.util.Scanner;

public class Game {
    private static final String NEXT_GAME = "1";
    private static final String END_GAME = "2";
    private final Scanner scanner = new Scanner(System.in);
    private final WordsDatabase db = new WordsDatabase();



    private static String unchangedWord;
    private static String originWord;
    private static String copyOfWord;
    private static String regex;
    private static String option;
    private static int lives = 8;

    public void mainLoop() {
        do {
            play();
            showOptions();
            chooseOption();
        } while (NEXT_GAME.equals(option));
        exit();
    }

    private void play() {
        setDefaultSettings();

        while(copyOfWord.contains("*")) {
            System.out.println("Hasło do zgadnięcia:");
            System.out.println(copyOfWord);
            System.out.println("Życia: " + lives);
            System.out.println("Podaj literę:");
            String letter = scanner.nextLine();
            System.out.println();
            if (letter.length() > 1) {
                System.out.println("Wpisz tylko jedną literę! Spróbuj jeszcze raz!");
                continue;
            }
            if (originWord.contains(letter)) {
                copyOfWord = unHideLetterInWord(originWord, letter);
            } else {
                lives--;
                if (lives == 0) break;
            }
        }
        checkGameStatus();
        System.out.println();
    }

    private void chooseOption() {
        while (true) {
            option = scanner.nextLine();
            switch (option) {
                case NEXT_GAME:
                case END_GAME:
                    return;
                default: {
                    System.out.println("Nie ma takiej opcji. Spróbuj jeszcze raz!");
                    showOptions();
                }
            }
        }
    }

    private void setDefaultSettings() {
        lives = 8;
        regex = "^ *";
        unchangedWord = db.getRandomWord();
        originWord = unchangedWord;
        copyOfWord = hideLetterInWord(originWord, "[\\S+]");
    }

    private void checkGameStatus() {
        if (copyOfWord.contains("*") || lives == 0) {
            failure();
        } else {
            win();
        }
    }

    private void failure() {
        System.out.println("Przegrałeś!");
        System.out.println("Hasło: " + unchangedWord);
    }

    private void win() {
        System.out.println("Wygrałeś");
        System.out.println("Hasło: " + unchangedWord);
    }

    private String unHideLetterInWord(String word, String letterToUnhide) {
        updateRegex(letterToUnhide);
        String reg = String.format("[%s]", regex);
        return word.replaceAll(reg, "*");
    }

    private void updateRegex(String letter) {
        regex += letter;
    }

    private String hideLetterInWord(String word, String letterToHide) {
        return word.replaceAll(letterToHide, "*");
    }

    private void showOptions() {
        System.out.println("""
                1 - Graj dalej
                2 - Koniec programu
                """);
    }

    private static void exit() {
        System.out.println("Bye bye!");
    }
}
