package Zad_71_Lambdy2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Zadanie {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        generateRandomList(numbers, 10, () -> random.nextInt(1000));

        System.out.println(">>> Lista losowych liczb:");
        consumeList(numbers, num -> System.out.print(num + " "));

        System.out.println();
        System.out.println(">> Lista, która zawiera tylko liczby nieparzyste:");
        filterNumbers(numbers, x -> x % 2 == 0);
        consumeList(numbers, num -> System.out.print(num + " "));
    }

    private static <T> void filterNumbers(List<T> numbers, Predicate<T> predicate) {
        Iterator<T> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (predicate.test(iterator.next())) {
                iterator.remove();
            }
        }
    }

    private static <T> void generateRandomList(List<T> list, int num, Supplier<T> supplier) {
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
    }

    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
