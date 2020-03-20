package com.elite.old;

import java.util.Scanner;

public class BackSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder(scanner.next());
        StringBuilder b = new StringBuilder(scanner.next());
        int i = 0;
        BIG:
        while (i < a.length() && i >= 0) {
            while (a.charAt(0) == '$') {
                a.deleteCharAt(0);
                if (a.length() == 0) break BIG;
            }
            int index = a.indexOf("$");
            if (index == -1) break;
            a.delete(index - 1, index + 1);
            i = index - 2;
            i++;
        }
        i = 0;
        BIG:
        while (i < b.length() && i >= 0) {
            while (a.length() > 0 && b.charAt(0) == '$') {
                b.deleteCharAt(0);
                if (b.length() == 0) break BIG;
            }
            int index = b.indexOf("$");
            if (index == -1) break;
            b.delete(index - 1, index + 1);
            i = index - 2;
            i++;
        }
//        System.out.println(a);
//        System.out.println(b);
        System.out.println(a.toString().equals(b.toString()));

    }
}
