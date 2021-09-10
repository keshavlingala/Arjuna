package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class SpecialIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int i = 0;
//        int[] leftSum = new int[nums.length];
//        int[] rightSum = new int[nums.length];
        int j = Arrays.stream(nums).sum();
        for (int k = 0; k < nums.length; k++) {
            j -= nums[k];
            if (i == j) {
                System.out.println(k);
                System.exit(0);
            }
            i += nums[k];
        }
//
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            leftSum[i] = sum;
//        }
//        sum = 0;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            sum += nums[i];
//            rightSum[i] = sum;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (leftSum[i] == rightSum[i]) {
//                System.out.println(i);
//                System.exit(0);
//                break;
//            }
//        }
//        System.out.println(Arrays.toString(leftSum));
//        System.out.println(Arrays.toString(rightSum));
        System.out.println(-1);
    }
}
