package com.elite.online.day50;

import java.util.Scanner;

public class Program2 {
    static int dim;
    static int[][] matrix;
    static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dim = scanner.nextInt();
        matrix = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                rec(i, j, 0);
            }
        }
        System.out.println(ans);
    }

    static void rec(int r, int c, int sum) {
        if (r >= dim || r < 0 || c >= dim || c < 0) {
            ans = Math.max(sum, ans);
            return;
        }
//        System.out.println(r + " " + c);
        sum += matrix[r][c];
        rec(r + 1, c, sum);
        rec(r + 1, c + 1, sum);
        rec(r + 1, c - 1, sum);
    }
}
