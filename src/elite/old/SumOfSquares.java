package com.elite.old;
/*
Given a positive integer n,
        find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
        which sum to n.

        Example 1:
        Input: 12
        Output: 3
        Explanation: 12 = 4 + 4 + 4.

        Example 2:
        Input: 13
        Output: 2
        Explanation: 13 = 4 + 9.*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SumOfSquares {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] dp = new int[n + 1];
//        ArrayList<Integer> sqs = new ArrayList<>();
//        dp[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            if (Math.sqrt(i) % 1 == 0) {
//                dp[i] = 1;
//                sqs.add(i);
//            } else {
//                dp[i] = Integer.MAX_VALUE;
//                for (int k : sqs)
//                    dp[i] = Math.min(dp[i], dp[i - k] + 1);
//            }
//        }
//        System.out.println(dp[n]);
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


    }

    static int find(int n) {
        int level = 0;
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i * i < n; i++) {
            squares.add(i * i);
        }
        Set<Integer> q = new HashSet<>();
        q.add(n);
        while (!q.isEmpty()) {
            level += 1;
            Set<Integer> nq = new HashSet<>();
            for (int rem : q) {
                for (int sq : squares) {
                    if (rem == sq) {
                        return level;
                    } else if (rem < sq) {
                        break;
                    } else {
                        nq.add(rem - sq);
                    }
                }
                q = nq;
            }
        }
        return level;
    }
}
