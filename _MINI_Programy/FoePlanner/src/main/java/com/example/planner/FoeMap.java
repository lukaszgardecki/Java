package com.example.planner;

import java.util.Arrays;

class FoeMap {
    private final int[][] baseFields;
    int[][] fields;

    FoeMap(int[][] fields) {
        this.baseFields = deepCopy(fields);
        this.fields = deepCopy(fields);
    }

    public int countFreeFields() {
        return (int) Arrays.stream(fields)
                .flatMapToInt(Arrays::stream)
                .filter(v -> v == 1)
                .count();
    }

    public int countOccupiedFields() {
        return (int) Arrays.stream(fields)
                .flatMapToInt(Arrays::stream)
                .filter(v -> v == 2 || v == 3)
                .count();
    }

    public int countRoads() {
        return (int) Arrays.stream(fields)
                .flatMapToInt(Arrays::stream)
                .filter(v -> v == 3)
                .count();
    }

    public int sumPoints() {
        return Arrays.stream(fields)
                .flatMapToInt(Arrays::stream)
                .sum();
    }

    public int getMaxWidth() {
        return Arrays.stream(fields)
                .mapToInt(row -> Arrays.stream(row).sum())
                .max()
                .orElse(0);
    }

    public int getMaxHeight() {
        int cols = fields[0].length;
        int max = 0;

        for (int col = 0; col < cols; col++) {
            int count = 0;
            for (int[] field : fields) {
                if (field[col] == 1) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }

    public void reset() {
        this.fields = deepCopy(baseFields);
    }

    private int[][] deepCopy(int[][] original) {
        return Arrays.stream(original)
                .map(row -> Arrays.copyOf(row, row.length))
                .toArray(int[][]::new);
    }
}
