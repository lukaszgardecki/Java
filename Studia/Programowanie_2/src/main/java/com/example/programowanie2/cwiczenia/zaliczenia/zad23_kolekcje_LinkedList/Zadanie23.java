package com.example.programowanie2.cwiczenia.zaliczenia.zad23_kolekcje_LinkedList;

import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Zadanie23 {
    public static void main(String[] args) {
        Graf g = new Graf("4, (0,1), (1,2), (3,0), (1,3)");
        System.out.println(g.toString());
    }
}

class Graf {
    private int n; // liczba wierzchołków, V = {0,1,...,n-1}
    private LinkedList[] tab; // tablica wierzchołków połączonych z danym wierzchołkiem

    public Graf(String lan) {
        StringTokenizer st = new StringTokenizer(lan, "() ,");
        n = Integer.parseInt(st.nextToken());
        tab = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            tab[i] = new LinkedList();
        }
        while(st.hasMoreTokens()) {
            tab[Integer.parseInt(st.nextToken())].add(new Integer(st.nextToken()));
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("%d: ".formatted(i));

            LinkedList list = tab[i];
            String elementyStr = list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))
                    .toString();

            sb.append("%s%n".formatted(elementyStr));
        }
        return sb.toString();
    }
}
