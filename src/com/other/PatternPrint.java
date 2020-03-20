package com.other;

import java.util.Scanner;

class PatternPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = (n * (n + 1)) / 2;
        for (int i = n - 1; i >= 0; i--) {
            int q = k - i;
            for (int j = 0; j <= i; j++) {
                System.out.print(q + " ");
                k--;
                q++;
            }
            System.out.println();
        }
    }
}