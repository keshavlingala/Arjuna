package com.arjuna.season28;

import java.util.Scanner;

public class PairSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i] = Integer.parseInt(s[i]);
        }
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            count += backTrack(arr1, i, 0, 0);
            System.arraycopy(arr, 0, arr1, 0, arr1.length);
        }
        System.out.println(count / duplicate(arr));
    }


    private static boolean checkPerfectSquare(double x) {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }

    private static int duplicate(int[] arr) {
        int[] numOfDuplicates = new int[arr.length];
        for (int i = 0; i < numOfDuplicates.length; i++) {
            numOfDuplicates[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] != -1 && arr[i] == arr[j]) {
                    numOfDuplicates[i]++;
                    arr[j] = -1;
                }
            }
        }
        int result = 1;
        for (int numOfDuplicate : numOfDuplicates) {
            result *= factorial(numOfDuplicate);
        }
        return result;
    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    private static int backTrack(int[] arr, int i, int c, int count) {
        if (c == arr.length - 1) {
            return count + 1;
        }
        for (int j = 0; j < arr.length; j++) {
            if (j != i && arr[j] != -1 && arr[i] != -1 && checkPerfectSquare(arr[j] + arr[i])) {
                int x = arr[i];
                arr[i] = -1;
                c++;
                count = backTrack(arr, j, c, count);
                arr[i] = x;
                c--;
            }
        }
        return count;
    }
}
