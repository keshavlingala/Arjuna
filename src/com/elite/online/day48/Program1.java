package com.elite.online.day48;

import java.util.Scanner;

public class Program1 {
    static char[] chars = {'+', '-', '*', '/'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) nums[i] = scanner.nextInt();
        boolean ans = recursion(nums, 0);
        System.out.println(ans);
    }

    static boolean recursion(int[] nums, int count) {
        if (count > 1729) return false;
        if (count == 1729) return true;
        boolean ans = false;
        for (int i = 0; i < 3; i++) {
            if (chars[i] == '+')
                if (recursion(nums, count + nums[i] + nums[i + 1])) ans = true;
            if (chars[i] == '-')
                if (recursion(nums, count + nums[i] - nums[i + 1])) ans = true;
            if (chars[i] == '*')
                if (recursion(nums, count + nums[i] * nums[i + 1])) ans = true;
            if (chars[i] == '/')
                if (recursion(nums, count + nums[i] / nums[i + 1])) ans = true;
        }
        return ans;

    }
}
