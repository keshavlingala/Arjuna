package com.elite.latest;

import java.util.Scanner;

public class KeepOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder ans = new StringBuilder();
        ans.append('#');
        for (int i = 0; i < s.length(); i++) {
            if (ans.charAt(ans.length() - 1) != s.charAt(i)) {
                ans.append(s.charAt(i));
            }
        }
        System.out.println(ans.deleteCharAt(0).toString());
    }
}
