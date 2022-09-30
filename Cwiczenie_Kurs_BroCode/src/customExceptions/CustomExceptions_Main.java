package customExceptions;

import java.util.Scanner;

public class CustomExceptions_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        try {
            checkAge(age);
        } catch (Exception e) {
            System.out.println("Wyst¹pi³ problem: " + e);
        }
    }

    static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("\n" + "Musisz mieæ 18 lat.");
        } else {
            System.out.println("Witamy!");
        }
    }


}
