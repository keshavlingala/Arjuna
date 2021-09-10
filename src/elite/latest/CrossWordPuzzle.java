package elite.latest;

import java.util.Scanner;

public class CrossWordPuzzle {
    static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] grid = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = scanner.next().charAt(0);
            }
        }
        String target = scanner.next();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == target.charAt(0)) {
                    for (int[] side : delta) {
                        if (dfs(grid, target, i, j, "" + target.charAt(0), 1, side)) {
                            System.out.println(i + " " + j);
                            break;
                        }
                    }
                }
            }
        }
    }

    static boolean dfs(char[][] grid, String target, int i, int j, String ans, int index, int[] direction) {
        if (target.equalsIgnoreCase(ans)) {
            return true;
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        int ni = i + direction[0], nj = j + direction[1];
        if(ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length){
            return false;
        }
        if (grid[ni][nj] == target.charAt(index))
            return dfs(grid, target, ni, nj, ans + target.charAt(index), index + 1, direction);
        return false;
    }

}
/*5
5
T E X T K
T E T T M
E X T T I
T E L P T
A B C D E
TET*/