package elite.latest;

import java.util.Scanner;

public class CrossWordAll {
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                grid[i][j] = scanner.next().charAt(0);
        String target = scanner.next();
        boolean[][] visited = new boolean[row][col];
        boolean ans = false;
        GO:
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == target.charAt(0)) {
                    visited[i][j] = true;
                    ans = dfs(grid, target, i, j, "" + target.charAt(0), 1, visited);
                    if (ans) break GO;
                    else visited[i][j] = false;
                }
            }
        }
        System.out.println(ans);
    }

    static boolean dfs(char[][] grid, String target, int i, int j, String ans, int index, boolean[][] visited) {
        if (target.equalsIgnoreCase(ans))
            return true;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return false;
        for (int[] side : delta) {
            int ni = i + side[0], nj = j + side[1];
            if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length)
                continue;
            if (grid[ni][nj] == target.charAt(index)) {
                if (!visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (dfs(grid, target, i + side[0], j + side[1], ans + grid[i + side[0]][j + side[1]], index + 1, visited))
                        return true;
                    else
                        visited[ni][nj] = false;
                }
            }
        }
        return false;
    }
}