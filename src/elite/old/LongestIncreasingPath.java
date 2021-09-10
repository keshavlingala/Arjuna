package com.elite.old;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LongestIncreasingPath {
    static int[][] matrix;
    static HashMap<String, Integer> mem;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        matrix = new int[n][n];
        mem = new HashMap<>();
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++)
            matrix[i] = IntStream.range(0, n).map(j -> scanner.nextInt()).toArray();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                ans = Math.max(dfs(i, j), ans);
        System.out.println(ans);
        System.out.println(mem);
    }

    static int dfs(int i, int j) {
        String key = i + " " + j;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        System.out.println("Calculated");
        int m = 0;
        if (i > 0 && matrix[i - 1][j] > matrix[i][j])
            m = Math.max(m, dfs(i - 1, j));
        if (j > 0 && matrix[i][j - 1] > matrix[i][j])
            m = Math.max(m, dfs(i, j - 1));
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j])
            m = Math.max(m, dfs(i + 1, j));
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j])
            m = Math.max(m, dfs(i, j + 1));
        mem.put(key, 1 + m);
        return 1 + m;
    }
}
