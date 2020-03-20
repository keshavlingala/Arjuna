package com.elite.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Envolopes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return -(a[1] - b[1]);
            return a[0] - b[0];
        });
//        System.out.println(Arrays.deepToString(arr));
        for (int[] value : arr) {
            int index = Collections.binarySearch(ans, value[1]);
            if (index >= 0)
                continue;
            if (index == -(ans.size() + 1))
                ans.add(value[1]);
            else
                ans.set(ans.size() - 1, value[1]);
        }
        System.out.println(ans.size());
    }
}
