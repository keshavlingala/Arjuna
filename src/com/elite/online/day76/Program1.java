package com.elite.online.day76;

import java.util.Scanner;

public class Program1 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        System.out.println(compute(width, height, 0));
    }

    static int compute(int width, int layer, int sum) {
        if (width < 0)
            return 0;
        if (width == 0)
            return 1;
        int ways = 0;
        for (int i = 1; i <= 4; i++)
            ways += compute(width - i, layer, sum);
        return ways;
    }
}
