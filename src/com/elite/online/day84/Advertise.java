package com.elite.online.day84;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Advertise {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums =
                IntStream.range(0, scanner.nextInt())
                        .mapToObj(i -> scanner.nextInt())
                        .collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(nums);
        dp = new int[nums.size()];
        dp[0] = nums.get(0);
        dp[1] = nums.get(0) + nums.get(1);
        dp[2] = nums.get(0) + nums.get(1) + nums.get(2);
        Integer[] sum = new Integer[nums.size()];
        sum[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++)
            sum[i] = sum[i - 1] + nums.get(i);
//        System.out.println(Arrays.toString(sum));
        for (int i = 3; i < nums.size(); i++) {
            int one = nums.get(i) + sum[i - 1] - dp[i - 1];
            int two = nums.get(i) + nums.get(i - 1) + sum[i - 2] - dp[i - 2];
            int three = nums.get(i) + nums.get(i - 1) + nums.get(i - 2) + sum[i - 3] - dp[i - 3];
            dp[i] = Math.max(one, Math.max(two, three));
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[nums.size() - 1]);
    }

}