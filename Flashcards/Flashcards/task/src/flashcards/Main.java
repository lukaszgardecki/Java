package flashcards;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static Map<String, String> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        play();
    }




    public static void play() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\nInput the action (add, remove, import, export, ask, exit):");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "add":
                    addCard();
                    break;
                case "remove":
                    removeCard();
                    break;
                case "import":
                    importCard();
                    break;
                case "export":
                    exportCard();
                    break;
                case "ask":
                    ask();
                    break;
                case "exit":
                    exit();
                    return;
            }
        }
    }

    public static void addCard() {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Input the number of cards:");
       // int amount = scanner.nextInt();
       // scanner.nextLine();


        //wprowadzanie pojêæ i definicji
       // for (int i = 0; i < amount; i++) {
            //int num = i + 1;
            String term;
            String definition;


            //wpisanie terminu
            System.out.println("The card:");
            //while(true) {
                term = scanner.nextLine();
                boolean isTermExist = map.containsKey(term);
                if (isTermExist) {
                    System.out.printf("The card \"%s\" already exists.\n", term);
                    return;
                } //else {
                   // break;
                //}
            //}

            //wpisanie jego definicji
            System.out.println("The definition of the card:");
            //while(true) {
                definition = scanner.nextLine();
                boolean isDefExist = map.containsValue(definition);
                if (isDefExist) {
                    System.out.printf("The definition \"%s\" already exists.\n", definition);
                    return;
                }// else {
                   // break;
                //}
            //}
            System.out.printf("The pair (\"%s\":\"%s\") has been added.\n", term, definition);
            map.put(term, definition);
        //}
    }
    public static void removeCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which card?");
        String remC = scanner.nextLine();

        for (Map.Entry<String, String> el : map.entrySet()) {
            if (el.getKey().equals(remC)) {
                map.remove(el);
                System.out.println("The card has been removed.");
            } else {
                System.out.printf("Can't remove \"%s\": there is no such card.\n", remC);
            }
        }
    }
    public static void importCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File name:");
        String path = scanner.next();
        int counter = 0;

        File file = new File(path);

        try (Scanner inputScanner = new Scanner(file)) {
            while (inputScanner.hasNextLine()) {
                counter++;
            }
            System.out.printf("%d cards have been loaded.\n", counter);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


    }
    public static void exportCard() {

    }

    public static void ask() {
        Scanner scanner = new Scanner(System.in);
        //zgadywanie definicji
        for (Map.Entry<String, String> el : map.entrySet()) {
            String term = el.getKey();
            String definition = el.getValue();

            System.out.printf("Print the definition of \"%s\":\n", term);
            String answer = scanner.nextLine();
            if (definition.equals(answer)) {
                System.out.println("Correct!");
            } else if (map.containsValue(answer)) {
                System.out.printf("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".\n", definition, getKeybyValue(map, answer));
            } else {
                System.out.printf("Wrong. The right answer is \"%s\".\n", definition);
            }
        }
    }

    public static void exit() {
        System.out.println("Bye Bye!");
    }



    //metoda zwracaj¹ca klucz na podstawie wartoœci
    public static String getKeybyValue(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
