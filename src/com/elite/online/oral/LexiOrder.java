package com.elite.online.oral;

import java.util.Scanner;

public class LexiOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder first = new StringBuilder(scanner.nextLine().trim());
        StringBuilder second = new StringBuilder(scanner.nextLine().trim());
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (first.length() < second.length()) first.append("{");
        while (second.length() < first.length()) second.append("{");
        while (first.length() != 0 && second.length() != 0) {
            if (first.charAt(i) == second.charAt(i)) {
                if (first.toString().compareTo(second.toString()) >= 0) {
                    ans.append(second.charAt(i));
                    second.deleteCharAt(i);
                } else {
                    ans.append(first.charAt(i));
                    first.deleteCharAt(i);
                }
            } else if (first.charAt(i) < second.charAt(i)) {
                ans.append(first.charAt(i));
                first.deleteCharAt(i);
            } else {
                ans.append(second.charAt(i));
                second.deleteCharAt(i);
            }
        }
        if (first.length() > 0) ans.append(first);
        if (second.length() > 0) ans.append(second);
        System.out.println(ans.toString().replaceAll("\\{", ""));

    }
}
