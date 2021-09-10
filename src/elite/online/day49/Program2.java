package com.elite.online.day49;

import java.util.Arrays;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bulbs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = scanner.nextInt();
        int[] days = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++)
            days[bulbs[i] - 1] = i + 1;
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for (int i = 0; right < days.length; i++) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right)
                    res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
                left = i;
                right = k + 1 + i;
            }
        }
        System.out.println(Arrays.toString(days));
        System.out.println(Arrays.toString(bulbs));
        System.out.println((res == Integer.MAX_VALUE) ? -1 : res);
    }
}
