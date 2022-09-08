package io.javabrains.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 2;

        process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v/k)));


    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
//            try {
//                consumer.accept(i, key);
//            } catch (ArithmeticException e) {
//                System.out.println("Exception!!!!");
//            }
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        //return consumer::accept; // <-- mo¿na tym zast¹piæ
        return (v,k) -> {
            System.out.println("Executing from wrapper:");
            consumer.accept(v, k);

        };
    }
}
