package com.arjuna.season19;

import java.util.Scanner;

public class GoldCoins {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int y = 0;
        int max = matrix[n - 1][0];
        for (int j = 0; j < n; j++)
            if (max < matrix[n - 1][j]) {
                max = matrix[n - 1][j];
                y = j;
            }
        for (int i = n - 1; i >= 0; i++) {
            max = matrix[n - 1][y];
            System.out.println(max);
            max += Math.max(Math.max(matrix[i][y - 1], matrix[i][y]), matrix[i][y+1]);


            System.out.println(max);
        }
    }
}
