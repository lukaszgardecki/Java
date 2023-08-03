package hashMap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, String> kraje = new HashMap<>();

        kraje.put("Polska", "Warszawa");
        kraje.put("Niemcy", "Berlin");
        kraje.put("Rosja", "Moskwa");
        kraje.put("Chiny", "Pekin");
        kraje.put("tratra", "Warszawa");

        System.out.println("Stan pocz¹tkowy mapy: " + kraje);

        String x = kraje.remove("Rosja");

        System.out.println("usuniêto: " + x);
        System.out.println("mapa bez Rosji: " + kraje);
        //kraje.clear();

        System.out.println("Rozmiar mapy: " + kraje.size());

        kraje.keySet().forEach(System.out::println);

        System.out.println("Czy w naszej mapie mamy stolicê 'Warszawa'? =" +
                !kraje.values().stream()
                        .filter(e -> e.equals("Warszawa"))
                        .toList()
                        .isEmpty());

        System.out.println("Pañstwo ze stolic¹ 'Pekin' to: " +
                kraje.entrySet().stream()
                        .filter(e -> e.getValue().equals("Pekin"))
                        .map(Map.Entry::getKey)
                        .toList()
                        .get(0));


        Map<Integer, LinkedList<ArrayList<String>>> map = new LinkedHashMap<>();

        int counter = 1;


        for (int i = 1; i <= 5; i++) {
            LinkedList<ArrayList<String>> linkedList = new LinkedList<>();
            for (int j = 1; j <= 10; j++) {
                ArrayList<String> list = new ArrayList<>();
                list.add("S³owo" + counter);
                list.add("Word" + counter);
                linkedList.add(list);
                counter++;
            }
            map.put(i, linkedList);
        }
        //System.out.println(map);

        String polishWord = "S³owo50";
        String newPolishWord = "yooy";
        String englishWord = "Word50";
        String newElishWord = "piop";


//        int t = map.entrySet().stream()
//                 .filter(e -> e.getValue()
//                         .stream()
//                         .anyMatch(r -> r.get(0).equals(polishWord) &&
//                                        r.get(1).equals(englishWord)))
//                .map(Map.Entry::getKey)
//                .toList().get(0);
//        System.out.printf("Numer grupy zawieraj¹cy s³owo: %s (%s) to %d\n", polishWord, englishWord, t);


        System.out.println();
        int g = map.values().stream()
                .mapToInt(LinkedList::size)
                .sum();
        System.out.println("Mapa przed korekt¹ ma elementów: " + g);
        System.out.println();







//        System.out.println();
//
//        boolean ooo = map.values().stream()
//                .anyMatch(e -> e.stream()
//                        .anyMatch(r -> r.get(0).equals(polishWord) &&
//                                     r.get(1).equals(englishWord)));
//
//        System.out.println("Czy nasze s³owo istnieje? " + ooo);







//        int k = map.values().stream()
//                .filter(e -> e.stream().anyMatch(r -> r.get(0).equals(polishWord) &&
//                                                      r.get(1).equals(englishWord)))
//                .toList().get(0)
//                .indexOf(List.of(polishWord, englishWord));
//
//        System.out.printf("S³owo: %s (%s) jest w grupie %d i ma indeks %d\n", polishWord, englishWord, t, k);
//
//
//
//        Map<Integer, LinkedList<ArrayList<String>>> m = new LinkedHashMap<>();
//        int c = 1;
//        for (int i = 1; i <= 5; i++) {
//            LinkedList<ArrayList<String>> linkedList = new LinkedList<>();
//            for (int j = 1; j <= 10; j++) {
//                ArrayList<String> list = new ArrayList<>();
//                list.add("S³owo" + c);
//                list.add("Word" + c);
//                list.add(String.valueOf(c));
//                linkedList.add(list);
//                c++;
//            }
//            m.put(i, linkedList);
//        }
//
//        System.out.println(m);
//
//
//       int sum = m.values().stream()
//                .mapToInt(e -> e.stream()
//                        .mapToInt(r -> Integer.parseInt(r.get(2)))
//                        .sum())
//                .sum();
//        System.out.println(sum);
//
//
//        int g = m.values().stream()
//                .mapToInt(LinkedList::size)
//                .sum();
//        System.out.println(g);

    }
}
