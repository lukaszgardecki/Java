package program;

import program.elements.main_frame.Window;
import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;
import program.settings.MouseClick;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static Map<Integer, LinkedList<ArrayList<String>>> map = new LinkedHashMap<>();

    static String path = "program/database/baza.txt";
    static File file = new File(path);
    static StringBuilder correctAns;

    /*
        CAPACITY OF LEVELS
     */
    static final int CAP_GROUP_1 = 50;
    static final int CAP_GROUP_2 = 60;
    static final int CAP_GROUP_3 = 90;
    static final int CAP_GROUP_4 = 140;
    static final int CAP_GROUP_5 = 160;

    public static int amountOfWords = 0;
    public static Window win;

    public static void main(String[] args) {
        createMap();
        loadData();
        win = new Window();
    }

    public static void loadData() {

        try (FileInputStream inputf = new FileInputStream(path);
             Scanner scanner = new Scanner(new InputStreamReader(inputf))) {
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tab = line.split("_");
                ArrayList<String> list = new ArrayList<>();
                Collections.addAll(list, tab);
                int numOfGroup = Integer.parseInt(tab[1]);

                map.get(numOfGroup).add(list);
                amountOfWords++;
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }


//        try (Scanner scanner = new Scanner(file)) {
//            scanner.nextLine();
//            scanner.nextLine();
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] tab = line.split("_");
//                ArrayList<String> list = new ArrayList<>();
//                Collections.addAll(list, tab);
//                int numOfGroup = Integer.parseInt(tab[1]);
//
//                map.get(numOfGroup).add(list);
//                amountOfWords++;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found.");
//        }
    }

    public static void saveData() {
        try (FileOutputStream outf = new FileOutputStream(path);
             OutputStreamWriter writer = new OutputStreamWriter(outf)) {
            writer.write("data ost. powtórki_nr grupy_poprawne odpowiedzi_b³êdne odpowiedzi_t³umaczenie polskie_t³umaczenie angielskie");
            writer.write("\n");
            writer.write("\n");
            for (Map.Entry<Integer, LinkedList<ArrayList<String>>> m : map.entrySet()) {
                for (ArrayList<String> list : m.getValue()) {
                    StringBuilder line = new StringBuilder();

                    list.forEach(el -> line.append(el).append("_"));
                    line.deleteCharAt(line.length()-1);

                    writer.write(line + "\n");
                }
            }

        } catch (IOException f) {
            System.out.println("File not found.");
        }

//       try (FileWriter writer = new FileWriter(file)) {
//
//            writer.write("data ost. powtórki_nr grupy_poprawne odpowiedzi_b³êdne odpowiedzi_t³umaczenie polskie_t³umaczenie angielskie");
//            writer.write("\n");
//            writer.write("\n");
//            for (Map.Entry<Integer, LinkedList<ArrayList<String>>> m : map.entrySet()) {
//                for (ArrayList<String> list : m.getValue()) {
//                    StringBuilder line = new StringBuilder();
//
//                    list.forEach(el -> line.append(el).append("_"));
//                    line.deleteCharAt(line.length()-1);
//
//                    writer.write(line + "\n");
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("File not found");
//        }
    }

    public static ArrayList<String> loadWord() {
        ArrayList<String> word;
        boolean isFull_Group1 = map.get(1).size() == CAP_GROUP_1;
        boolean isFull_Group2 = map.get(2).size() == CAP_GROUP_2;
        boolean isFull_Group3 = map.get(3).size() == CAP_GROUP_3;
        boolean isFull_Group4 = map.get(4).size() == CAP_GROUP_4;
        boolean isFull_Group5 = map.get(5).size() == CAP_GROUP_5;
        boolean isMapEmpty = map.get(0).isEmpty() && map.get(1).isEmpty() &&
                             map.get(2).isEmpty() && map.get(3).isEmpty() &&
                             map.get(4).isEmpty() && map.get(5).isEmpty();
        boolean areWordsInGroupZero = map.get(0).size() != 0;

        if (isFull_Group1) {
            word = getFirstWordFromGroup(1);
        } else if (isFull_Group2) {
            word = getFirstWordFromGroup(2);
        } else if (isFull_Group3) {
            word = getFirstWordFromGroup(3);
        } else if (isFull_Group4) {
            word = getFirstWordFromGroup(4);
        } else if (isFull_Group5) {
            word = getFirstWordFromGroup(5);
        } else if (areWordsInGroupZero) {
            word = getFirstWordFromGroup(0);
        } else if (isMapEmpty) {
            word = displayEmptyBaseMessage();
        } else {
            word = getTheOldestWord();
        }
        setUnderscores(word);
        return word;
    }

    private static ArrayList<String> displayEmptyBaseMessage() {
        return (ArrayList<String>) List.of("19940418200515", "0", "0", "0", "brak fiszek", "brak fiszek");
    }

    private static ArrayList<String> getFirstWordFromGroup(int numOfGroup) {
        return map.get(numOfGroup).getFirst();
    }

    public static void createMap() {
        map.put(0, new LinkedList<>());
        map.put(1, new LinkedList<>());
        map.put(2, new LinkedList<>());
        map.put(3, new LinkedList<>());
        map.put(4, new LinkedList<>());
        map.put(5, new LinkedList<>());
    }

    public static void changeLevel(String upOrDown) {
        ArrayList<String> temp = loadWord();
        int numOfGroup = Integer.parseInt(temp.get(1));
        int correctAnswer = Integer.parseInt(temp.get(2));
        int wrongAnswer = Integer.parseInt(temp.get(3));
        String dateNew = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        boolean isFromGroup5 = false;

        // usuñ ze starej listy
        map.get(numOfGroup).remove(temp);

        switch (upOrDown) {
            case "up" -> {
                if (numOfGroup == 5) {
                    numOfGroup = 0;
                    isFromGroup5 = true;
                } else {
                    numOfGroup++;
                }
                correctAnswer++;
            }

            case "down" -> {
                if (numOfGroup != 0) {
                    numOfGroup = 0;
                }
                wrongAnswer++;
            }
        }

        // dodaj do nowej listy
        temp.set(1, String.valueOf(numOfGroup));
        temp.set(2, String.valueOf(correctAnswer));
        temp.set(3, String.valueOf(wrongAnswer));
        temp.set(0, dateNew);


        try {
            //je¿eli s³owo trafi do grupy 0 to na 10 miejsce
            if (numOfGroup == 0 && isFromGroup5) {
                map.get(numOfGroup).addLast(temp);
            } else if (numOfGroup == 0) {
                map.get(numOfGroup).add(10, temp);
            } else {
                map.get(numOfGroup).addLast(temp);
            }
        } catch (IndexOutOfBoundsException e) {
            //je¿eli grupa nie posiada 10 elementów to dodaj s³ówko na koniec tej grupy
            map.get(numOfGroup).addLast(temp);
        }
    }

    public static ArrayList<String> getTheOldestWord() {
        ArrayList<String> nMin = new ArrayList<>();
        long min = Long.MAX_VALUE;
        long n;

        for (int i = 1; i <= 5; i++) {
            try {
                n = Long.parseLong(map.get(i).getFirst().get(0));
                if (n < min) {
                    min = n;
                    nMin = map.get(i).getFirst();
                }
            } catch (NoSuchElementException ignored) {
            }
        }

        return nMin;
    }

    public static String getDate() {
        String fullDate = loadWord().get(0);
        if (fullDate.equals("00000000000000")) {
            return "NOWE";
        } else {
            String year = fullDate.substring(0, 4);
            String month = fullDate.substring(4, 6);
            String day = fullDate.substring(6, 8);
            String hours = fullDate.substring(8, 10);
            String minutes = fullDate.substring(10, 12);
            String seconds = fullDate.substring(12);
            return String.format("%s.%s.%s %s:%s:%s", day, month, year, hours, minutes, seconds);
        }
    }

    public static DefaultListModel <String> getListModel() {
        DefaultListModel<String> m = new DefaultListModel<>();
        ArrayList<String> temp = new ArrayList<>();
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                String e = String.format("%s (%s)", list.get(4), list.get(5));
                temp.add(e);
            }
        }
        Collections.sort(temp);
        for (String s : temp) {
            m.addElement(s);
        }
        return m;
    }

    public static void addWordToBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        boolean isWordExists = checkIfWordExists(polishWord, englishWord);

        if (isWordExists) return;

        addNewWordToMap(polishWord, englishWord);
        updateStatistics();
        updateEditListOfWords();
    }

    private static void addNewWordToMap(String polishWord, String englishWord) {
        ArrayList<String> temp = new ArrayList<>(6);
        temp.add("00000000000000");
        temp.add("0");
        temp.add("0");
        temp.add("0");
        temp.add(polishWord);
        temp.add(englishWord);
        map.get(0).add(temp);
    }

    public static void changeTheWordInBase() {
        String polishWord = MouseClick.polishWord;
        String englishWord = MouseClick.englishWord;
        String newPolishWord = AddOrRemoveView.tf1.getText();
        String newEnglishWord = AddOrRemoveView.tf2.getText();
        boolean isDuplicate = polishWord.equals(newPolishWord) && englishWord.equals(newEnglishWord);

        if (isDuplicate) return;

        changeWordInMap(polishWord, englishWord, newPolishWord, newEnglishWord);
        updateStatistics();
        updateEditListOfWords();
    }

    private static void changeWordInMap(String polishWord, String englishWord,
                                        String newPolishWord, String newEnglishWord) {
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                boolean s1 = list.get(4).equals(polishWord);
                boolean s2 = list.get(5).equals(englishWord);
                if (s1 && s2) {
                    list.set(4, newPolishWord);
                    list.set(5, newEnglishWord);
                    return;
                }
            }
        }
    }

    public static void removeFromBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        boolean isNotExist = checkIfWordExists(polishWord, englishWord);

        if (isNotExist) return;

        removeFromMap(polishWord, englishWord);
        updateStatistics();
        updateEditListOfWords();
    }

    private static boolean checkIfWordExists(String polishWord, String englishWord) {
        boolean s1 = false;
        boolean s2 = false;
        loop:
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                s1 = list.get(4).equals(polishWord);
                s2 = list.get(5).equals(englishWord);

                if (s1 && s2) break loop;
            }
        }
        return !s1 && !s2;
    }

    private static void removeFromMap(String polishWord, String englishWord) {
        int numOfGroup = getNumOfGroup(polishWord, englishWord);
        int index = getIndex(polishWord, englishWord);

        map.get(numOfGroup).remove(index);
    }

    private static int getNumOfGroup(String polishWord, String englishWord) {
        int numOfGroup = 0;
        boolean s1;
        boolean s2;
        loop:
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                s1 = list.get(4).equals(polishWord);
                s2 = list.get(5).equals(englishWord);
                numOfGroup = Integer.parseInt(list.get(1));
                if (s1 && s2) break loop;
            }
        }
        return numOfGroup;
    }

    private static int getIndex(String polishWord, String englishWord) {
        int index = 0;
        boolean s1;
        boolean s2;
        loop:
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                s1 = list.get(4).equals(polishWord);
                s2 = list.get(5).equals(englishWord);
                if (s1 && s2) break loop;
                index++;
            }
        }
        return index;
    }

    public static void updateStatistics() {
        StatsView.t1.setText(String.valueOf(getAmountOfAllWords()));
        StatsView.t2.setText(String.valueOf(map.get(1).size()));
        StatsView.t3.setText(String.valueOf(map.get(2).size()));
        StatsView.t4.setText(String.valueOf(map.get(3).size()));
        StatsView.t5.setText(String.valueOf(map.get(4).size()));
        StatsView.t6.setText(String.valueOf(map.get(5).size()));
        StatsView.t7.setText(getAmountOfCorrectAns());
        StatsView.t8.setText(getAmountOfIncorrectAns());
        StatsView.t9.setText(getAmountOfAllAns());
    }

    public static int getAmountOfAllWords() {
        return map.get(0).size() +
                map.get(1).size() +
                map.get(2).size() +
                map.get(3).size() +
                map.get(4).size() +
                map.get(5).size();
    }

    public static String getAmountOfCorrectAns() {
        double amountOfCorrectAns = 0;
        double allAns = Double.parseDouble(getAmountOfAllAns());
        String correctAnsPercent;

        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                amountOfCorrectAns += Integer.parseInt(list.get(2));
            }
        }

        correctAnsPercent = String.valueOf(String.format("%.0f (%.2f%%)",
                amountOfCorrectAns, (amountOfCorrectAns*100)/allAns));

        return correctAnsPercent;
    }

    public static String getAmountOfIncorrectAns() {
        double amountOfIncorrectAns = 0;
        double allAns = Double.parseDouble(getAmountOfAllAns());
        String incorrectAnsPercent;

        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                amountOfIncorrectAns += Integer.parseInt(list.get(3));
            }
        }

        incorrectAnsPercent = String.valueOf(String.format("%.0f (%.2f%%)",
                amountOfIncorrectAns, (amountOfIncorrectAns*100)/allAns));

        return incorrectAnsPercent;
    }

    public static String getAmountOfAllAns() {
        int amountOfAllAns = 0;
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                amountOfAllAns += (Integer.parseInt(list.get(2)) + Integer.parseInt(list.get(3)));
            }
        }
        return String.valueOf(amountOfAllAns);
    }

    public static void setUnderscores(ArrayList<String> lst) {
        String englishWord = lst.get(5);
        StringBuilder undersc = new StringBuilder();
        correctAns = new StringBuilder();

        for (int i = 0; i < englishWord.length(); i++) {
            String sign = Character.toString(englishWord.charAt(i));
            if (sign.matches("\\w")) {
                undersc.append("_").append("\u00A0");
                correctAns.append(sign).append("\u00A0");
            } else if (sign.matches("\\s+")) {
                undersc.append("  ");
                correctAns.append("  ");
            } else {
                undersc.append(sign);
                correctAns.append(sign);
            }
        }

        MainView.underscores.setText(String.valueOf(undersc));
    }

    public static String getCorrectAnswer() {
        return correctAns.toString();
    }

    private static void updateEditListOfWords() {
        AddOrRemoveView.list.setModel(getListModel());
    }


}
