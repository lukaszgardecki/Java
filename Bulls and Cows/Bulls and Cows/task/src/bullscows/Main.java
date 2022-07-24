package bullscows;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Character> tab = new ArrayList<>();
    static long pseudoRandomNumber = System.nanoTime();
    static StringBuilder randy = new StringBuilder(Long.toString(pseudoRandomNumber));
    static StringBuilder secretCode = new StringBuilder();
    static int index = 0;
    static boolean isGuessed = false;
    static int numOfTurn = 1;
    public static int len = 0;

    public static void main(String[] args) {
        createSecretCode();
        //System.out.println(secretCode);
        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n", numOfTurn);
            isGuessed = tryToGuess();
            numOfTurn++;
        } while (!isGuessed);

    }

    public static void createSecretCode() {
        System.out.println("Please, enter the secret code's length:");
        len = scanner.nextInt();

        if (len <= 10 && len > 0) {
            //odwrócenie liczby
            randy.reverse();

            //usuniêcie zer z pocz¹tku liczby
            while (Character.getNumericValue(randy.charAt(0)) == 0) {
                randy.deleteCharAt(0);
            }

            //stworzenie listy wartoœci unikatowych
            for (int i = 0; i < 10; i++) {
                tab.add((Integer.toString(i).charAt(0)));
            }

            //stworzenie liczby losowej
            while (secretCode.length() < len) {
                boolean isQnique = false;

                for (int i = 0; i < tab.size(); i++) {
                    if (randy.charAt(0) == tab.get(i)) {
                        isQnique = true;
                        index = i;
                        break;
                    }
                }

                if (isQnique) {
                    secretCode.append(randy.charAt(0));
                    tab.remove(tab.get(index));
                    randy.deleteCharAt(0);
                } else {
                    randy.deleteCharAt(0);
                }
            }

            //System.out.printf("The random secret number is %s.", secretCode);

        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", len);
        }
    }

    public static boolean tryToGuess() {
        boolean answer = false;
        int bullsCounter = 0;
        int cowsCounter = 0;
        String num = scanner.nextLine();

        for (int i = 0; i < secretCode.length(); i++) {
            for (int j = 0; j < num.length(); j++) {
                boolean isBull =  num.charAt(i) == secretCode.charAt(i) ;
                boolean isCow = num.charAt(j) == secretCode.charAt(i);

                if (isBull) {
                    bullsCounter++;
                    break;
                }
                if (isCow) {
                    cowsCounter++;
                    break;
                }
            }
        }
        if (bullsCounter == 1 && cowsCounter == 1) {
            System.out.printf("Grade: %d bull and %d cow.\n", bullsCounter, cowsCounter);
        } else if (bullsCounter == 1 && cowsCounter > 1) {
            System.out.printf("Grade: %d bull and %d cows.\n", bullsCounter, cowsCounter);
        } else if (bullsCounter > 1 && cowsCounter == 1) {
        System.out.printf("Grade: %d bulls and %d cow.\n", bullsCounter, cowsCounter);
        } else if (bullsCounter > 1 && cowsCounter > 1) {
            System.out.printf("Grade: %d bulls and %d cows.\n", bullsCounter, cowsCounter);
        } else if (cowsCounter == 1) {
            System.out.printf("Grade: %d cow.\n", cowsCounter);
        }
        else if (cowsCounter > 1) {
            System.out.printf("Grade: %d cows.\n", cowsCounter);
        }
        else if (bullsCounter == 1) {
            System.out.printf("Grade: %d bull.\n", bullsCounter);
        }
        else if (bullsCounter == len) {
            answer = true;
            System.out.printf("Grade: %d bulls.\nCongratulations! You guessed the secret code.\n", bullsCounter);
        } else if (bullsCounter > 1) {
            System.out.printf("Grade: %d bulls.\n", bullsCounter);
        } else {
            System.out.println("Grade: None.");
        }
        return answer;
    }


}
