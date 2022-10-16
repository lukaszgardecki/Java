package program;

import program.elements.main_frame.Window;
import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;
import program.settings.MouseClick;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    public static List<Category> baza = new ArrayList<>(EnumSet.allOf(Category.class));


    static String path = "src/main/java/program/database/baza.txt";
    static File file = new File(path);
    public static StringBuilder correctAns;
    //static final MemoBox memoBox = new MemoBox(50, 60, 90, 140, 160);
    public static final MemoBox memoBox = new MemoBox(5, 10, 15, 20, 25);
    public static int amountOfWords = 0;
    public static Window win;
    public static String[] wordFromPreviousSession;

    public static void main(String[] args) {
        loadData();
        //baza.forEach(e -> System.out.println(e.getName() + " " + e.getList().size()));
        //baza.get(0).getList().forEach(e -> System.out.println(Arrays.toString(e)));
        //System.out.println(memoBox.getWord());
        //System.out.println(Arrays.toString(loadWord1()));
        //System.out.println(getAmountOfAllAns());
        //System.out.println("S³oñce ¿ó³wiaste");

        System.out.println(memoBox);
        win = new Window();
    }


    public static void loadData() {
        try (FileInputStream inputf = new FileInputStream(path);
             Scanner scanner = new Scanner(new InputStreamReader(inputf))) {
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] word = line.split("_");
                String currentCat = Arrays.stream(word).toList().get(2);
                Category.valueOf(currentCat).getList().add(word);
                memoBox.add(word);
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }

    public static void saveData() {
        try (FileOutputStream outf = new FileOutputStream(path);
             OutputStreamWriter writer = new OutputStreamWriter(outf)) {
            writer.write("DATE_GROUP_CATEGORY_LEVEL_ANS-T_ANS-F_PL_ANG");
            writer.write("\n");
            writer.write("\n");

            for (Category cat : baza) {
                for (String[] list : cat.getList()) {
                    StringBuilder line = new StringBuilder();
                    Arrays.asList(list).forEach(el -> line.append(el).append("_"));
                    line.deleteCharAt(line.length()-1);
                    writer.write(line + "\n");
                }
            }
        } catch (IOException f) {
            System.out.println("File not found.");
        }
    }

    public static String[] loadWord() {
        int numOfGroup = memoBox.getNumberOfGroup();




        return memoBox.getGroup(numOfGroup).getFirst();
    }



    private static String[] displayEmptyBaseMessage() {
        return new String[]{"19940418200515", "0", "0", "0", "brak fiszek", "brak fiszek"};
    }

    public static void changeLevel(String upOrDown) {
        String[] temp = loadWord();
        int numOfGroup = Integer.parseInt(temp[1]);
        int correctAnswer = Integer.parseInt(temp[4]);
        int wrongAnswer = Integer.parseInt(temp[5]);
        String dateNew = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

        // usuñ ze starej listy
        memoBox.remove(temp);

        switch (upOrDown) {
            case "up" -> {
                if(numOfGroup == 0) numOfGroup = numOfGroup + 2;
                else numOfGroup++;
                correctAnswer++;
            }
            case "down" -> {
                numOfGroup = 1;
                wrongAnswer++;
            }
        }

        // dodaj do nowej listy
        temp[0] = dateNew;
        temp[1] = String.valueOf(numOfGroup);
        temp[4] = String.valueOf(correctAnswer);
        temp[5] = String.valueOf(wrongAnswer);

        memoBox.getGroup(numOfGroup).addLast(temp);
    }

    public static String getDate() {
        String fullDate = loadWord()[0];
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
        List<String> temp = new ArrayList<>();

        memoBox.getAllGroups().forEach(group -> group.forEach(word -> {
            String e = String.format("%s (%s)", word[6], word[7]);
            temp.add(e);
        }));

        Collections.sort(temp);
        temp.forEach(m::addElement);
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

    private static boolean checkIfWordExists(String polishWord, String englishWord) {
        boolean ans = false;
        loop:
        for (Category cat : baza) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polishWord) && word[7].equals(englishWord)) {
                    ans = true;
                    break loop;
                }
            }
        }
        return ans;
    }

    private static void addNewWordToMap(String polishWord, String englishWord) {

        //TRZEBA ZROBIÆ POLE W KTÓRYM BÊDZIE SIÊ OKREŒLA£O CATEGORIÊ I DOPIERO ZROBIÆ TE METODÊ


//        ArrayList<String> temp = new ArrayList<>(6);
//        temp.add("00000000000000");
//        temp.add("0");
//        temp.add("0");
//        temp.add("0");
//        temp.add(polishWord);
//        temp.add(englishWord);
//
//        map.get(0).add(temp);
    }

    public static void updateStatistics() {

        MainView.g1.setText(String.valueOf(memoBox.getGroup(0).size()));
        MainView.g2.setText(String.valueOf(memoBox.getGroup(1).size()));
        MainView.g3.setText(String.valueOf(memoBox.getGroup(2).size()));
        MainView.g4.setText(String.valueOf(memoBox.getGroup(3).size()));
        MainView.g5.setText(String.valueOf(memoBox.getGroup(4).size()));
        MainView.g6.setText(String.valueOf(memoBox.getGroup(5).size()));
        MainView.g7.setText(String.valueOf(memoBox.getGroup(6).size()));

        StatsView.t1.setText(String.valueOf(getAmountOfAllWords()));
        StatsView.t2.setText(String.valueOf(memoBox.getGroup(1).size()));
        StatsView.t3.setText(String.valueOf(memoBox.getGroup(2).size()));
        StatsView.t4.setText(String.valueOf(memoBox.getGroup(3).size()));
        StatsView.t5.setText(String.valueOf(memoBox.getGroup(4).size()));
        StatsView.t6.setText(String.valueOf(memoBox.getGroup(5).size()));
        StatsView.t7.setText(String.valueOf(memoBox.getGroup(6).size()));
        StatsView.t8.setText(getAmountOfCorrectAns());
        StatsView.t9.setText(getAmountOfIncorrectAns());
        StatsView.t10.setText(getAmountOfAllAns());
    }

    private static void updateEditListOfWords() {
        AddOrRemoveView.list.setModel(getListModel());
    }

    public static int getAmountOfAllWords() {
        return baza.stream().mapToInt(e -> e.getList().size()).sum();
    }

    public static String getAmountOfAllAns() {
        int amountOfAllAns = memoBox.getAllGroups().stream()
                .mapToInt(group -> group.stream().mapToInt(word -> Integer.parseInt(word[4]) + Integer.parseInt(word[5])).sum()).sum();
        return String.valueOf(amountOfAllAns);
    }

    public static String getAmountOfCorrectAns() {
        double allAns = Double.parseDouble(getAmountOfAllAns());
        String correctAnsPercent;
        int amountOfCorrectAns = memoBox.getAllGroups().stream()
                .mapToInt(group -> group.stream().mapToInt(word -> Integer.parseInt(word[4])).sum()).sum();

        correctAnsPercent = String.valueOf(String.format("%d (%.2f%%)",
                amountOfCorrectAns, (amountOfCorrectAns*100)/allAns));

        return correctAnsPercent;
    }

    public static String getAmountOfIncorrectAns() {

        double allAns = Double.parseDouble(getAmountOfAllAns());
        String incorrectAnsPercent;
        int amountOfIncorrectAns = memoBox.getAllGroups().stream()
                .mapToInt(group -> group.stream().mapToInt(word -> Integer.parseInt(word[5])).sum()).sum();

        incorrectAnsPercent = String.valueOf(String.format("%d (%.2f%%)",
                amountOfIncorrectAns, (amountOfIncorrectAns*100)/allAns));

        return incorrectAnsPercent;
    }

