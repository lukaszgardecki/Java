package com.example.programowanierownolegle.streams;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.function.UnaryOperator;

/**
 * Klasa UnaryAction<T> jest wątkiem typu RecursiveAction.
 * Podczas tworzenia obiektu tej klasy określa się listę wartości rzeczywistych,
 * operację przetwarzania elementów listy oraz zakres elementów do przetworzenia.
 *
 * @param <T>
 */
public class UnaryAction<T> extends RecursiveAction {
    private List<T> subjectList;
    private UnaryOperator<T> operator;
    private int begin;
    private int end;
    private static final int THRESHOLD = 100_000;

    public UnaryAction(List<T> subjectList, UnaryOperator<T> operator, int begin, int end) {
        this.operator = operator;
        this.subjectList = subjectList;
        this.begin = begin;
        this.end = end;
    }

    public UnaryAction(List<T> subjectList, UnaryOperator<T> operator) {
        this(subjectList, operator, 0, subjectList.size());
    }

    /**
     * Metoda compute() sprawdza, czy liczba elementów jest mniejsza niż wartość THRESHOLD.
     * Jeśli tak, rozpoczyna się wykonywanie uzyskanej operacji na określonych elementach listy.
     * Jeśli liczba elementów listy jest duża, jest ona dzielona na dwie części;
     * tworzone są dwa podzadania, a następnie wywoływana jest metoda invokeAll() w celu ich wykonania.
     */
    @Override
    protected void compute() {
        if (end - begin < THRESHOLD) {
            System.out.printf("from %d to %d - thread %s%n", begin, end,
                    Thread.currentThread().getName());
            for (int i = begin; i < end; i++) {
                subjectList.set(i, operator.apply(subjectList.get(i)));
            }
        } else {
            int middle = (begin + end) / 2;
            invokeAll(new UnaryAction<T>(subjectList, operator, begin, middle),
                    new UnaryAction<T>(subjectList, operator, middle, end));
        }
    }
}

