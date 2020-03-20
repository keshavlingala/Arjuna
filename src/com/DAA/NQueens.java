package com.DAA;

/*
Java program to solve 8 Queen Problem using backtracking
The 4 Queen is the problem of placing 8 chess queens on an 8×8 chessboard
so that no two queens attack each other.
sample output=
one of the solution for 8-queens problem is
1 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 1
0 1 0 0 0 0 0 0
0 0 0 1 0 0 0 0
0 0 0 0 0 1 0 0
0 0 1 0 0 0 0 0
*/
class NQueen {
    final int N = 8;

    void printSolution(int board[][]) {
        //add code here to print board array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check for queen's row attack*/
        for (i = 0; i < col; i++) //fill ? here
            if (board[row][i] == 1)//fill ? here
                return false;

        /* Check for queen's upper diagonal attack*/
        //add code here....
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        /* Check for queen's lower diagonal attack*/
        //add code here....


        return true;
    }

    /* A recursive utility function to solve N
    Queen problem */
    boolean solveNQUtil(int board[][], int col) {
		/* base case: If all queens are placed
		then return true */
        if (col >= N)
            return true;

		/* Consider this column and try placing
		this queen in all rows one by one */
        for (int i = 0; i < N; i++) {
			/* Check if queen can be placed on
			board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                    return true;

				/* If placing queen in board[i][col]
				doesn't lead to a solution then
				remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

		/* If queen can not be place in any row in
		this colum col, then return false */
        return false;
    }

    boolean solveNQ() {

        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };


        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }

}

// driver program to test above function
class NQueens {

    public static void main(String args[]) {
        NQueen obj = new NQueen();
        System.out.println("one of the solution for 8-queens problem is");
        obj.solveNQ();
    }
}

