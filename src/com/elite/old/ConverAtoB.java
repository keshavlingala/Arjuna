package com.elite.old;

import java.util.HashMap;
import java.util.Scanner;

public class ConverAtoB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (!map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), b.charAt(i));
                continue;
            }
            if (map.get(a.charAt(i)) != b.charAt(i)) {
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}

