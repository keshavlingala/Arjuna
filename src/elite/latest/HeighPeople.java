package com.elite.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HeighPeople {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] pq = new int[n][2];
        for (int i = 0; i < n; i++) {
            pq[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
        }
        Arrays.sort(pq, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        ArrayList<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(pq[i][1], pq[i]);
        }
        System.out.print("[");
        ans.stream().map(i -> Arrays.toString(i) + " ").forEach(System.out::print);
        System.out.print("]");
        System.out.println();
        System.out.println(Arrays.deepToString(ans.toArray()));

    }
}
