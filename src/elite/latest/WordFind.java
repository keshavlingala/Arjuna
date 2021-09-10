package com.elite.latest;

import java.util.Scanner;

public class WordFind {
    static boolean recur(char[][] arr, String target, int i, int j, int[][] visited) {
        visited[i][j] = 1;
        if (target.equals("")) {
            return true;
        }
        if (target.length() == 1) {
            if (arr[i][j] == target.charAt(0)) {
                return true;
            }
        }
        if (i > arr.length - 1 || j > arr.length - 1) {
            return false;
        }
        boolean flag = false;
        if (target.charAt(0) == arr[i][j]) {
            if (i + 1 < arr.length && visited[i + 1][j] == 0)
                flag = flag || recur(arr, target.substring(1), i + 1, j, visited);
            if (i - 1 >= 0 && visited[i - 1][j] == 0) flag = flag || recur(arr, target.substring(1), i - 1, j, visited);
            if (j + 1 < arr[0].length && visited[i][j + 1] == 0)
                flag = flag || recur(arr, target.substring(1), i, j + 1, visited);
            if (j - 1 >= 0 && visited[i][j - 1] == 0) flag = flag || recur(arr, target.substring(1), i, j - 1, visited);
        }
        visited[i][j] = 0;
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());
        int col = Integer.parseInt(sc.nextLine());
        char[][] arr = new char[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }
        String target = sc.next();
        boolean ans = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == target.charAt(0)) {
                    int[][] visited = new int[arr.length][arr[0].length];
                    if (recur(arr, target, i, j, visited)) {
                        ans = true;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}