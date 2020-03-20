package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxSubArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays
                .stream(scanner.nextLine()
                        .split(","))
                .mapToInt(Integer::parseInt).toArray();
        List<Integer> nums = Arrays.stream(arr).boxed()
                .collect(Collectors.toList());
        int max = maxInt(nums);
        System.out.println(max);
    }

    static int maxInt(List<Integer> nums) {
        if (nums.isEmpty())
            return Integer.MIN_VALUE;
        int minEle = nums.stream().min(Integer::compareTo).get();
        int max = minEle;
        for (int i = 0; i < nums.size(); i++) {
            Stream.of(1, 2, 3).parallel().max(Integer::compareTo).get();
            int left = nums.subList(0, i).isEmpty() ? minEle : nums.subList(0, i).stream().reduce(0, Integer::sum);
            int right = nums.subList(i + 1, nums.size()).isEmpty() ? minEle : nums.subList(i + 1, nums.size()).stream().reduce(0, Integer::sum);
            int leftRec = maxInt(nums.subList(0, i));
            int rightRec = maxInt(nums.subList(i + 1, nums.size()));
            System.out.println(" " + left + " " + right + " " + left + " " + right + " " + max + " " + nums.get(i) + " " + leftRec + " " + rightRec);
            max = Stream.of(left, right, left + right, max, nums.get(i), leftRec, rightRec).max(Integer::compareTo).get();
        }
        return max;
    }
}
