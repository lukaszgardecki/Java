package com.example.planner;

class MapPrinter {

    void print(FoeMap map) {
        for (int[] ints : map.fields) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(anInt + " ");
                }

            }
            System.out.println();
        }
    }
}
