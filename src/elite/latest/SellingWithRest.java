package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class SellingWithRest {
    static int sum = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sell(0, 0);
        System.out.println(sum);
    }

    static void sell(int l, int s) {
        sum = Math.max(sum, s);
        if (l >= arr.length - 1)
            return;
        int i = l;
        while (i < arr.length - 1) {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[i] < arr[j]) {
                    sell(j + 2, s + arr[j] - arr[i]);
                }
                j++;
            }
            i++;
        }
    }
}