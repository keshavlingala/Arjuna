/*
 * 
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's 
 and return its area.

Example:

Input: 4
5
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4


 */



import java.util.Scanner;

public class MaximalSquare {

	 public static int maximalSquare(int[][] matrix) {
	        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
	        int[][] dp = new int[rows + 1][cols + 1];
	        int maxsqlen = 0;
	        for (int i = 1; i <= rows; i++) {
	            for (int j = 1; j <= cols; j++) {
	                if (matrix[i-1][j-1] == 1){
	                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
	                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
	                }
	            }
	        }
	        return maxsqlen * maxsqlen;
	    }
	 
	  public static void main(String args[] ) {
			 Scanner scan = new Scanner(System.in);
				int R=scan.nextInt();
				int C=scan.nextInt();      

				int[][] matrix=new int[R][C];
			       for(int i=0; i<R; i++)
			       {
			           for(int j=0; j<C; j++)
			           {
			        	   matrix[i][j] = scan.nextInt();
			           }
			       }
			       System.out.println(maximalSquare(matrix));
		}
}
