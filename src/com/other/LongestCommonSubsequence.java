/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some 
characters(can be none) deleted without changing the relative order of the remaining characters.
(eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
is a subsequence that is common to both strings.

If there is no common subsequence, return 0.

Example 1:
    
    Input: abcde ace 
    Output: 3  
    Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

    Input: abc abc
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

    Input: abc def
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.

*/

package com.other;


import java.util.Scanner;

class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int lcs = longestCommonSubsequence(s1, s2);
        System.out.println(lcs);
        System.out.println(s1.length() + s2.length() - 2 * lcs);
    }
}
