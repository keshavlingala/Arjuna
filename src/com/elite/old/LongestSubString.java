package com.elite.old;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder string = new StringBuilder(scanner.next());
        int left = 0, right = 0;
        HashMap<Character, Integer> hp = new HashMap<>();
        while (right<4) {
            if (hp.size() <= 2) {
                hp.put(string.charAt(right), ++right);

            } else {
                int del_idx=Collections.min(hp.values());
                hp.remove(string.charAt(del_idx));

            }
        }
    }
}
