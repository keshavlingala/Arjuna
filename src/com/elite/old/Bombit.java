package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class Bombit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] grid = new char[row][col];
        scanner.nextLine();
        for (int i = 0; i < row; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }
        System.out.println(Arrays.deepToString(grid));
    }
}
