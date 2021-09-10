package com.elite.online.day78;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program1 {
    static int k = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++)
            nums.add(scanner.nextInt());
        System.out.println(rec(nums, 0));
    }

    static int rec(List<Integer> nums, int sum) {
        if (sum > k) return 0;
        if (sum == k) return 1;
        int c = 0;
        for (int i = 0; i < nums.size(); i++) {
            c += rec(nums.subList(i, nums.size()), sum + nums.get(i));
        }
        return c;
    }
}
