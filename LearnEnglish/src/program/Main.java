package program;

import program.elements.main_frame.Window;
import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.StatsView;
import program.settings.MouseClick;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static String path = "src/program/database/baza.txt";
    static File file = new File(path);
    public static Map<Integer, LinkedList<ArrayList<String>>> map = new LinkedHashMap<>();

    /*
        CAPACITY OF LEVELS
     */
    static final int CAP_GROUP_1 = 50;
    static final int CAP_GROUP_2 = 60;
    static final int CAP_GROUP_3 = 90;
    static final int CAP_GROUP_4 = 140;
    static final int CAP_GROUP_5 = 160;
    public static int amountOfWords = 0;


    public static void main(String[] args) {
        createMap();
        loadData();

//        System.out.println("listy po operacji:");
//        System.out.println("lista 0");
//        map.get(0).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 1");
//        map.get(1).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 2");
//        map.get(2).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 3");
//        map.get(3).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 4");
//        map.get(4).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 5");
//        map.get(5).forEach(e -> System.out.println("    " + e));


        new Window();

    }

    public static void loadData() {
        try (Scanner scanner = new Scanner(file)) {
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
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void saveData() {
        try (FileWriter writer = new FileWriter(file)) {
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
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static ArrayList<String> loadWord() {
        ArrayList<String> word;
        int volG0 = map.get(0).size();
        int volG1 = map.get(1).size();
        int volG2 = map.get(2).size();
        int volG3 = map.get(3).size();
        int volG4 = map.get(4).size();
        int volG5 = map.get(5).size();

        if (volG1 == CAP_GROUP_1) {
            word = map.get(1).getFirst();
        } else if (volG2 == CAP_GROUP_2) {
            word = map.get(2).getFirst();
        } else if (volG3 == CAP_GROUP_3) {
            word = map.get(3).getFirst();
        } else if (volG4 == CAP_GROUP_4) {
            word = map.get(4).getFirst();
        } else if (volG5 == CAP_GROUP_5) {
            word = map.get(5).getFirst();
        } else if (volG0 != 0) {
            word = map.get(0).getFirst();
        } else if (volG1 == 0 && volG2 == 0 && volG3 == 0 && volG4 == 0 && volG5 == 0) {
            word = (ArrayList<String>) List.of("19940418200515", "0", "0", "0", "brak fiszek", "brak fiszek");
        } else {
            word = getTheOldestWord();
        }

        return word;
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

        // usuñ ze starej listy
        map.get(numOfGroup).remove(temp);

        switch (upOrDown) {
            case "up" -> {
                if (numOfGroup == 5) {
                    numOfGroup = 0;
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

        //je¿eli s³owo trafi do grupy 0 to na 10 miejsce
        try {
            map.get(numOfGroup).add(10, temp);
        } catch (IndexOutOfBoundsException e) {
            map.get(numOfGroup).addLast(temp);
        }

//        System.out.println("listy po operacji:");
//        System.out.println("lista 0");
//        map.get(0).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 1");
//        map.get(1).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 2");
//        map.get(2).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 3");
//        map.get(3).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 4");
//        map.get(4).forEach(e -> System.out.println("    " + e));
//        System.out.println("lista 5");
//        map.get(5).forEach(e -> System.out.println("    " + e));
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

        /*--------- return if it is a duplicate ---------*/
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                boolean s1 = list.get(4).equals(polishWord);
                boolean s2 = list.get(5).equals(englishWord);
                if (s1 && s2) return;
            }
        }

        /*--------- Add to map ---------*/
        ArrayList<String> temp = new ArrayList<>(6);
        temp.add("00000000000000");
        temp.add("0");
        temp.add("0");
        temp.add("0");
        temp.add(polishWord);
        temp.add(englishWord);
        map.get(0).add(temp);

        /*--------- update statistics ---------*/
        updateStatistics();

        /*--------- update edit list ---------*/
        AddOrRemoveView.list.setModel(getListModel());
    }

    public static void changeTheWordInBase() {
        String polishWord = MouseClick.polishWord;
        String englishWord = MouseClick.englishWord;
        String newPolishWord = AddOrRemoveView.tf1.getText();
        String newEnglishWord = AddOrRemoveView.tf2.getText();

        System.out.println(polishWord);
        System.out.println(englishWord);
        System.out.println(newPolishWord);
        System.out.println(newEnglishWord);


        /*--------- return if it is a duplicate ---------*/
        if (polishWord.equals(newPolishWord) && englishWord.equals(newEnglishWord)) return;

        /*--------- Change to map ---------*/
        loop2:
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                boolean s1 = list.get(4).equals(polishWord);
                boolean s2 = list.get(5).equals(englishWord);
                if (s1 && s2) {
                    list.set(4, newPolishWord);
                    list.set(5, newEnglishWord);
                    break loop2;
                }
            }
        }
        /*--------- update statistics ---------*/
        updateStatistics();

        /*--------- update edit list ---------*/
        AddOrRemoveView.list.setModel(getListModel());
    }



    public static void removeFromBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        int numOfGroup = 0;
        int index = 0;

        /*--------- return if it does not exist ---------*/
        boolean s1 = false;
        boolean s2 = false;
        loop:
        for (Map.Entry<Integer, LinkedList<ArrayList<String>>> el : map.entrySet()) {
            for (ArrayList<String> list : el.getValue()) {
                s1 = list.get(4).equals(polishWord);
                s2 = list.get(5).equals(englishWord);
                numOfGroup = Integer.parseInt(list.get(1));
                if (s1 && s2) break loop;
                index++;
            }
        }
        if (!s1 && !s2) return;

        /*--------- Change to map ---------*/
        map.get(numOfGroup).remove(index);

        /*--------- update statistics ---------*/
        updateStatistics();

        /*--------- update edit list ---------*/
        AddOrRemoveView.list.setModel(getListModel());
    }



    public static void updateStatistics() {
        StatsView.t1.setText(String.valueOf(getAmountOfAllWords()));
        StatsView.t2.setText(String.valueOf(map.get(1).size()));
        StatsView.t3.setText(String.valueOf(map.get(2).size()));
        StatsView.t4.setText(String.valueOf(map.get(3).size()));
        StatsView.t5.setText(String.valueOf(map.get(4).size()));
        StatsView.t6.setText(String.valueOf(map.get(5).size()));
    }

    public static int getAmountOfAllWords() {
        return map.get(0).size() +
                map.get(1).size() +
                map.get(2).size() +
                map.get(3).size() +
                map.get(4).size() +
                map.get(5).size();
    }



}
