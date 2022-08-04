package flashcards;
import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> map = new LinkedHashMap<>();
    static ArrayList<String> logList = new ArrayList<>();

    public static void main(String[] args) {
        play();
    }




    public static void play() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(displayMessage(1));
            logList.add(displayMessage(1));
            String action = scanner.nextLine().toLowerCase();
            logList.add(action);

            try {
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
                    case "log":
                        log();
                        break;
                    case "hardest card":
                        showHardestCard();
                        break;
                    case "reset stats":
                        resetStats();
                        break;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println(displayMessage(2));
                logList.add(displayMessage(2));
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
            System.out.println(displayMessage(3));
            logList.add(displayMessage(3));



            //while(true) {
                term = scanner.nextLine();
                logList.add(term);
                boolean isTermExist = map.containsKey(term);
                if (isTermExist) {
                    System.out.println(displayMessage(4, term));
                    logList.add(displayMessage(4, term));
                    return;
                } //else {
                   // break;
                //}
            //}

            //wpisanie jego definicji
            System.out.println(displayMessage(5));
            logList.add(displayMessage(5));

            //while(true) {
                definition = scanner.nextLine();
                logList.add(definition);

                boolean isDefExist = map.containsValue(definition);
                if (isDefExist) {
                    System.out.println(displayMessage(6, definition));
                    logList.add(displayMessage(6, definition));
                    return;
                }// else {
                   // break;
                //}
            //}
            System.out.println(displayMessage(7, term, definition));
            logList.add(displayMessage(7, term, definition));
            map.put(term, definition);
        //}
    }
    public static void removeCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(displayMessage(8));
        logList.add(displayMessage(8));
        String remC = scanner.nextLine();
        logList.add(remC);
        int amountOfEl = map.size();

        for (Map.Entry<String, String> el : map.entrySet()) {
            if (el.getKey().equals(remC)) {
                map.remove(el.getKey(), el.getValue());
                break;
            }
        }
        // je¿eli usuniêto / lub nie to wyœwietl komunikat
        if (map.size() == amountOfEl - 1) {
            System.out.println(displayMessage(9));
            logList.add(displayMessage(9));
        } else {
            System.out.println(displayMessage(10, remC));
            logList.add(displayMessage(10, remC));
        }
    }
    public static void importCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(displayMessage(11));
        logList.add(displayMessage(11));

        String inputPath = scanner.nextLine();
        logList.add(inputPath);
        int counter = 0;

        File file = new File(inputPath);

        try (Scanner inputScanner = new Scanner(file)) {
            while (inputScanner.hasNextLine()) {
                String a = inputScanner.nextLine();
                String b = inputScanner.nextLine();

                map.put(a, b);
                counter++;
            }
            System.out.println(displayMessage(12, String.valueOf(counter)));
            logList.add(displayMessage(12, String.valueOf(counter)));
        } catch (FileNotFoundException e) {
            System.out.println(displayMessage(13));
            logList.add(displayMessage(13));
        }
    }
    public static void exportCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(displayMessage(11));
        logList.add(displayMessage(11));
        String exportPath = scanner.nextLine();
        logList.add(exportPath);
        File file = new File(exportPath);
        int counter = map.size();

        //System.out.println(map);

        try (FileWriter writer = new FileWriter(file)) {

            for (Map.Entry<String, String> el : map.entrySet()) {
                String term = el.getKey();
                String definition = el.getValue();

                //System.out.println(term + definition);

                //writer.write("chuj chuj chuj chuj");
                writer.write(term + "\n");
                writer.write(definition + "\n");
            }
            writer.close();
            System.out.println(displayMessage(14, String.valueOf(counter)));
            logList.add(displayMessage(14, String.valueOf(counter)));
        } catch (IOException e) {
            System.out.println(displayMessage(13));
            logList.add(displayMessage(13));
            //System.out.println(path);
        }
    }


    public static void ask() {
        Scanner scanner = new Scanner(System.in);
        //zgadywanie definicji
        int counter = 0;

        System.out.println(displayMessage(15));
        logList.add(displayMessage(15));
        int amount = scanner.nextInt();
        logList.add(String.valueOf(amount));
        scanner.nextLine();


        while (counter < amount) {
            for (Map.Entry<String, String> el : map.entrySet()) {
                String term = el.getKey();
                String definition = el.getValue();


                System.out.println(displayMessage(16, term));
                logList.add(displayMessage(16, term));
                String answer = scanner.nextLine();
                logList.add(answer);

                if (definition.equals(answer)) {
                    System.out.println(displayMessage(17));
                    logList.add(displayMessage(17));

                } else if (map.containsValue(answer)) {
                    System.out.println(displayMessage(18, definition, getKeybyValue(map, answer)));
                    logList.add(displayMessage(18, definition, getKeybyValue(map, answer)));
                } else {
                    System.out.println(displayMessage(19, definition));
                    logList.add(displayMessage(19, definition));
                }

                counter++;
                if(counter == amount) break;
            }

        }
    }

    public static void exit() {
        System.out.println(displayMessage(20));
        logList.add(displayMessage(20));
    }

    public static void log() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(displayMessage(11));
        logList.add(displayMessage(11));

        String outputPath = scanner.nextLine();
        logList.add(outputPath);
        File outputFile = new File(outputPath);

        try (FileWriter outputWriter = new FileWriter(outputFile)) {

            for (String el : logList) {
                outputWriter.write(el + "\n");
            }
            outputWriter.close();
            System.out.println(displayMessage(21));
            logList.add(displayMessage(21));

        } catch (IOException e) {
            System.out.println(displayMessage(13));
            logList.add(displayMessage(13));
        }


    }

    public static void showHardestCard() {

    }

    public static void resetStats() {

    }

    public static String displayMessage(int num) {
        String msg = "";
        switch (num) {
            case 1:
                msg = "\nInput the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):";
                break;
            case 2:
                msg = "Error. Try again!";
                break;
            case 3:
                msg = "The card:";
                break;
            case 5:
                msg = "The definition of the card:";
                break;
            case 8:
                msg = "Which card?";
                break;
            case 9:
                msg = "The card has been removed.";
                break;
            case 11:
                msg = "File name:";
                break;
            case 13:
                msg = "File not found.";
                break;
            case 15:
                msg = "How many times to ask?";
                break;
            case 17:
                msg = "Correct!";
                break;
            case 20:
                msg = "Bye Bye!";
                break;
            case 21:
                msg = "The log has been saved.";
                break;
        }
        return msg;
    }
    public static String displayMessage(int num, String val1) {
        String msg = "";
        switch (num) {
            case 4:
                msg = String.format("The card \"%s\" already exists.", val1);
                break;
            case 6:
                msg = String.format("The definition \"%s\" already exists.", val1);
                break;
            case 10:
                msg = String.format("Can't remove \"%s\": there is no such card.", val1);
                break;
            case 12:
                msg = String.format("%s cards have been loaded.", val1);
                break;
            case 14:
                msg = String.format("%s cards have been saved.", val1);
                break;
            case 16:
                msg = String.format("Print the definition of \"%s\":", val1);
                break;
            case 19:
                msg = String.format("Wrong. The right answer is \"%s\".", val1);
                break;
        }
        return msg;
    }
    public static String displayMessage(int num, String val1, String val2) {
        String msg = "";
        switch (num) {
            case 7:
                msg = String.format("The pair (\"%s\":\"%s\") has been added.", val1, val2);
                break;
            case 18:
                msg = String.format("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\".", val1, val2);
                break;
        }
        return msg;
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
