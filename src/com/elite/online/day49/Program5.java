package com.elite.online.day49;

import java.util.Arrays;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int roads = scanner.nextInt();
        int ans = 0;
        boolean[][] field = new boolean[row][col];
        for (int i = 0; i < roads; i++) {
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            for (int j = s; j <= e; j++)
                field[r - 1][j - 1] = true;
        }
        for (int i = 0; i < row; i++) for (int j = 0; j < col; j++) ans += field[i][j] ? 0 : 1;


        System.out.println(Arrays.deepToString(field));
        System.out.println(ans);

    }
}
