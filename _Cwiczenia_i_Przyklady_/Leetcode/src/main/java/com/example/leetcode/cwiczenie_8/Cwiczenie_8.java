package com.example.leetcode.cwiczenie_8;

import java.util.Arrays;

class Cwiczenie_8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {
                "42",
                "   -042",
                "1337c0d3",
                "0-1",
                "words and 987",
                "-91283472332",
                "+-12",
                "-+12",
                "+1",
                "20000000000000000000"
        };
        Arrays.stream(inputs)
                .map(solution::myAtoi)
                .forEach(System.out::println);
    }
}
