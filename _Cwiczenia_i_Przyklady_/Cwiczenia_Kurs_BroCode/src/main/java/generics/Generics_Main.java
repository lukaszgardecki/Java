package generics;

import java.util.Arrays;

public class Generics_Main {
    public static void main(String[] args) {

        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {5.5, 4.4, 3.3, 2.2, 1.1};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        String[] stringArray = {"B", "Y", "E"};

        displayArray(intArray);
        displayArray(doubleArray);
        displayArray(charArray);
        displayArray(stringArray);

        System.out.println(getFirst(intArray));
    }

    public static <Thing> void displayArray(Thing[] array) {
        Arrays.stream(array).forEach(element -> System.out.print(element + " "));
        System.out.println();
    }

    public static <Thing> Thing getFirst(Thing[] array) {
        return array[0];
    }
}
