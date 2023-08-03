package bullscows;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static StringBuilder secretCode = new StringBuilder();
    static boolean isGuessed = false;
    static char firstLetter = 'a';
    static char lastLetter = 97;
    static int numOfTurn = 1;
    public static int len = 0;
    public static int amountOfSigns = 0;
    static final int MAX_LENGTH = 36;


    public static void main(String[] args) {
        createSecretCode();
       // System.out.println(secretCode);

        if (amountOfSigns != 0 && len != 0 && len <= amountOfSigns && amountOfSigns <= MAX_LENGTH) {
            System.out.println("Okay, let's start a game!");
            do {
                System.out.printf("Turn %d:\n", numOfTurn);
                isGuessed = tryToGuess();
                numOfTurn++;
            } while (!isGuessed);
        }

    }

    public static void createSecretCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");

        try {
            len = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Error");
            return;
        }

        try {
            System.out.println("Input the number of possible symbols in the code:");
            amountOfSigns = Integer.parseInt(scanner.nextLine());
            if (amountOfSigns > MAX_LENGTH || amountOfSigns < len) {
                System.out.printf("Error: maximum number of possible symbols in the code is %d (0-9, a-z).\n", MAX_LENGTH);
            } else {
                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", len, amountOfSigns);
            }

        } catch (NumberFormatException e) {
            amountOfSigns = MAX_LENGTH;
        }
        ArrayList<String> list = new ArrayList<>(len);

//        while (amountOfSigns > MAX_LENGTH || amountOfSigns < len) {
//            if (amountOfSigns > MAX_LENGTH) {
//                System.out.printf("Error: maximum number of possible symbols in the code is %d (0-9, a-z).\n", MAX_LENGTH);
//            } else {
//                System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", len, amountOfSigns);
//            }
//            System.out.println("\nInput the number of possible symbols in the code:");
//            amountOfSigns = scanner.nextInt();
//        }



        //stworzenie listy z wymaganymi
        if(amountOfSigns <= 10){
            for (int i = 0; i < amountOfSigns; i++) {
                String x = "";
                list.add(x + i);
            }
        } else {
            int numOfDigits = 10;
            int numOfLetters = amountOfSigns - numOfDigits;
            lastLetter += numOfLetters;

            for (int i = 0; i < numOfDigits; i++) {
                String x = "";
                list.add(x + i);
            }
            for (char ch = 'a'; ch < lastLetter; ch++) {
                list.add(Character.toString(ch));
            }
        }

        //stworzenie gwiazdek *****
        StringBuilder star = new StringBuilder();
        for (int i = 0; i < len; i++){
            star.append('*');
        }

        if (len <= MAX_LENGTH && len > 0 && amountOfSigns > 0 && len <= amountOfSigns) {
            //stworzenie liczby losowej UNIKATOWEJ
            while (secretCode.length() < len) {
                Random random = new Random();
                int randomIndex = random.nextInt(list.size());
                secretCode.append(list.get(randomIndex));
                list.remove(randomIndex);
            }

            if (amountOfSigns == 0) {
                System.out.printf("The secret is prepared: %s\n", star);
            } else if (amountOfSigns <= 10) {
                System.out.printf("The secret is prepared: %s (0-%d)\n", star, amountOfSigns-1);
            } else {
                System.out.printf("The secret is prepared: %s (0-9, %c-%c)\n", star, firstLetter, lastLetter-1);
            }
        } else {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.", len);
        }


    }

    public static boolean tryToGuess() {
        Scanner scanner = new Scanner(System.in);
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
        else if (bullsCounter == 1 && bullsCounter != len) {
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
