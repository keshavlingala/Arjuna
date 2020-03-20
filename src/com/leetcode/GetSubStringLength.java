package com.leetcode;

public class GetSubStringLength {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int max = 0;
        int c = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            int cost = Math.abs(s.charAt(i) - t.charAt(i));
            if (c > maxCost) {

            } else {
                c += cost;
                len++;
            }
        }
        System.out.println(max);
    }
}
