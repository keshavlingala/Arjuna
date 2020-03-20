package com;

/*Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons.
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then
Find the maximum coins you can collect by bursting the balloons wisely.
Note:
1. You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
2. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:
Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

Testcase 1 :
Enter no of ballons
4
Enter ballon nums
3 1 5 8
No of coins are : 167
*/

//Write code here

import java.util.Scanner;
import java.util.stream.IntStream;

public class BallonBurst {


    private static int maxCoins(int[] balloons) {
        int[] nums = new int[balloons.length + 2];
        int n = 1;
        for (int balloon : balloons)
            if (balloon > 0)
                nums[n++] = balloon;
        nums[0] = nums[n++] = 1;
        int[][] arr = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    arr[left][right] = Math.max(arr[left][right], nums[left] * nums[i] * nums[right] + arr[left][i] + arr[i][right]);
            }
        return arr[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = IntStream.range(0, scanner.nextInt()).map(i -> scanner.nextInt()).toArray();
        System.out.println(maxCoins(nums));
    }
}
