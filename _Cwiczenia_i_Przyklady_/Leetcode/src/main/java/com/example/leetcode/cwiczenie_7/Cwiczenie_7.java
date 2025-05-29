package com.example.leetcode.cwiczenie_7;

import java.util.Arrays;

class Cwiczenie_7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputs = {
                123, -123, 120
        };
        Arrays.stream(inputs)
                .map(solution::reverse)
                .forEach(System.out::println);
    }
}
