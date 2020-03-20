package com.elite.old;

import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Seq {
    static SortedSet<String> set = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<String, Integer> hp = new HashMap<>();
        rec(s, s.length(), "");
//        System.out.println(set);
        System.out.println(set.size());

    }

    static void rec(String s, int len, String path) {

        if (path.length() > len) {
            return;
        }
        if (!path.equals("")) {
            set.add(path);
        }
        for (int i = 0; i < s.length(); i++) {
            rec(s.substring(0, i) + s.substring(i + 1), len, path + s.charAt(i));
        }
    }
}
