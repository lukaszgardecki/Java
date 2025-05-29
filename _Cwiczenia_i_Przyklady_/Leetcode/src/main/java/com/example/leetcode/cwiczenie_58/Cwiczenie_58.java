package com.example.leetcode.cwiczenie_58;

import java.util.Arrays;

class Cwiczenie_58 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {
                "Hello World",
                "   fly me   to   the moon  ",
                "luffy is still joyboy"
        };
        Arrays.stream(inputs)
                .map(solution::lengthOfLastWord)
                .forEach(System.out::println);
    }
}
