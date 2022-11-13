package com.mojastrona.zad_46_jee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisorsFinder {

    List<Integer> getDivisorsOf(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.abs(n); i++) {
            if (n % i != 0) continue;
            list.add(i);
            if (n < 0) list.add(-i);
        }
        Collections.sort(list);
        return list;
    }
}
