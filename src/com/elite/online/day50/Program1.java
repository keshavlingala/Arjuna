package com.elite.online.day50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt(), e = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), r = sc.nextInt();
            points[i] = new int[]{x - r, x + r};
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> p = new ArrayList<>();
        int start = points[0][0], end = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] <= end)
                end = Math.max(end, points[i][1]);
            else {
                p.add(new int[]{start, end});
                start = points[i][0];
                end = points[i][1];
            }
        }
        p.add(new int[]{start, end});
        int ans = 0;
        for (int[] ints : p) {
            if (ints[1] > s) {
                if (ints[0] >= e) break;
                else if (ints[0] <= s)
                    ans += Math.min(ints[1], e) - s;
                else ans += Math.min(ints[1], e) - ints[0];
            }
        }
        System.out.println(e - s - ans);
    }
}