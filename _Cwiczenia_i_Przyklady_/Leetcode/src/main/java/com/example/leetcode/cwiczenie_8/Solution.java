package com.example.leetcode.cwiczenie_8;

import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        StringBuilder sb = new StringBuilder();

        char firstSign = s.charAt(0);
        boolean firstSignDigit = Character.isDigit(firstSign);
        if (!firstSignDigit) {
            String firstSStr = Character.valueOf(firstSign).toString();
            if (firstSStr.equals("-") || firstSStr.equals("+")) {
                sb.append(firstSStr);
            } else {
                return 0;
            }
        } else {
            sb.append(firstSign);
        }

        for (int i = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else break;
        }

        if (sb.toString().matches("[-+]")) return 0;

        BigInteger bigInteger = new BigInteger(sb.toString());
        BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        if (bigInteger.compareTo(max) > 0) return Integer.MAX_VALUE;
        if (bigInteger.compareTo(min) < 0) return Integer.MIN_VALUE;

//        long longNum = Long.parseLong();
//        if (longNum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//        if (longNum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return Integer.parseInt(sb.toString());
    }
}
