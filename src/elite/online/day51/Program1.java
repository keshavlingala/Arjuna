package com.elite.online.day51;

import java.util.Arrays;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[r][];
        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int sum = Arrays.stream(matrix[0]).sum();
        int ans = r;
        for (int i = 1; i < sum - 1; i++) {
            int min = 0;
            for (int k = 0; k < r; k++) {
                int c = matrix[k][0];
                int j = 1;
                while (j < matrix[k].length && i > c)
                    c += matrix[k][j++];
                if (i % c != 0) {
                    min += 1;
                }
            }
            ans = Math.min(ans, min);
        }
        System.out.println(ans);
    }
}
