package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class MoreThanHalf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int i = 0;
        int ans = nums[nums.length - 1];
        int nw;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (i == 0) {
                ans = nums[j];
                i++;
                continue;
            }
            if (nums[j] == ans) {
                i++;
            } else {
                i--;
            }
        }
        System.out.println(ans);
    }
}
