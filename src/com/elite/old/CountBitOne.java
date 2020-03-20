package com.elite.old;

import java.util.Scanner;

public class CountBitOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        for (int i = start; i <= end; i++) {
            int c = 0;
            int j = i;
            while (j > 0) {
                c += (j & 1);
                j = j >> 1;
            }
            System.out.print(c + " ");
        }
    }
}