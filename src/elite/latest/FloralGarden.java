package com.elite.latest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FloralGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> uniques = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int i = 0;
        int c = 0;
        int lastI = 0;
        while (i < nums.length) {
            if (uniques.containsKey(nums[i])) {
                uniques.put(nums[i], uniques.get(nums[i]) + 1);
                c++;
            } else if (uniques.size() == 2) {
                max = Math.max(c, max);
                i = lastI;
                uniques.clear();
                c = 0;
                continue;
            } else {
                uniques.put(nums[i], 1);
                c++;
                lastI = i;
            }
            i++;
        }
        System.out.println(Math.max(c, max));
//        int c = 0;
//        int one;
//        for (int num : nums) {
//            if (!uniques.containsKey(num) && uniques.size() < 2) {
//                uniques.put(num, 1);
//                one = num;
//            } else if (uniques.containsKey(num)) {
//                uniques.put(num, uniques.get(num) + 1);
//                max = Math.max(max, uniques.values().stream().reduce(0, Integer::sum));
//            } else {
//                max = Math.max(max, uniques.values().stream().reduce(0, Integer::sum));
//                uniques.remove(one);
//                uniques.put(num, 1);
//            }
//        }
//        System.out.println(max == Integer.MIN_VALUE ? c : max);
    }
}
