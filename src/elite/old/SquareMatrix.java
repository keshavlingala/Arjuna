package com.elite.old;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++)
            matrix[i] = IntStream.range(0, col).map(j -> scanner.nextInt()).toArray();
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    int u = i == 0 ? 0 : dp[i - 1][j];
                    int l = j == 0 ? 0 : dp[i][j - 1];
                    int d = j == 0 || i == 0 ? 0 : dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(Math.min(u, l), d);
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        System.out.println(max * max);


    }
}
