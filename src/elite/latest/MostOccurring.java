package com.elite.latest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MostOccurring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int max = 0;
        int ans = 0;
        for (int i : nums.stream().distinct().collect(Collectors.toList())) {
            int m = Collections.frequency(nums, i);
            if (m > max) {
                max = m;
                ans = nums.indexOf(i);
            }
        }
        System.out.println("Element with maximum frequency present at index " + ans);
    }
}
