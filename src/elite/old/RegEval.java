package com.elite.old;

import java.util.Scanner;

public class RegEval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String reg = scanner.nextLine();
        System.out.println(rec(s, reg));
    }

    static boolean rec(String s, String reg) {
        if (reg.isEmpty())
            return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (reg.charAt(0) == s.charAt(0) || reg.charAt(0) == '.'));
        if (reg.length() >= 2 && reg.charAt(1) == '*') {
            return (rec(s, reg.substring(2)) || (first_match && rec(s.substring(1), reg)));
        } else {
            return first_match && rec(s.substring(1), reg.substring(1));
        }
    }
}
