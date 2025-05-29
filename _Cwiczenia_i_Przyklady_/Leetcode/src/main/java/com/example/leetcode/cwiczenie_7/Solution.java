package com.example.leetcode.cwiczenie_7;

import java.math.BigInteger;

class Solution {
//    int reverse(int x) {
//        String xStr = String.valueOf(x);
//        String s = "";
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = xStr.length() - 1; i >= 0; i--) {
//            if (i == 0) {
//                String firstChar = Character.toString(xStr.charAt(i));
//                if (firstChar.equals("-") || firstChar.equals("+")) {
//                    s = firstChar;
//                } else {
//                    String ch = Character.toString(xStr.charAt(i));
//                    sb.append(ch);
//                }
//            } else {
//                String ch = Character.toString(xStr.charAt(i));
//                sb.append(ch);
//            }
//        }
//
//        BigInteger b = new BigInteger(sb.toString());
//        BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
//        BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
//        if (b.compareTo(max) > 0 || b.compareTo(min) < 0) return 0;
//
//        return Integer.parseInt(s + sb);
//    }

    public int reverse(int x) {
        long reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;

            if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) reversed;
    }
}
