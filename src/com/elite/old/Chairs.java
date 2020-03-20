package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class Chairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
            arr[i][2] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            arr[i + 1][0] += Math.min(arr[i][1], arr[i][2]);
            arr[i + 1][1] += Math.min(arr[i][0], arr[i][2]);
            arr[i + 1][2] += Math.min(arr[i][0], arr[i][1]);
        }
        System.out.println(Arrays.stream(arr[n - 1]).min().getAsInt());
    }
}
