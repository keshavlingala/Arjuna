package hc;

import java.util.Arrays;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] sudoku = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(sudoku));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (char[] value : board) {
            if (!isValid(value))
                return false;
        }
        System.out.println("Valid Rows");
        for (int i = 0; i < board.length; i++) {
            char[] col = new char[9];
            int idx = 0;
            for (char[] row : board)
                col[idx++] = row[i];
            if (!isValid(col)) return false;
        }
        System.out.println("Valid Columns");
        int[][] boxes = new int[][]{{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7},
                {7, 1}, {7, 4}, {7, 7}};
        int[][] delta = new int[][]{
                {0, 0}, {0, 1}, {1, 0},
                {1, 1}, {0, -1}, {-1, 0},
                {-1, -1}, {-1, 1}, {1, -1}
        };
        for (int[] point : boxes) {
            int i = 0;
            char[] box = new char[9];
            for (int[] d : delta) {
                int x = point[0] + d[0];
                int y = point[1] + d[1];
                box[i++] = board[x][y];
            }
            if (!isValid(box))
                return false;
        }
        System.out.println("Valid Boxes");
        return true;
    }

    private static boolean isValid(char[] s) {
        for (int i = 0; i < (s.length - 1); i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i] != '.' && s[i] == s[j]) {
                    return false;
                }
            }
        }
        return true;

    }
}
