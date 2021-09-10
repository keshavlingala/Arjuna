package com.elite.latest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stirs = scanner.nextLine().split(" ");
        String target = scanner.nextLine().trim();
        ArrayList<String> list = new ArrayList<>();
        for (String s : stirs)
            if (isMathc(target, s))
                list.add(s);
        if (stirs.length > 50 || target.length() > 20) {
            System.out.println(" ");
            System.exit(0);
        }
        list.sort(String::compareTo);
        list.forEach(x -> {
            System.out.print(x + " ");
        });
    }

    static boolean isMathc(String s1, String s2) {
        HashMap<Character, Character> hp = new HashMap<>();
        HashMap<Character, Character> hp2 = new HashMap<>();
        boolean left = true;
        boolean right = true;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (hp.containsKey(s1.charAt(i))) {
                if (hp.get(s1.charAt(i)) != s2.charAt(i)) {
                    right = false;
                }
            } else {
                hp.put(s1.charAt(i), s2.charAt(i));
            }
            if (hp2.containsKey(s2.charAt(i))) {
                if (hp2.get(s2.charAt(i)) != s1.charAt(i)) {
                    left = false;
                }
            } else {
                hp2.put(s2.charAt(i), s1.charAt(i));
            }
        }
        return left && right;
    }
}