//    public static void setUnderscores(String[] word) {
//        String englishWord = word[7];
//        StringBuilder undersc = new StringBuilder();
//        correctAns = new StringBuilder();
//
//        for (int i = 0; i < englishWord.length(); i++) {
//            String sign = Character.toString(englishWord.charAt(i));
//            if (sign.matches("\\w")) {
//                undersc.append("_").append("\u00A0");
//                correctAns.append(sign).append("\u00A0");
//            } else if (sign.matches("\\s+")) {
//                undersc.append("  ");
//                correctAns.append("  ");
//            } else {
//                undersc.append(sign);
//                correctAns.append(sign);
//            }
//        }
//
//        MainView.underscores.setText(String.valueOf(undersc));
//    }

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
        for (Category cat : baza) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polishWord) && word[7].equals(englishWord)) {
                    word[6] = newPolishWord;
                    word[7] = newEnglishWord;
                    return;
                }
            }
        }
    }

    public static void removeFromBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        boolean isExist = checkIfWordExists(polishWord, englishWord);

        if (isExist) {
            removeFromMap(polishWord, englishWord);
            updateStatistics();
            updateEditListOfWords();
        }
    }

    private static void removeFromMap(String polishWord, String englishWord) {
        int numOfGroup = getNumOfGroup(polishWord, englishWord);
        int index = getIndex(polishWord, englishWord);

        for (Category cat : baza) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polishWord) && word[7].equals(englishWord)) {
                    cat.getList().remove(word);
                    return;
                }
            }
        }
    }

    private static int getNumOfGroup(String polishWord, String englishWord) {
//        return map.entrySet().stream()
//                .filter(e -> e.getValue()
//                        .stream()
//                        .anyMatch(r -> r.get(4).equals(polishWord) &&
//                                r.get(5).equals(englishWord)))
//                .map(Map.Entry::getKey)
//                .toList().get(0);
        return 0;
    }

    private static int getIndex(String polishWord, String englishWord) {
        int index = 0;
//        boolean s1;
//        boolean s2;
//        loop:
//        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
//            for (ArrayList<String> list : el.getValue()) {
//                s1 = list.get(4).equals(polishWord);
//                s2 = list.get(5).equals(englishWord);
//                if (s1 && s2) break loop;
//                index++;
//            }
//        }
        return index;
    }

    public static String getCorrectAnswer() {
        return correctAns.toString();
    }















