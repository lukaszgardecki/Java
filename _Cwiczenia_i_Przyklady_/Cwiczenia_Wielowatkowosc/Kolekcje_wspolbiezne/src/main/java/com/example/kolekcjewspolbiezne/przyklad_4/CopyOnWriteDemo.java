package com.example.kolekcjewspolbiezne.przyklad_4;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * 1. Tworzy listę o nazwie temp zawierającą pięć elementów, których wartości mieszczą się w przedziale od 0 do 9.
 * 2. Na podstawie tej listy tworzony jest obiekt CopyOnWriteArrayList o nazwie copyList.
 * 3. Następnie uruchamiane są dwa wątki:
 *      - Pierwszy wątek pobiera obiekty z listy copyList za pomocą iteratora i dodaje je z powrotem do kolekcji copyList.
 *      - Drugi wątek jednocześnie dodaje brakujące liczby od 0 do 9 do listy copyList.
 */
public class CopyOnWriteDemo {
    public static void main(String[] args) {
        List<Integer> temp = new Random()
                .ints(5, 0, 10)
                .boxed()
                .collect(Collectors.toList());

        CopyOnWriteArrayList<Integer> copyList = new CopyOnWriteArrayList<>(temp);
        System.out.printf("%17s: %s%n ", "copyList before", copyList);

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Iterator<Integer> iterator = copyList.iterator();
            while(iterator.hasNext()) {
                Integer current = iterator.next();
                copyList.add(current);
            }
            System.out.printf("%16s: %s%n ", "newList Th #1", newList);
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                copyList.addIfAbsent(i);
            }
            System.out.printf("%16s: %s%n ", "copyList Th #2", copyList);
        }).start();

        try {
            TimeUnit.SECONDS.timedJoin(Thread.currentThread(), 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%16s: %s%n ", "copyList Th #2", copyList);
        System.out.printf("%16s: %s%n ", "newList Th #1", newList);
    }
}