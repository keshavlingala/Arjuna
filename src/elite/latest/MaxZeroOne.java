package com.elite.latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MaxZeroOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> hp = new HashMap<>();
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            hp.putIfAbsent(sum, i);
            if (hp.containsKey(sum - 1) && sum <= 0) {
                max = Math.max(max, i - hp.get(sum - 1) + 1);
            }
            if (hp.containsKey(sum + 1) && sum >= 0) {
                max = Math.max(max, i - hp.get(sum + 1) + 1);
            }
        }
        System.out.println(max);
    }
}