//    public static void createMap() {
//        map.put(0, new LinkedList<>());
//        map.put(1, new LinkedList<>());
//        map.put(2, new LinkedList<>());
//        map.put(3, new LinkedList<>());
//        map.put(4, new LinkedList<>());
//        map.put(5, new LinkedList<>());
//        map.put(6, new LinkedList<>());
//    }
//
//    public static void loadData() {
//
//        try (FileInputStream inputf = new FileInputStream(path);
//             Scanner scanner = new Scanner(new InputStreamReader(inputf))) {
//            scanner.nextLine();
//            scanner.nextLine();
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//
//                String[] tab = line.split("_");
//                ArrayList<String> list = new ArrayList<>();
//                Collections.addAll(list, tab);
//
//                int numOfGroup = Integer.parseInt(tab[1]);
//
//                map.get(numOfGroup).add(list);
//                amountOfWords++;
//            }
//        } catch (IOException e) {
//            System.out.println("File not found.");
//        }
//
//
////        try (Scanner scanner = new Scanner(file)) {
////            scanner.nextLine();
////            scanner.nextLine();
////            while (scanner.hasNextLine()) {
////                String line = scanner.nextLine();
////                String[] tab = line.split("_");
////                ArrayList<String> list = new ArrayList<>();
////                Collections.addAll(list, tab);
////                int numOfGroup = Integer.parseInt(tab[1]);
////
////                map.get(numOfGroup).add(list);
////                amountOfWords++;
////            }
////        } catch (FileNotFoundException e) {
////            System.out.println("File not found.");
////        }
//    }
//
//    public static void saveData() {
//        try (FileOutputStream outf = new FileOutputStream(path);
//             OutputStreamWriter writer = new OutputStreamWriter(outf)) {
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
//
//        } catch (IOException f) {
//            System.out.println("File not found.");
//        }
//
////       try (FileWriter writer = new FileWriter(file)) {
////
////            writer.write("data ost. powtórki_nr grupy_poprawne odpowiedzi_b³êdne odpowiedzi_t³umaczenie polskie_t³umaczenie angielskie");
////            writer.write("\n");
////            writer.write("\n");
////            for (Map.Entry<Integer, LinkedList<ArrayList<String>>> m : map.entrySet()) {
////                for (ArrayList<String> list : m.getValue()) {
////                    StringBuilder line = new StringBuilder();
////
////                    list.forEach(el -> line.append(el).append("_"));
////                    line.deleteCharAt(line.length()-1);
////
////                    writer.write(line + "\n");
////                }
////            }
////        } catch (IOException e) {
////            System.out.println("File not found");
////        }
//    }
//
//    public static ArrayList<String> loadWord() {
//        ArrayList<String> word;
//        boolean isFull_Group1 = map.get(1).size() == memoBox.getCapOfGroup(1);
//        boolean isFull_Group2 = map.get(2).size() == memoBox.getCapOfGroup(2);
//        boolean isFull_Group3 = map.get(3).size() == memoBox.getCapOfGroup(3);
//        boolean isFull_Group4 = map.get(4).size() == memoBox.getCapOfGroup(4);
//        boolean isFull_Group5 = map.get(5).size() == memoBox.getCapOfGroup(5);
//        boolean isMapEmpty = map.get(0).isEmpty() && map.get(1).isEmpty() &&
//                             map.get(2).isEmpty() && map.get(3).isEmpty() &&
//                             map.get(4).isEmpty() && map.get(5).isEmpty();
//        boolean areWordsInGroupZero = map.get(0).size() != 0;
//
//        if (isFull_Group1) {
//            word = getFirstWordFromGroup(1);
//        } else if (isFull_Group2) {
//            word = getFirstWordFromGroup(2);
//        } else if (isFull_Group3) {
//            word = getFirstWordFromGroup(3);
//        } else if (isFull_Group4) {
//            word = getFirstWordFromGroup(4);
//        } else if (isFull_Group5) {
//            word = getFirstWordFromGroup(5);
//        } else if (areWordsInGroupZero) {
//            word = getFirstWordFromGroup(0);
//        } else if (isMapEmpty) {
//            word = displayEmptyBaseMessage();
//        } else {
//            word = getTheOldestWord();
//        }
//        //setUnderscores(word);
//        return word;
//    }
//
//    private static ArrayList<String> displayEmptyBaseMessage() {
//        return (ArrayList<String>) List.of("19940418200515", "0", "0", "0", "brak fiszek", "brak fiszek");
//    }
//
//    private static ArrayList<String> getFirstWordFromGroup(int group) {
//        return map.get(group).getFirst();
//    }
//
//    public static ArrayList<String> getTheOldestWord() {
//        ArrayList<String> nMin = new ArrayList<>();
//        long min = Long.MAX_VALUE;
//        long n;
//
//        for (int i = 1; i <= 5; i++) {
//            try {
//                n = Long.parseLong(map.get(i).getFirst().get(0));
//                if (n < min) {
//                    min = n;
//                    nMin = map.get(i).getFirst();
//                }
//            } catch (NoSuchElementException ignored) {
//            }
//        }
//
//        return nMin;
//    }
//
//    public static void changeLevel(String upOrDown) {
//        ArrayList<String> temp = loadWord();
//        int numOfGroup = Integer.parseInt(temp.get(1));
//        int correctAnswer = Integer.parseInt(temp.get(2));
//        int wrongAnswer = Integer.parseInt(temp.get(3));
//        String dateNew = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//
//        // usuñ ze starej listy
//        map.get(numOfGroup).remove(temp);
//
//        switch (upOrDown) {
//            case "up" -> {
//                numOfGroup++;
//                correctAnswer++;
//            }
//            case "down" -> {
//                numOfGroup = 1;
//                wrongAnswer++;
//            }
//        }
//
//        // dodaj do nowej listy
//        temp.set(0, dateNew);
//        temp.set(1, String.valueOf(numOfGroup));
//        temp.set(2, String.valueOf(correctAnswer));
//        temp.set(3, String.valueOf(wrongAnswer));
//
//        map.get(numOfGroup).addLast(temp);
//    }
//
//    public static String getDate() {
//        String fullDate = loadWord().get(0);
//        if (fullDate.equals("00000000000000")) {
//            return "NOWE";
//        } else {
//            String year = fullDate.substring(0, 4);
//            String month = fullDate.substring(4, 6);
//            String day = fullDate.substring(6, 8);
//            String hours = fullDate.substring(8, 10);
//            String minutes = fullDate.substring(10, 12);
//            String seconds = fullDate.substring(12);
//            return String.format("%s.%s.%s %s:%s:%s", day, month, year, hours, minutes, seconds);
//        }
//    }
//
//    public static DefaultListModel <String> getListModel() {
//        DefaultListModel<String> m = new DefaultListModel<>();
//        ArrayList<String> temp = new ArrayList<>();
//
//        map.values().forEach(linkedList -> {
//            linkedList.forEach(arrayList -> {
//                String e = String.format("%s (%s)", arrayList.get(4), arrayList.get(5));
//                temp.add(e);
//            });
//        });
//
//        Collections.sort(temp);
//        temp.forEach(m::addElement);
//        return m;
//    }
//
//    public static void addWordToBase() {
//        String polishWord = AddOrRemoveView.tf1.getText();
//        String englishWord = AddOrRemoveView.tf2.getText();
//        boolean isWordExists = checkIfWordExists(polishWord, englishWord);
//
//        if (isWordExists) return;
//
//        addNewWordToMap(polishWord, englishWord);
//        updateStatistics();
//        updateEditListOfWords();
//    }
//
//    private static void addNewWordToMap(String polishWord, String englishWord) {
//        ArrayList<String> temp = new ArrayList<>(6);
//        temp.add("00000000000000");
//        temp.add("0");
//        temp.add("0");
//        temp.add("0");
//        temp.add(polishWord);
//        temp.add(englishWord);
//        map.get(0).add(temp);
//    }
//
//    public static void updateStatistics() {
//        StatsView.t1.setText(String.valueOf(getAmountOfAllWords()));
//        StatsView.t2.setText(String.valueOf(map.get(1).size()));
//        StatsView.t3.setText(String.valueOf(map.get(2).size()));
//        StatsView.t4.setText(String.valueOf(map.get(3).size()));
//        StatsView.t5.setText(String.valueOf(map.get(4).size()));
//        StatsView.t6.setText(String.valueOf(map.get(5).size()));
//        StatsView.t7.setText(String.valueOf(map.get(6).size()));
//        StatsView.t8.setText(getAmountOfCorrectAns());
//        StatsView.t9.setText(getAmountOfIncorrectAns());
//        StatsView.t10.setText(getAmountOfAllAns());
//    }
//
//    private static void updateEditListOfWords() {
//        AddOrRemoveView.list.setModel(getListModel());
//    }
//
//    public static int getAmountOfAllWords() {
//        return map.values().stream().mapToInt(LinkedList::size).sum();
//    }
//
//    public static String getAmountOfAllAns() {
//        int amountOfAllAns =  map.values().stream()
//                .mapToInt(e -> e.stream()
//                        .mapToInt(r -> Integer.parseInt(r.get(2)) + Integer.parseInt(r.get(3)))
//                        .sum())
//                .sum();
//
//        return String.valueOf(amountOfAllAns);
//    }
//
//    public static String getAmountOfCorrectAns() {
//
//        double allAns = Double.parseDouble(getAmountOfAllAns());
//        String correctAnsPercent;
//        int amountOfCorrectAns = map.values().stream()
//                .mapToInt(e -> e.stream()
//                        .mapToInt(r -> Integer.parseInt(r.get(2)))
//                        .sum())
//                .sum();
//
//        correctAnsPercent = String.valueOf(String.format("%d (%.2f%%)",
//                amountOfCorrectAns, (amountOfCorrectAns*100)/allAns));
//
//        return correctAnsPercent;
//    }
//
//    public static String getAmountOfIncorrectAns() {
//
//        double allAns = Double.parseDouble(getAmountOfAllAns());
//        String incorrectAnsPercent;
//        int amountOfIncorrectAns = map.values().stream()
//                .mapToInt(e -> e.stream()
//                        .mapToInt(r -> Integer.parseInt(r.get(3)))
//                        .sum())
//                .sum();
//
//        incorrectAnsPercent = String.valueOf(String.format("%d (%.2f%%)",
//                amountOfIncorrectAns, (amountOfIncorrectAns*100)/allAns));
//
//        return incorrectAnsPercent;
//    }
//
//    public static void setUnderscores(String[] word) {
////        String englishWord = lst.get(5);
////        StringBuilder undersc = new StringBuilder();
////        correctAns = new StringBuilder();
////
////        for (int i = 0; i < englishWord.length(); i++) {
////            String sign = Character.toString(englishWord.charAt(i));
////            if (sign.matches("\\w")) {
////                undersc.append("_").append("\u00A0");
////                correctAns.append(sign).append("\u00A0");
////            } else if (sign.matches("\\s+")) {
////                undersc.append("  ");
////                correctAns.append("  ");
////            } else {
////                undersc.append(sign);
////                correctAns.append(sign);
////            }
////        }
////
////        MainView.underscores.setText(String.valueOf(undersc));
//    }
//
//    public static void changeTheWordInBase() {
//        String polishWord = MouseClick.polishWord;
//        String englishWord = MouseClick.englishWord;
//        String newPolishWord = AddOrRemoveView.tf1.getText();
//        String newEnglishWord = AddOrRemoveView.tf2.getText();
//        boolean isDuplicate = polishWord.equals(newPolishWord) && englishWord.equals(newEnglishWord);
//
//        if (isDuplicate) return;
//
//        changeWordInMap(polishWord, englishWord, newPolishWord, newEnglishWord);
//        updateStatistics();
//        updateEditListOfWords();
//    }
//
//    private static void changeWordInMap(String polishWord, String englishWord,
//                                        String newPolishWord, String newEnglishWord) {
//        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
//            for (ArrayList<String> list : el.getValue()) {
//                boolean s1 = list.get(4).equals(polishWord);
//                boolean s2 = list.get(5).equals(englishWord);
//                if (s1 && s2) {
//                    list.set(4, newPolishWord);
//                    list.set(5, newEnglishWord);
//                    return;
//                }
//            }
//        }
////        map.values().stream()
////                .map(LinkedList::getFirst)
////                .filter(e -> e.get(4).equals(polishWord) && e.get(5).equals(englishWord))
////                .forEach(e -> {
////                    e.set(4, newPolishWord);
////                    e.set(5, newEnglishWord);
////                });
//    }
//
//    public static void removeFromBase() {
//        String polishWord = AddOrRemoveView.tf1.getText();
//        String englishWord = AddOrRemoveView.tf2.getText();
//        boolean isExist = checkIfWordExists(polishWord, englishWord);
//
//        if (isExist) {
//            removeFromMap(polishWord, englishWord);
//            updateStatistics();
//            updateEditListOfWords();
//        }
//    }
//
//    private static void removeFromMap(String polishWord, String englishWord) {
//        int numOfGroup = getNumOfGroup(polishWord, englishWord);
//        int index = getIndex(polishWord, englishWord);
//
//        map.get(numOfGroup).remove(index);
//    }
//
//    private static boolean checkIfWordExists(String polishWord, String englishWord) {
//        return map.values().stream()
//                .anyMatch(e -> e.stream()
//                        .anyMatch(r -> r.get(4).equals(polishWord) &&
//                                       r.get(5).equals(englishWord)));
//    }
//
//    private static int getNumOfGroup(String polishWord, String englishWord) {
//        return map.entrySet().stream()
//                .filter(e -> e.getValue()
//                        .stream()
//                        .anyMatch(r -> r.get(4).equals(polishWord) &&
//                                r.get(5).equals(englishWord)))
//                .map(Map.Entry::getKey)
//                .toList().get(0);
//    }
//
//    private static int getIndex(String polishWord, String englishWord) {
//        int index = 0;
//        boolean s1;
//        boolean s2;
//        loop:
//        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
//            for (ArrayList<String> list : el.getValue()) {
//                s1 = list.get(4).equals(polishWord);
//                s2 = list.get(5).equals(englishWord);
//                if (s1 && s2) break loop;
//                index++;
//            }
//        }
//        return index;
////        return map.values().stream()
////                .filter(e -> e.stream().anyMatch(r -> r.get(0).equals(polishWord) &&
////                        r.get(1).equals(englishWord)))
////                .toList().get(0)
////                .indexOf(List.of(polishWord, englishWord));
//    }
//
//    public static String getCorrectAnswer() {
//        return correctAns.toString();
//    }



}
