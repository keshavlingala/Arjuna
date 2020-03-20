package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class MultiplySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int ls = 1;
        int rs = 1;
        int i, j;
        for (i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            ls *= nums[i];
            leftSum[i] = ls;
            rs *= nums[j];
            rightSum[j] = rs;
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.print(((k - 1) >= 0 ? leftSum[k - 1] : 1) * ((k + 1 < nums.length) ? rightSum[k + 1] : 1) + " ");
        }
    }
}
