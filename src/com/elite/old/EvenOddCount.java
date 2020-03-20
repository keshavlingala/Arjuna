package com.elite.old;

import java.util.Scanner;

public class EvenOddCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(rec(n, 0));
    }

    static int rec(int n, int count) {
        if (n == 1)
            return count;
        if (n % 2 == 0)
            return rec(n / 2, count + 1);

        return Integer.bitCount(n - 1) >= Integer.bitCount(n + 1) ? rec((n + 1), count + 1) : rec((n - 1), count + 1);
    }
}
