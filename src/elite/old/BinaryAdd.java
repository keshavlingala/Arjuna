package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class BinaryAdd {
    static int carry = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder(scanner.next());
        StringBuilder b = new StringBuilder(scanner.next());
        if (a.length() != b.length()) {
            while (a.length() < b.length())
                a.insert(0, '0');
            while (b.length() < a.length())
                b.insert(0, '0');
        }
        StringBuilder ans = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            ans.insert(0, add(a.charAt(i), b.charAt(i), ("" + carry).charAt(0)));
        }
        if (carry == 1) {
            ans.insert(0, "1");
        }
        System.out.println(ans.toString());
    }
    static String add(Character... a) {
        int s = Arrays.stream(a).map(i -> "" + i).mapToInt(Integer::parseInt).sum();
        if (s == 0) {
            carry = 0;
            return "0";
        }
        if (s == 1) {
            carry = 0;
            return "1";
        } else if (s == 2) {
            carry = 1;
            return "0";
        } else {
            carry = 1;
            return "1";
        }
    }
}
