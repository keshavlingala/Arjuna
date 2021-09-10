package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class Perm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        boolean yes = false;
        char[] sorted = s1.toCharArray();
        Arrays.sort(sorted);
        for (int j = 0; j <= s2.length() - s1.length(); j++) {
            char[] a = s2.substring(j, j + s1.length()).toCharArray();
            Arrays.sort(a);
            if (Arrays.equals(a, sorted))
                yes = true;
        }
        System.out.println(yes);
    }
}