package com.elite.old;

import java.util.Scanner;

public class PerfectSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int start = 0;
        int end = n / 2 + 1;
        int mid = (start + end) / 2;
        boolean f = false;
        while (start < end) {
            mid = (start + end) / 2;
            int sq = mid * mid;
            if (mid * mid < n && (mid + 1) * (mid + 1) > n) {
                break;
            }
            if (sq == n) {
                System.out.println(mid);
                f = true;
                break;
            }
            if (sq < n) {
                start = mid;
            } else {
                end = mid;
            }

        }
        if (!f)
            System.out.println(mid);

    }
}
