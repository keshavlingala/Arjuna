package com.elite.online.day51;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        if (r != c) {
            System.out.println(-1);
            System.exit(0);
        }
        int[][] matrix = new int[r][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                if (i == r / 2 || j == r / 2)
                    matrix[j][i] = scanner.nextInt();
                else
                    matrix[i][j] = scanner.nextInt();

            }
        }
//        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
