package flashcards;
import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> cardsMap = new LinkedHashMap<>();
    static ArrayList<String> logList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPath = "";
        int counter = 0;

        for (int i = 0; i < args.length; i += 2) {
            if (args[i].equals("-import")) {
                inputPath = args[i+1];

                File file = new File(inputPath);

                try (Scanner inputScanner = new Scanner(file)) {
                    while (inputScanner.hasNextLine()) {

                        String[] abcTab = inputScanner.nextLine().split("\\t");

                        String a = abcTab[0];
                        String b = abcTab[1];

                        cardsMap.put(a, (b + "\t" + abcTab[2]));
                        counter++;
                    }
                    System.out.println(displayMessage(12, String.valueOf(counter)));
                    logList.add(displayMessage(12, String.valueOf(counter)));
                } catch (FileNotFoundException e) {
                    System.out.println(displayMessage(13));
                    logList.add(displayMessage(13));
                }

            }
        }



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
                    case "log":
                        log();
                        break;
                    case "hardest card":
                        showHardestCard();
                        break;
                    case "reset stats":
                        resetStats();
                        break;
                    case "exit":
                        String outputPath = "";

                        System.out.println(displayMessage(20));
                        logList.add(displayMessage(20));

                        for (int i = 0; i < args.length; i += 2) {
                            if (args[i].equals("-export")) {
                                File file = new File(outputPath);
                                int counter2 = cardsMap.size();

                                try (FileWriter writer = new FileWriter(file)) {

                                    for (Map.Entry<String, String> el : cardsMap.entrySet()) {
                                        String term = el.getKey();
                                        String definition = el.getValue();

                                        writer.write(term + "\t" + definition + "\n");
                                    }
                                    writer.close();
                                    System.out.println(displayMessage(14, String.valueOf(counter2)));
                                    logList.add(displayMessage(14, String.valueOf(counter2)));
                                } catch (IOException e) {
                                    //System.out.println(displayMessage(13));
                                    //logList.add(displayMessage(13));
                                }
                            }
                        }

                        return;
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println(displayMessage(2));
                logList.add(displayMessage(2));
            }


            //System.out.println(cardsMap);

        }









    }


    public static void addCard() {
        Scanner scanner = new Scanner(System.in);

        //wprowadzanie pojêæ i definicji
            String term;
            String definition;

            //wpisanie terminu
            System.out.println(displayMessage(3));
            logList.add(displayMessage(3));

            //while(true) {
                term = scanner.nextLine();
                logList.add(term);
                boolean isTermExist = cardsMap.containsKey(term);
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
                logList.add(definition + "\t" + 0);

                boolean isDefExist = false;

                for (Map.Entry<String, String> el : cardsMap.entrySet()) {
                    String[] defTab = el.getValue().split("\t");
                    if (definition.equals(defTab[0])) {
                        isDefExist = true;
                        break;
                    }
                }

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
            //dodanie do mapy kart/definicji:
            cardsMap.put(term, (definition + "\t" + 0));
        //}
    }
    public static void removeCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(displayMessage(8));
        logList.add(displayMessage(8));
        String remC = scanner.nextLine();
        logList.add(remC);
        int amountOfEl = cardsMap.size();

        for (Map.Entry<String, String> el : cardsMap.entrySet()) {
            if (el.getKey().equals(remC)) {
                cardsMap.remove(el.getKey(), el.getValue());
                break;
            }
        }
        // je¿eli usuniêto / lub nie to wyœwietl komunikat
        if (cardsMap.size() == amountOfEl - 1) {
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

                String[] abcTab = inputScanner.nextLine().split("\\t");

                String a = abcTab[0];
                String b = abcTab[1];

                cardsMap.put(a, (b + "\t" + abcTab[2]));
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
        int counter = cardsMap.size();

        try (FileWriter writer = new FileWriter(file)) {

            for (Map.Entry<String, String> el : cardsMap.entrySet()) {
                String term = el.getKey();
                String definition = el.getValue();

                writer.write(term + "\t" + definition + "\n");
            }
            writer.close();
            System.out.println(displayMessage(14, String.valueOf(counter)));
            logList.add(displayMessage(14, String.valueOf(counter)));
        } catch (IOException e) {
            System.out.println(displayMessage(13));
            logList.add(displayMessage(13));
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
            for (Map.Entry<String, String> el : cardsMap.entrySet()) {
                //termin:
                String term = el.getKey();
                //ca³a wartoœæ (definicja + iloœæ pomy³ek):
                String[] defTab = el.getValue().split("\\t");
                //definicja:
                String definition = defTab[0];
                //iloœc pomy³ek:
                int errCounter = Integer.parseInt(defTab[1]);

                System.out.println(displayMessage(16, term));
                logList.add(displayMessage(16, term));
                String answer = scanner.nextLine();
                logList.add(answer);

                //je¿eli odpowiedŸ istnieje to dla jakigo
                String anotherTerm = "";
                for (Map.Entry<String, String> x : cardsMap.entrySet()) {
                    String[] tab = x.getValue().split("\\t");
                    if (answer.equals(tab[0])) {
                        anotherTerm = getKeybyValue(cardsMap, x.getValue());
                        break;
                    }
                }




                //je¿eli dobra odpowiedŸ
                if (definition.equals(answer)) {
                    System.out.println(displayMessage(17));
                    logList.add(displayMessage(17));
                }
                //je¿eli z³a odpowiedŸ (ale dobra dla innego terminu)
                else if (cardsMap.containsKey(anotherTerm)) {
                    //znajdŸ ten termin
                    System.out.println(displayMessage(18, definition, anotherTerm));
                    logList.add(displayMessage(18, definition, anotherTerm));

                    //nalicz b³¹d i zaktualizuj definition w cardsMap
                    errCounter++;
                    String newDef = definition + "\t" + errCounter;
                    cardsMap.replace(term, el.getValue(), newDef);
                }
                // je¿eli z³a odpowiedŸ
                else {
                    System.out.println(displayMessage(19, definition));
                    logList.add(displayMessage(19, definition));

                    //nalicz b³¹d i zaktualizuj definition w cardsMap
                    errCounter++;
                    String newDef = definition + "\t" + errCounter;
                    cardsMap.replace(term, el.getValue(), newDef);
                }

                counter++;
                if(counter == amount) break;
            }

        }
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
        SortedMap<String, Integer> errMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        int maxErrCounter = 0; // maksymalna wartoœæ pomy³ek
        int cardsWithMaxErrCounter = 0; // iloœæ pomy³ek

        for (Map.Entry<String, String> el : cardsMap.entrySet()) {
            String card = el.getKey();
            String[] tab = el.getValue().split("\\t");
            int errCounter = Integer.parseInt(tab[1]);
            errMap.put(card, errCounter);

            //max value
            if (errCounter > maxErrCounter) maxErrCounter = errCounter;
        }

        //je¿eli nie ma kart z b³êdami
        if (maxErrCounter == 0) {
            System.out.println(displayMessage(22));
            logList.add(displayMessage(22));
        }
        //je¿eli s¹:
        else {
            for (Map.Entry<String, Integer> el : errMap.entrySet()) {
                if (el.getValue() == maxErrCounter) {
                    sb.append("\"").append(el.getKey()).append("\"").append(", ");
                    cardsWithMaxErrCounter++;
                }
            }
            sb.delete(sb.length() - 2, sb.length());

            if(cardsWithMaxErrCounter == 1 ) {
                System.out.println(displayMessage(23, sb.toString(), String.valueOf(maxErrCounter)));
                logList.add(displayMessage(23, sb.toString(), String.valueOf(maxErrCounter)));
            } else {
                System.out.println(displayMessage(24, sb.toString(), String.valueOf(maxErrCounter)));
                logList.add(displayMessage(24, sb.toString(), String.valueOf(maxErrCounter)));
            }

        }



    }

    public static void resetStats() {
        for (Map.Entry<String, String> el : cardsMap.entrySet()) {
            String[] defTab = el.getValue().split("\\t");
            String value = defTab[0];
            cardsMap.replace(el.getKey(), el.getValue(), value + "\t" + 0);
        }
        System.out.println("Card statistics have been reset.");
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
            case 22:
                msg = "There are no cards with errors.";
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
                msg = String.format("Wrong. The right answer is \"%s\", but your definition is correct for \"%s\" card.", val1, val2);
                break;
            case 23:
                msg = String.format("The hardest card is %s. You have %s errors answering it.", val1, val2);
                break;
            case 24:
                msg = String.format("The hardest cards are %s. You have %s errors answering them.", val1, val2);
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
