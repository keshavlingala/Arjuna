package com.elite.latest.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = scanner.nextInt();
        ArrayList<Integer> q = new ArrayList<>();
        int i;
        if (size > nums.length)
            size = size % nums.length;
        for (i = 0; i < size; i++) {
            q.add(nums[i]);
        }
        for (; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        for (int item : q) {
            System.out.print(item + " ");
        }
    }
}
