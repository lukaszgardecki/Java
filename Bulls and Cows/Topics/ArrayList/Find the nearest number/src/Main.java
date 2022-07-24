import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputNumbers = readArrayList(scanner);
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> outputNumbers = new ArrayList<>();
        int num = scanner.nextInt();
        int min = Math.abs(num - inputNumbers.get(0));
        int subtract;
        int g;
        int h;

        //znajdŸ najmniejsz¹ odleg³oœæ
        for (Integer n : inputNumbers) {
            g = Math.abs(num - n);
            if (g <= min) {
                min = g;
            }
        }
        // elementy z najmniejsz¹ odleg³oœci¹ wstaw do drugiej tablicy
        for (Integer n : inputNumbers) {
            h = Math.abs(num - n);
            if (h == min) {
                outputNumbers.add(n);
            }
        }
        //sortuj
        Collections.sort(outputNumbers);
        //wyœwietl
        for (Integer n : outputNumbers) {
            System.out.print(n + " ");
        }
    }
    //metoda, która czyta ze skanera liczby wypisane po spacji i przypisuje je do ArrayListy
    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}