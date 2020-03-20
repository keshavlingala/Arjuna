package com.other;

import java.util.Scanner;

public class Identity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean yes = true;
        int[][] matrix = new int[n][n];
        CHECK:
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    if (matrix[i][j] != 1) {
                        yes = false;
                        break CHECK;
                    }
                } else {
                    if (matrix[i][j] != 0) {
                        yes = false;
                        break CHECK;
                    }
                }
            }
        System.out.println(yes ? "IDENTITY" : "NOT IDENTITY");
    }
}
