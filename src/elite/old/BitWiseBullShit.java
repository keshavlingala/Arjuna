package com.elite.old;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BitWiseBullShit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[nums.length][nums.length];
        dp[0] = nums;
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[i][j] = (dp[i - 1][j] | dp[i - 1][j - 1]);
                set.add(dp[i][j]);
            }
        }
        System.out.println(set.size());
    }
}
