package com.elite.online.day82;

import java.util.Scanner;

public class RamNag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ope = 0;
        int max = 0;
        for (int i = 0; i < scanner.nextInt() - 2; i++) {
            int v = scanner.nextInt();
            if (v > max) {
                max = v;
                ope++;
            }
        }
        System.out.println((ope & 1) == 1 ? "RAM" : "NAG");
    }
}