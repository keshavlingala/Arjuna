package com.other;

import java.util.Scanner;

public class SumofFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean flag = false;
        for (int i = 0; i < n - 4; i++) {
            if ((i * 4) + 6 == n) {
                flag = true;
                System.out.println("YES");
                System.out.println(i);
                break;
            }
        }
        if (!flag)
            System.out.println("NO");
    }
}
