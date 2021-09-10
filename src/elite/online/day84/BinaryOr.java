package com.elite.online.day84;

import java.math.BigInteger;
import java.util.Scanner;

public class BinaryOr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        StringBuilder xBin = new StringBuilder(new BigInteger(scanner.next(), 16).toString(2));
        StringBuilder yBin = new StringBuilder(new BigInteger(scanner.next(), 16).toString(2));
        StringBuilder zBin = new StringBuilder(new BigInteger(scanner.next(), 16).toString(2));
        int max = Math.max(xBin.length(), Math.max(yBin.length(), zBin.length()));
        while (xBin.length() < max) xBin.insert(0, "0");
        while (yBin.length() < max) yBin.insert(0, "0");
        while (zBin.length() < max) zBin.insert(0, "0");
        int c = Q;
        for (int i = 0; i < max; i++) {
            int x = xBin.charAt(i) - '0';
            int y = yBin.charAt(i) - '0';
            int z = zBin.charAt(i) - '0';
            if (z == (x | y)) continue;
            if (z == 0) {
                if (y == 1) {
                    yBin.replace(i, i + 1, "0");
                    c--;
                }
                if (x == 1) {
                    xBin.replace(i, i + 1, "0");
                    c--;
                }
            } else {
                if (x == 0 && y == 0) {
                    yBin.replace(i, i + 1, "1");
                    c--;
                }
            }
        }
        if (c < 0) {
            System.out.println(-1);
            return;
        }
        if (c > 0) {
            for (int i = 0; i < max; i++) {
                int x = xBin.charAt(i) - '0';
                int y = yBin.charAt(i) - '0';
                int z = zBin.charAt(i) - '0';
                if (c <= 0) break;
                if (z == 1 && y == 1 && x == 1) {
                    c--;
                    xBin.replace(i, i + 1, "0");
                } else if (x == 1 && y == 0 && z == 1 && c >= 2) {
                    xBin.replace(i, i + 1, "0");
                    yBin.replace(i, i + 1, "1");
                    c -= 2;
                }
            }
        }
        System.out.println(new BigInteger(xBin.toString(), 2).toString(16));
        System.out.println(new BigInteger(yBin.toString(), 2).toString(16));
//        System.out.println(new BigInteger(zBin.toString(), 2).toString(16));
//        System.out.println(c);
    }
}
