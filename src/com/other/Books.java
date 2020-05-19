package com.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());
        int[][] arr = new int[N][2];
        for (int i_arr = 0; i_arr < N; i_arr++) {
            String[] arr_arr = scanner.nextLine().split(" ");
            for (int j_arr = 0; j_arr < arr_arr.length; j_arr++) {
                arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
            }
        }

        long out_ = Solution(arr);
        System.out.println(out_);
    }

    static long Solution(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : arr) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        System.out.println(Arrays.deepToString(arr));
        merged.forEach(i -> System.out.println(Arrays.toString(i)));
        return 1;
    }
}

