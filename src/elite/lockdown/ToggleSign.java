package com.elite.lockdown;

import java.util.Arrays;
import java.util.Scanner;

public class ToggleSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                c++;
            } else if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                c++;
            }
        }
        ans = c;
        c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] > nums[i - 1]) {
                c++;
            } else if (i % 2 == 0 && nums[i] < nums[i - 1]) {
                c++;
            }
        }
        System.out.println(Math.max(ans, c));
    }
}
