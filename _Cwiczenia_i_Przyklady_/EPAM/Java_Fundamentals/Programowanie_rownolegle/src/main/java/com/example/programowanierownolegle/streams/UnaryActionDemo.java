package com.example.programowanierownolegle.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Klasa UnaryActionDemo tworzy listę wartości rzeczywistych z zakresu [1.0 .. 1_000_000] za pomocą strumieni.
 * Następnie tworzy zadanie UnaryAction<Double> i przekazuje mu listę oraz operację typu UnaryOperator<Double>
 * jako wyrażenie lambda. Następnie wywołuje metodę invoke() dla utworzonego zadania,
 * która z kolei wywołuje metody fork() i join(). Po zakończeniu lista jest wyświetlana na konsoli.
 */
public class UnaryActionDemo {
    public static void main(String[] args) {
        List<Double> numbers = DoubleStream.iterate(1.0, num -> num + 1)
                .limit(1_000_000)
                .boxed()
                .collect(Collectors.toList());

        List.of(1, 2, 3).parallelStream().parallel().map(a -> a).toList();

        new UnaryAction<>(numbers, d -> Math.sqrt(d)).invoke();

        numbers.stream().forEach(r -> System.out.printf("%7.4f %n ", r));
    }
}
