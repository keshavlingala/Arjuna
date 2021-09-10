package com.elite.online.day74;

import java.util.HashMap;
import java.util.Scanner;

public class LimitChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int limit = scanner.nextInt();
        HashMap<Character, Integer> hp = new HashMap<>();
        String ans = "";
        for (Character c : scanner.next().trim().toCharArray()) {
            hp.putIfAbsent(c, 0);
            if (hp.get(c) >= limit) continue;
            hp.put(c, hp.get(c) + 1);
            ans += c;
        }
//        System.out.println(hp);
        System.out.println(ans);
    }
}
