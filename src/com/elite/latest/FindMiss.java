package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class FindMiss {
    static int ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = ((nums.length + 1) * (nums.length + 2)) / 2;
//        System.out.println(ans);
        ans -= Arrays.stream(nums).sum();
        System.out.println(ans);
    }
}
