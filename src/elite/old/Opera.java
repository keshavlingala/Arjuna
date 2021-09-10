package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class Opera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int o = scanner.nextInt();
        int[] axis = new int[n];
        for (int i = 0; i < o; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int data = scanner.nextInt();
            axis[start] += data;
            if (end < n - 1) {
                axis[end + 1] -= data;
            }
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            axis[i] += s;
            s = axis[i];
        }
        System.out.println(Arrays.toString(axis));
    }
}
