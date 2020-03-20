package com.elite.latest;

import java.util.Scanner;

public class SnakeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[i][j] = scanner.nextInt();
                }
            } else {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
