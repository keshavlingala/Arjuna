package com.elite.online.day74;

import java.util.Scanner;

public class BurstMangoes {
    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int target = scanner.nextInt();
        int[][] grid = new int[rows][cols];
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] row = scanner.next().toCharArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '.') {
                    grid[i][j] = 0;
                    copy[i][j] = 0;
                } else if (row[j] == 'O') {
                    grid[i][j] = 2;
                    copy[i][j] = 2;
                }
            }
        }
        System.out.println(1);
        print(copy);
        for (int day = 2; day <= (target - 3) % 4 + 3; day++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 0) copy[i][j] = 3;
                    else if (grid[i][j] == 3 && copy[i][j] == 3) copy[i][j] = 2;
                    else if (grid[i][j] == 2 && copy[i][j] == 2) copy[i][j] = 1;
                    else if (grid[i][j] == 1 && copy[i][j] == 1) {
                        copy[i][j] = -1;
                        if (i + 1 < rows && grid[i + 1][j] != 1) copy[i + 1][j] = -1;
                        if (i - 1 >= 0 && grid[i - 1][j] != 1) copy[i - 1][j] = -1;
                        if (j + 1 < cols && grid[i][j + 1] != 1) copy[i][j + 1] = -1;
                        if (j - 1 >= 0 && grid[i][j - 1] != 1) copy[i][j - 1] = -1;
                    }
                }
            }
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if (copy[i][j] != -1)
                        grid[i][j] = copy[i][j];
                    else
                        grid[i][j] = copy[i][j] = 0;
            System.out.println(day);
            print(copy);

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0)
                    System.out.print('O');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
}
