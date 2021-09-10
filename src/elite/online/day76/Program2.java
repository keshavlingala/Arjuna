package com.elite.online.day76;

import java.util.Scanner;

public class Program2 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        layer(width, "");
    }

    static void layer(int s, String exclude) {
        if (s < 0) return;
        if (s == 0) {
            ans++;
            return;
        }
        for (int i = 1; i <= 4; i++) {
            layer(s - i, exclude + i);
        }
    }
}
