package com.leetcode;

public class NonDecreasing {
    public static void main(String[] args) {
        int[] nums = {-1, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    static boolean checkPossibility(int[] nums) {
        int index = -1;
        int c = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                c++;
                index = i;
            }
        }
        if (c == 0) return true;
        if (c > 1) return false;
        if (index == 0 || index + 1 == nums.length - 1) return true;
        return nums[index - 1] <= nums[index + 1] || nums[index] <= nums[index + 2];
    }
}
