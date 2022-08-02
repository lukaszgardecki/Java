package flashcards;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the number of cards:");
        int amount = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> definitionList = new ArrayList<>();
        ArrayList<String> cardsList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            int num = i + 1;

            System.out.printf("Card #%d:\n", num);
            String cardName = scanner.nextLine();
            cardsList.add(cardName);

            System.out.printf("The definition for card #%d:\n", num);
            String definition = scanner.nextLine();
            definitionList.add(definition);
        }

        for (int i = 0; i < definitionList.size(); i++) {
            String name = cardsList.get(i);
            String definition = definitionList.get(i);

            System.out.printf("Print the definition of \"%s\":\n", name);
            String answer = scanner.nextLine();
            if (definition.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.printf("Wrong. The right answer is \"%s\".\n", definition);
            }

        }





    }
}
