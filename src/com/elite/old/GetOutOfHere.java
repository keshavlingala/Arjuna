package com.elite.old;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetOutOfHere {


    public static void shortestDistance(int[][] matrix) {
        int[][] dist = new int[matrix.length][matrix[0].length];    //New Array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 2)
                    dist[i][j] = -1;
                else if (matrix[i][j] == 1)
                    dist[i][j] = 0;
                else
                    dist[i][j] = 500;     //Coverting the array
            }
        }
        System.out.println("Matrix" + Arrays.deepToString(matrix));
        System.out.println("Dist" + Arrays.deepToString(dist));
        int walk = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {          //If there is exit
                    bfs(dist, matrix, --walk, i, j);  //Do bfs
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(dist[i][j] + " ");//Printing the array
            }
            System.out.println("\n");
        }
    }

    private static void bfs(int[][] dist, int[][] grid, int walk, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();   //Create a queue
        queue.add(new int[]{i, j});                //add the indices

        int depth = 0;
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};   //For traversing

        while (!queue.isEmpty()) {      //If not empty
            depth++;                    //Increase the depth i.e, steps
            int length = queue.size();
            for (int k = 0; k < length; k++) {
                int[] pos = queue.poll();
                for (int l = 0; l < 4; l++) {
                    int y = pos[0] + delta[l][0];   //traaverse
                    int x = pos[1] + delta[l][1];
                    if (y < 0 || y >= grid.length || x < 0 || x >= grid[y].length || grid[y][x] < walk || grid[y][x] > 0) {
                        continue;       //Boundary and unreachable condition
                    }
                    grid[y][x] = walk - 1;    //Reduce the grid value
                    dist[y][x] = Math.min(depth, dist[y][x]);   //Take the minimum value

                    queue.offer(new int[]{y, x}); //Add the index
                }
            }
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        int[][] matrix = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int k = scan.nextInt();
                if (k == 500)
                    matrix[i][j] = 0;
                if (k == 0)
                    matrix[i][j] = 1;
                if (k == -1)
                    matrix[i][j] = 2;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        int[][] dp = new int[R][C];

        shortestDistance(matrix);                //Find the min dist
    }
}
