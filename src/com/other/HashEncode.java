package com.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HashEncode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        if (strings.length < 1 || strings.length > 20) {
            System.out.println(-1);
            System.exit(0);
        }
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        if (strings[strings.length - 1].length() < 1 || strings[strings.length - 1].length() > 7) {
            System.out.println(-2);
            System.exit(0);
        }
        int c = strings[strings.length - 1].length() + 1;
        for (int i = 0; i < strings.length - 1; i++) {
            String s1 = strings[i];
            boolean flag = false;
            for (int j = i + 1; j < strings.length; j++) {
                String s2 = strings[j];
                if (s2.substring(s2.length() - s1.length()).equals(s1)) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                c += s1.length() + 1;
        }
        System.out.println(c);
    }
}
