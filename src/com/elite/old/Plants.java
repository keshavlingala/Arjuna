package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class Plants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] land = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = scanner.nextInt();
        for (int i = 0; i < land.length; i++) {
            boolean left = i == 0 || land[i - 1] == 0;
            boolean right = i == land.length - 1 || land[i + 1] == 0;
            if (left && right && land[i] == 0) {
                n--;
                land[i] = 1;
                if (n == 0) {
                    break;
                }
            }
        }
        System.out.println(n == 0);
    }
}
