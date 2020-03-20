package com.other;

import java.util.Scanner;

public class DFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int asum = 0;
        int bsum = 0;
        for (int i = 2; i < a; i++)
            if (a % i == 0)
                asum += i;
        for (int i = 2; i < b; i++)
            if (b % i == 0)
                bsum += i;
        System.out.println(asum == bsum ? "No DNumber" : "DNumber");
    }
}
