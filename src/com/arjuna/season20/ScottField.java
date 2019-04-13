package com.arjuna.season20;

import java.util.Scanner;

public class ScottField {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int result[][] = new int[arr.length][arr[0].length];
        int max = 0;
//        setting 1st column as it is ,
        for (int i = 0; i < arr.length; i++) {
            result[i][0] = arr[i][0];
            if (result[i][0] == 1)
                max = 1;
        }
//        setting 1st row as it is
        for (int i = 0; i < arr[0].length; i++) {
            result[0][i] = arr[0][i];
//            if this row contains 1 minimum sub-matrix can be 1
            if (result[0][i] == 1)
                max = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (arr[i][j] == 0)
                    continue;
//                in the new matrix if 1 then min of  top, left, top-left value +1 will be given to that place so that it forms a square matrix
                int t = Math.min(Math.min(result[i - 1][j], result[i - 1][j - 1]), result[i][j - 1]);
                result[i][j] = t + 1;
                if (result[i][j] > max) {
                    max = result[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
