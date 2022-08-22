import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static String path = "src/baza.txt";
    static File file = new File(path);
    static Map<Integer, LinkedList<ArrayList<String>>> map = new LinkedHashMap<>();
    static final int CAP_GROUP_1 = 50;
    static final int CAP_GROUP_2 = 60;
    static final int CAP_GROUP_3 = 90;
    static final int CAP_GROUP_4 = 140;
    static final int CAP_GROUP_5 = 160;
    public static int amountOfWords = 0;


    public static void main(String[] args) {
        createMap();
        loadData();

        System.out.println("listy po operacji:");
        System.out.println("lista 0");
        map.get(0).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 1");
        map.get(1).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 2");
        map.get(2).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 3");
        map.get(3).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 4");
        map.get(4).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 5");
        map.get(5).forEach(e -> System.out.println("    " + e));


        new Window();
//        System.out.println(map.get(0).getFirst().get(0));
//        String data = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
//        long num = Long.parseLong(data);
//        System.out.println(num);


    }

    public static void loadData() {
        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tab = line.split("_");
                ArrayList<String> list = new ArrayList<>();
                Collections.addAll(list, tab);
                int numOfGroup = Integer.parseInt(tab[2]);


                map.get(numOfGroup).add(list);
                amountOfWords++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void saveData() {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("T£UMACZENIE POLSKIE_T£UMACZENIE ANGIELSKIE_NR GRUPY_ILOŒÆ B£ÊDNYCH ODPOWIEDZI_ILOŒÆ POPRAWNYCH ODPOWIEDZI");
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
            word = (ArrayList<String>) List.of("brak fiszek", "brak fiszek", "0", "0", "0");
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
        int numOfGroup = Integer.parseInt(temp.get(2));
        int correctAnswer = Integer.parseInt(temp.get(3));
        int wrongAnswer = Integer.parseInt(temp.get(4));
        String dateNew = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

        // usuñ ze stare listy
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
        temp.set(2, String.valueOf(numOfGroup));
        temp.set(3, String.valueOf(correctAnswer));
        temp.set(4, String.valueOf(wrongAnswer));
        try {
            temp.set(5, dateNew);

        } catch (IndexOutOfBoundsException e) {
            temp.add(dateNew);
        }
        try {
            map.get(numOfGroup).add(10, temp);
        } catch (IndexOutOfBoundsException e) {
            map.get(numOfGroup).addLast(temp);
        }

        System.out.println("listy po operacji:");
        System.out.println("lista 0");
        map.get(0).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 1");
        map.get(1).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 2");
        map.get(2).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 3");
        map.get(3).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 4");
        map.get(4).forEach(e -> System.out.println("    " + e));
        System.out.println("lista 5");
        map.get(5).forEach(e -> System.out.println("    " + e));
    }

    public static ArrayList<String> getTheOldestWord() {
        ArrayList<String> nMin = new ArrayList<>();
        long min = Long.MAX_VALUE;
        long n;

        for (int i = 1; i <= 5; i++) {
            try {
                n = Long.parseLong(map.get(i).getFirst().get(5));
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
        try {
            String d = loadWord().get(5);
            String year = d.substring(0, 4);
            String month = d.substring(4, 6);
            String day = d.substring(6, 8);
            String hours = d.substring(8, 10);
            String minutes = d.substring(10, 12);
            String seconds = d.substring(12);
            return String.format("%s.%s.%s %s:%s:%s", day, month, year, hours, minutes, seconds);
        } catch (IndexOutOfBoundsException e) {
            return "NOWE";
        }


    }

}
