package com.elite.online.day81;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class ReachTarget {
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean ans = false;
    static char[][] grid;
    static int target;
    static boolean[][] visited;
    static BiPredicate<Integer, Integer> isAvail = (i, j) -> {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[i].length) return false;
        if (visited[i][j]) return false;
        return grid[i][j] != 'B';
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hei = scanner.nextInt();
        int wid = scanner.nextInt();
        grid = new char[hei][wid];
        int si = 0;
        int sj = 0;
        for (int i = 0; i < hei; i++) {
            String row = scanner.next();
            if (row.contains("S")) {
                sj = row.indexOf('S');
                si = i;
            }
            grid[i] = row.toCharArray();
        }
        target = scanner.nextInt();
        visited = new boolean[hei][wid];
//        System.out.println(si + " " + sj);
        rec(si, sj, 0);
        System.out.println(ans ? "pass" : "fail");
    }

    static void rec(int x, int y, int decisions) {
        if (decisions > target) return;
        if (decisions == target)
            if (grid[x][y] == '*')
                ans = true;
        int ways = 0;
        for (int[] s : delta) {
            ways += (isAvail.test(x + s[0], y + s[1]) && !visited[x + s[0]][y + s[1]]) ? 1 : 0;
        }
        if (ways > 1) decisions++;
        visited[x][y] = true;
        for (int[] ij : delta) {
            int i = x + ij[0];
            int j = y + ij[1];
            if (isAvail.test(i, j) && !visited[i][j])
                rec(i, j, decisions);
        }
        visited[x][y] = false;
    }
}
