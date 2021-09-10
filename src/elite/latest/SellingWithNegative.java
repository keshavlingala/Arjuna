package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class SellingWithNegative {
    static int sum = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = sc.nextInt();
        sell(0, 0, n);
        System.out.println(sum);
    }

    static void sell(int l, int s, int n) {
        sum = Math.max(sum, s);
        if (l < arr.length - 1) {
            int i = l;
            while (i < arr.length - 1) {
                int j = i + 1;
                while (j < arr.length) {
                    if (arr[i] < arr[j]) {
                        sell(j + 1, s + arr[j] - arr[i] - n, n);
                    }
                    j++;
                }
                i++;
            }
        }
    }
}
