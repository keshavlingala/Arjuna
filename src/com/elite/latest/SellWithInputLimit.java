package com.elite.latest;


import java.util.Arrays;
import java.util.Scanner;

class SellWithInputLimit {
    static int sum = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = Arrays
                .stream(sc.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sell(arr, 0, 0, sc.nextInt());
        System.out.println(sum);
    }

    static void sell(int[] arr, int l, int s, int c) {
        sum = Math.max(sum, s);
        if (c <= 0)
            return;
        int i = l;
        while (i < arr.length - 1) {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[i] < arr[j])
                    sell(arr, j + 1, s + arr[j] - arr[i], c - 1);
                j++;
            }
            i++;
        }
    }
}
