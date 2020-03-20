package com.elite.old;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class ThirdMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max1 = -1, max2 = -1, max3 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] < max1 && arr[i] > max2) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] < max2 && arr[i] > max3) {
                max3 = arr[i];
            }
        }
//        System.out.println(max1 + " " + max2 + " " + max3);
        System.out.println(max3 == -1 ? max1 : max3);

    }
}
