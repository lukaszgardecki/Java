package program;

import program.elements.main_frame.Window;
import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;
import program.settings.MouseClick;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static program.elements.panels.views.AddOrRemoveView.groupsCombo;
import static program.elements.panels.views.AddOrRemoveView.levelCombo;


public class Main {
    static String path = "src/main/java/program/database/baza.txt";
    public static StringBuilder correctAns;
    //static final MemoBox memoBox = new MemoBox(50, 60, 90, 140, 160);
    public static final MemoBox memoBox = new MemoBox(5, 10, 25, 40, 70);
    public static Window win;

    public static void main(String[] args) {
        loadData();
        //baza.forEach(e -> System.out.println(e.getName() + " " + e.getList().size()));
        //baza.get(0).getList().forEach(e -> System.out.println(Arrays.toString(e)));
        //System.out.println(memoBox.getWord());
        //System.out.println(Arrays.toString(loadWord1()));
        //System.out.println(getAmountOfAllAns());
        //System.out.println("S³oñce ¿ó³wiaste");

        //System.out.println(memoBox);
        win = new Window();
    }


    public static void loadData() {
        try (FileInputStream inputf = new FileInputStream(path);
             Scanner scanner = new Scanner(new InputStreamReader(inputf))) {
            scanner.nextLine();
            String lineWithCurrentWord = scanner.nextLine();
            int dotIndex = lineWithCurrentWord.indexOf("."); // grupa bêdzie zawsze jednocyfrowa
            int currentGroup = Integer.parseInt(lineWithCurrentWord.substring(dotIndex-1, dotIndex));
            int counter = Integer.parseInt(lineWithCurrentWord.substring(dotIndex + 1));

            memoBox.setCurrentGroup(currentGroup);
            memoBox.setCounter(counter);

            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] word = line.split("_");
                String currentCat = Arrays.stream(word).toList().get(2);
                Category.valueOf(currentCat).getList().add(word);

                if (!word[1].equals("7")) {
                    Category.valueOf(currentCat).getCheckBox().setSelected(true);
                    memoBox.add(word);
                }

                //memoBox.add(word);
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
            writer.write(String.format("Current group: %s.%s\n", memoBox.getNumOfCurrentGroup(), memoBox.getCounter()));
            writer.write("\n");

            for (Category cat : Category.values()) {
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

        //je¿eli -1 (memobox pusty) to wyœwietl komunikat
        if (numOfGroup == -1) {
            return displayEmptyBaseMessage();
        }

        return memoBox.getGroup(numOfGroup).getFirst();
    }



    public static String[] displayEmptyBaseMessage() {
        return new String[]{"19940418200515", "6","CAT0","0", "0", "0", "brak fiszek", "brak fiszek"};
    }

    public static void changeLevel(String upOrDown) {
        System.out.println("wszed³ do change");
        String[] temp = memoBox.getCurrentWord();
        int numOfGroup = Integer.parseInt(temp[1]);
        int correctAnswer = Integer.parseInt(temp[4]);
        int wrongAnswer = Integer.parseInt(temp[5]);
        String dateNew = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

        // usuñ ze starej listy
        memoBox.remove(temp);

        switch (upOrDown) {
            case "up" -> {
                if (memoBox.isEmpty()) memoBox.setCurrentGroup(6);
                if(numOfGroup == 0) numOfGroup = numOfGroup + 2;
                else numOfGroup++;
                correctAnswer++;
            }
            case "down" -> {
                //je¿eli po usuniêciu grupa jest pusta to ustaw currentGroup na aktualn¹ grupê
                if(memoBox.getGroup(numOfGroup).isEmpty()) memoBox.setCurrentGroup(1);
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
        System.out.println("wyszed³ z change");
    }

    public static String getDate() {
        String fullDate = memoBox.getCurrentWord()[0];
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
        //return baza.stream().mapToInt(e -> e.getList().size()).sum();
        return Arrays.stream(Category.values()).mapToInt(e -> e.getList().size()).sum();
    }

    public static String getAmountOfAllAns() {
        int amountOfAllAns = Arrays.stream(Category.values())
                .mapToInt(group -> group.getList().stream()
                                    .mapToInt(word -> Integer.parseInt(word[4]) + Integer.parseInt(word[5])).sum()).sum();
        return String.valueOf(amountOfAllAns);
    }

    public static String getAmountOfCorrectAns() {
        double allAns = Double.parseDouble(getAmountOfAllAns());
        String correctAnsPercent;
        int amountOfCorrectAns = Arrays.stream(Category.values())
                .mapToInt(group -> group.getList().stream().mapToInt(word -> Integer.parseInt(word[4])).sum()).sum();

        correctAnsPercent = String.valueOf(String.format("%d (%.2f%%)",
                amountOfCorrectAns, (amountOfCorrectAns*100)/allAns));

        return correctAnsPercent;
    }

    public static String getAmountOfIncorrectAns() {

        double allAns = Double.parseDouble(getAmountOfAllAns());
        String incorrectAnsPercent;
        int amountOfIncorrectAns = Arrays.stream(Category.values())
                .mapToInt(group -> group.getList().stream()
                        .mapToInt(word -> Integer.parseInt(word[5])).sum()).sum();

        incorrectAnsPercent = String.valueOf(String.format("%d (%.2f%%)",
                amountOfIncorrectAns, (amountOfIncorrectAns*100)/allAns));

        return incorrectAnsPercent;
    }


    public static void doOperation(String operation) {
        switch (operation) {
            case "add" -> addWordToBase();
            case "change" -> changeWordInBase();
            case "remove" -> removeWordFromBase();
        }
        updateStatistics();
        updateEditListOfWords();
    }


    private static boolean checkIfWordExistsInBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        String category = String.valueOf(groupsCombo.getSelectedItem());
        String CAT = Category.getCAT(category);
        String level = Objects.requireNonNull(levelCombo.getSelectedItem()).toString();

        boolean ans = false;
        loop:
        for (Category cat : Category.values()) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polishWord) &&
                        word[7].equals(englishWord) &&
                        word[2].equals(CAT) &&
                        word[3].equals(level)
                ) {
                    ans = true;
                    break loop;
                }
            }
        }
        return ans;
    }


    public static void addWordToBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        String category = String.valueOf(groupsCombo.getSelectedItem());
        String CAT = Category.getCAT(category);
        String level = Objects.requireNonNull(levelCombo.getSelectedItem()).toString();
        boolean isWordExistsInBase = checkIfWordExistsInBase();

        if (isWordExistsInBase) return;

        String[] newWord = {"00000000000000", "0", CAT, level, "0", "0", polishWord, englishWord};
        Category.valueOf(CAT).getList().add(newWord);

        //je¿eli checkbox jest zaznaczony to dodaj do memoboxa
        if (Category.valueOf(CAT).getCheckBox().isSelected()) {
            memoBox.add(newWord);
        }

        updateCheckBoxNames(CAT);


    }

    public static void changeWordInBase() {
        //wartoœci z bazy (na pewno istniej¹, nie trzeba sprawdzaæ)
        String polishWord = MouseClick.getPolishWord();
        String englishWord = MouseClick.getEnglishWord();
        String category = MouseClick.getCategory();
        String CAT = Category.getCAT(category);
        String level = MouseClick.getLevel();

        //wartoœci z pól (trzeba sprawdziæ)
        String newPolishWord = AddOrRemoveView.tf1.getText();
        String newEnglishWord = AddOrRemoveView.tf2.getText();
        String newCategory = String.valueOf(groupsCombo.getSelectedItem());
        String newCAT = Category.getCAT(newCategory);
        String newLevel = Objects.requireNonNull(levelCombo.getSelectedItem()).toString();
        boolean isWordExistsInBase = checkIfWordExistsInBase();


        if (isWordExistsInBase) return;

        for (String[] word : Category.valueOf(CAT).getList()) {
            if (word[6].equals(polishWord) && word[7].equals(englishWord) &&
                word[2].equals(CAT) && word[3].equals(level)
            ) {
                Category.valueOf(CAT).getList().remove(word);

                //je¿eli checkbox jest zaznaczony to usuñ z memoboxa
                if (Category.valueOf(CAT).getCheckBox().isSelected()) {
                    memoBox.remove(word);
                }

                word[6] = newPolishWord;
                word[7] = newEnglishWord;
                word[2] = newCAT;
                word[3] = newLevel;

                Category.valueOf(newCAT).getList().add(word);
                //je¿eli checkbox jest zaznaczony to dodaj do memoboxa
                if (Category.valueOf(newCAT).getCheckBox().isSelected()) {
                    memoBox.add(word);
                }

                updateCheckBoxNames(CAT, newCAT);

                break;
            }
        }
        boolean isWordExistsInMemobox = memoBox.checkIfWordExists();
        System.out.println(isWordExistsInMemobox);
//        if (isWordExistsInMemobox) {
//
//            System.out.println("wchodzi do œrdokda");
//            loop2:
//            for (Group group : memoBox.getAllGroups()) {
//                for (String[] word : group) {
//                    if (word[6].equals(polishWord) && word[7].equals(englishWord) &&
//                            word[2].equals(CAT) && word[3].equals(level)
//                    ) {
//                        System.out.println("pewnie i tak tu nie wejdzie");
//                        word[6] = newPolishWord;
//                        word[7] = newEnglishWord;
//                        word[2] = newCAT;
//                        word[3] = newLevel;
//                        break loop2;
//                    }
//                }
//            }
//        }

    }

    private static void updateCheckBoxNames(String CAT, String newCAT) {
        String oldGroupName = String.format("%s (%s)", Category.valueOf(CAT).getName(), Category.valueOf(CAT).getList().size());
        String newGroupName = String.format("%s (%s)", Category.valueOf(newCAT).getName(), Category.valueOf(newCAT).getList().size());
        Category.valueOf(CAT).getCheckBox().setText(oldGroupName);
        Category.valueOf(newCAT).getCheckBox().setText(newGroupName);
    }

    private static void updateCheckBoxNames(String CAT) {
        String oldGroupName = String.format("%s (%s)", Category.valueOf(CAT).getName(), Category.valueOf(CAT).getList().size());
        Category.valueOf(CAT).getCheckBox().setText(oldGroupName);
    }

    public static void removeWordFromBase() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        String category = String.valueOf(groupsCombo.getSelectedItem());
        String CAT = Category.getCAT(category);
        String level = Objects.requireNonNull(levelCombo.getSelectedItem()).toString();
        boolean isWordExistsInBase = checkIfWordExistsInBase();
        boolean isWordExistsInMemobox = memoBox.checkIfWordExists();

        if (!isWordExistsInBase) return;

        loop1:
        for (Category cat : Category.values()) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polishWord) &&
                    word[7].equals(englishWord) &&
                    word[2].equals(CAT) &&
                    word[3].equals(level)) {
                    cat.getList().remove(word);

                    updateCheckBoxNames(CAT);
                    break loop1;
                }
            }
        }

        if (isWordExistsInMemobox) {
            loop2:
            for (Group group : memoBox.getAllGroups()) {
                for (String[] word : group) {
                    if (word[6].equals(polishWord) && word[7].equals(englishWord) &&
                            word[2].equals(CAT) && word[3].equals(level)
                    ) {
                        group.remove(word);
                        break loop2;
                    }
                }
            }
        }
    }


    public static String getCorrectAnswer() {
        return correctAns.toString();
    }


}
