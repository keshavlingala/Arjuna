package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class LongestChain {
    static String[] words;
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        words = scanner.nextLine().split(" ");
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length())
                return a.compareTo(b);
            return a.length() - b.length();
        });
        rec(0, 0);
        System.out.println(result + 1);
    }

    static void rec(int index, int ans) {
        if (index >= words.length) return;
        result = Math.max(ans, result);
        for (int i = index; i < words.length; i++) {
            StringBuilder a = new StringBuilder(words[i]);
            for (int j = i + 1; j < words.length; j++) {
                if (-a.length() + words[j].length() == 1) {
                    StringBuilder sub = new StringBuilder(words[j]);
                    boolean flag = false;
                    for (int k = 0; k < sub.length(); k++) {
                        if (sub.deleteCharAt(k).toString().equals(a.toString())) {
                            flag = true;
                            break;
                        } else
                            sub = new StringBuilder(words[j]);
                    }
                    if (flag)
                        rec(j, ans + 1);
                }

            }
        }
    }
}
