package com.elite.online.day79;
/*Input Format:
    - The first line contains an integer n , the size of array arr.
    - The next line contains space-separated integers arr[i].

Output Format:
    - Print maximum possible score.

Sample Input:
4
3 3 3 3

Sample Output:
2

Explanation:
given set-> [3,3,3,3]
split into [3,3] [3,3] and discard left portion [3,3]
remaining array [3,3]
split in [3] [3] and discard left portion [3]
At this point the array only has 1 element and can no longer be partitioned,
so we can split the array twice,so we print 3.


Sample Input:
7
8 2 0 2 2 0 2
Sample Output:
3

Explanation:
arr              A2         A3
[8,2,0,2,2,0,2]  [8]       [2,0,2,2,0,2]
[2,0,2,2,0,2]    [2,0,2]   [2,0,2]
[2,0,2]          [2,0]     [2]

so we can split the array trice, so we print 3.

*/

import java.util.Arrays;
import java.util.Scanner;

public class BalancedSplit {
    static int maxDepth = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("\n");
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < nums.length; i++) {
            left[i] += nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            right[i] += nums[i];
        }
        rec(nums, 0, nums.length, 0);
        System.out.println(maxDepth);
    }

    private static void rec(int[] nums, int start, int end, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (end <= start + 1) {
            return;
        }
        int l = 0;
        int s = 0;
        for (int i = start; i < end; i++) {
            s += nums[i];
        }
        if (s % 2 != 0) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        int mid = -1;
        for (int i = start; i < end; i++) {
            if (l == s / 2) {
                mid = i;
                break;
            }
            l += nums[i];
        }
        if (mid == start || mid == -1) {
            return;
        }
        rec(nums, start, mid, depth + 1);
        rec(nums, mid, end, depth + 1);
    }
}
