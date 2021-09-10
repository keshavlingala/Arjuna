package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class LastZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int e = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[e];
                nums[e] = temp;
                e++;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
