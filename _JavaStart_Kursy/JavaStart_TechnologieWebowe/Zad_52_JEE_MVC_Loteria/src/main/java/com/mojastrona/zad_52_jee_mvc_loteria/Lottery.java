package com.mojastrona.zad_52_jee_mvc_loteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottery {
    static List<Integer> getCommonElements(List<Integer> source, List<Integer> target) {
        List<Integer> sourceCopy = new ArrayList<>(source);
        sourceCopy.retainAll(target);
        return sourceCopy;
    }

    static List<Integer> getRandomNumbers() {
        List<Integer> numberList = IntStream.rangeClosed(1, 49)
                .boxed()
                . collect(Collectors.toList());
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }
}
