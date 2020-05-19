package com.elite.online.oral;

import java.util.Arrays;
import java.util.Scanner;

public class MangoCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int available = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        for (int num : nums) if (min > num) min = num;
        int cost = 0;
        int j = min;
        int start = 1;
        int end = available;
        while (start < end) {
            j = (start + end) / 2;
            cost = 0;
            for (int num : nums) cost += Math.ceil((double) num / j);
            if (cost <= available) end = j;
            else start = j + 1;
        }
        System.out.println(end);
    }
}
