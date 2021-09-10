package com.elite.latest;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int c = 1;
            char temp = str.charAt(i);
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                c++;
                i++;
            }
            ans.append(temp);
            if (c != 0 && c != 1)
                ans.append(c);
        }
//        System.out.println(ans.toString());
        System.out.println(ans.length());
    }
}

