package com.elite.old;

import java.util.Scanner;

public class AandB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder secrete = new StringBuilder(scanner.next());
        StringBuilder target = new StringBuilder(scanner.next());
        int a = 0;
        int b = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == secrete.charAt(i) && target.charAt(i) != '#') {
                a++;
                target.replace(i, i + 1, "#");
                secrete.replace(i, i + 1, "#");
            } else {
                char ch = target.charAt(i);
                int si = secrete.indexOf(ch + "");
                if (si != -1) {
                    if (target.charAt(si) == ch) {
                        a++;
                        target.replace(i, i + 1, "#");
                        secrete.replace(i, i + 1, "#");
                    } else {
                        b++;
                        target.replace(i, i + 1, "#");
                        secrete.replace(si, si + 1, "#");
                    }
                }
            }
        }
        System.out.println(a + "A" + b + "B");
    }
}
