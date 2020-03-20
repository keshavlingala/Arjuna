package com.elite.latest;

import java.util.Scanner;

public class RectangleCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if(row<0||col<0){
            System.out.println(-2);
            System.exit(0);
        }
        if (row < 2 || col < 2) {
            System.out.println(-1);
            System.exit(0);
        }
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix[i][j] = scanner.nextInt();
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row; j++) {
                int p = 0;
                int c = -1;
                while (p < col) {
                    if (matrix[i][p] == 1 && matrix[j][p] == 1) {
                        c++;
                    }
                    p++;
                }
                ans += c * (c + 1) / 2;
//                System.out.println(c * (c + 1) / 2);
            }
        }
        System.out.println(ans);


    }
}
