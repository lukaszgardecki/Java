import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.IntStream;

public class Tablica {

    static int[][] getArrayWithGreaterTotalSum(int[][] arr1, int[][] arr2) {
        long sumArr1 = Arrays.stream(arr1).mapToLong(e -> Arrays.stream(e).reduce(0, Integer::sum)).sum();
        long sumArr2 = Arrays.stream(arr2).mapToLong(e -> Arrays.stream(e).reduce(0, Integer::sum)).sum();

        if (sumArr1 > sumArr2) {
            return arr1;
        } else {
            return arr2;
        }
    }

    static String[] getArrayWithGreaterTotalSumOfCharacters(String[] arr1, String[] arr2) {
        long sumArr1 = Arrays.stream(arr1).mapToLong(String::length).sum();
        long sumArr2 = Arrays.stream(arr2).mapToLong(String::length).sum();

        if (sumArr1 > sumArr2) {
            return arr1;
        } else {
            return arr2;
        }
    }

    static long getTheGreatestNum(int[] tab) {
        return Arrays.stream(tab).reduce(0, Integer::max);
    }

    static long getTheLowestNum(int[] tab) {
        return Arrays.stream(tab).reduce(0, Integer::min);
    }

    static int[] getArrayWithTheGreatestTotalSumOfSubArray(int[][] tab) {
        return Arrays.stream(tab).reduce(Tablica::getReduce).get();
    }

    private static int[] getReduce(int[] a, int[] b) {
        int arr1 = Arrays.stream(a).reduce(0, Integer::sum);
        int arr2 = Arrays.stream(b).reduce(0, Integer::sum);

        if (arr1 > arr2) return a;
        else return b;
    }
}
