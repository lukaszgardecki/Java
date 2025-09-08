package com.example.leetcode.cwiczenie_3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> uniqueChars = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            while (uniqueChars.contains(currentChar)) {
                uniqueChars.remove(s.charAt(left));
                left++;
            }

            uniqueChars.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
