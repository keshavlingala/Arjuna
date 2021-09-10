package com.elite.latest;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {

            }
        }
    }

    int sum(char[] a, char[] b) {
        if (a.length < b.length) {
            return sum(b, a);
        }
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += (a[i] - '0') + (b[i] - '0');
        }
        for (int i = a.length; i < b.length; i++) {
            s += b[i] - '0';
        }
        return s;
    }
}
