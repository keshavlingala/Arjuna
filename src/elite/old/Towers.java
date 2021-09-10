package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

public class Towers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            max = Math.max(max, Math.min(arr[s], arr[e]) * (e - s));
            if (arr[s] < arr[e]) {
                s++;
            } else e--;
        }
        System.out.println(max);

    }
}
