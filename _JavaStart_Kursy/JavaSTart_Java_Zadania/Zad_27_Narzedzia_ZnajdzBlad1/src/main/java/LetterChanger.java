import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Poniżej znajdziesz kod aplikacji, która została napisana przez nieuważnego programistę. Jej celem z założenia jest:
 *
 *     wczytanie od użytkownika liczby,
 *     wczytanie od użytkownika do tablicy tylu napisów, ile podał w punkcie 1,
 *     wczytanie napisu "lower" lub "upper" i na tej podstawie zamiana wszystkich napisów w tablicy na małe lub wielkie litery,
 *     wyświetlenie wszystkich przekształconych napisów jeden pod drugim w konsoli.
 */

class LetterChanger {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfWords = getNumberOfWords();
        String[] words = readWords(numberOfWords);
        String change = readChangeString();

        switch (change.toLowerCase()) {
            case "upper" -> changeWordsToUpperCase(words);
            case "lower" -> changeWordsToLowerCase(words);
            default -> System.out.println("Nieprawidłowy tekst, zostawiam oryginalny tekst");
        }
        printArray(words);
    }

    private static String readChangeString() {
        System.out.println("Chcesz zamienić na małe (lower), czy wielkie litery (upper)?");
        String op;
        do {
            op = scanner.nextLine();
            switch (op.toLowerCase()) {
                case "lower":
                case "upper": break;
                default:
                    op = null;
                    System.out.println("Niepoprawna opcja. Spróbuj ponownie.");
            }
        } while (op == null);
        return op;
    }

    private static void printArray(String[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void changeWordsToLowerCase(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toLowerCase();
        }
    }

    private static void changeWordsToUpperCase(String[] words) {
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toUpperCase();
        }
    }

    private static String[] readWords(int size) {
        String[] result = new String[size];
        for (int i = 0; i < result.length; i++) {
            System.out.println("Podaj wyraz numer " + (i+1));
            result[i] = scanner.nextLine();
        }
        return result;
    }

    private static int getNumberOfWords() {
        System.out.println("Ile wyrazów chcesz wczytać?");
        Integer num = null;
        do {
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wpisz liczbę! Spróbuj jeszcze raz!");
            }
            scanner.nextLine();
        } while (num == null);
        return num;
    }
}