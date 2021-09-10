package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++)
            matrix[i] = IntStream.range(0, col).map(j -> scanner.nextInt()).toArray();
        int key = scanner.nextInt();
        System.out.println(find(matrix, key));
    }

    static boolean find(int[][] matrix, int key) {
        for (int[] ints : matrix)
            if (Arrays.binarySearch(ints, key) > 0)
                return true;
        return false;
    }
}
