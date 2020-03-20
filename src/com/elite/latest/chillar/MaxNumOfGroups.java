package com.elite.latest.chillar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MaxNumOfGroups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int c = 0;
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashSet<Integer> list = new HashSet<>();
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
            } else {
                c++;
                list.clear();
            }
        }
        System.out.println(c);
    }
}
