package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class MultipleSell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = 0;
            int c = 0;
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    sum += nums[i + 1] - nums[i];
                    c++;
                }
                if (c == 2) break;
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);

    }
}
