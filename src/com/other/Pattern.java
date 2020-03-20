package com.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int size = scanner.nextInt();
        ArrayList<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int c = 0;
        int g = 0;
        for (int k = 1; k <= word.length(); k++) {
            for (int j = 0; j <= word.length() - k; j++) {
                String substring = word.substring(j, j + k);
                for (int i = 0; i < substring.length(); i++) {
                    if (vowels.contains(substring.charAt(i))) {
                        c++;
                    }
                }
                if (c == size) {
                    g++;
                }
            }
        }
        System.out.println(g);
    }
}
