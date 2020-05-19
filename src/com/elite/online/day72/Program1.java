package com.elite.online.day72;

import java.util.ArrayList;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt(), subjects = scanner.nextInt();
        int[][] marks = new int[students][subjects];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                marks[i][j] = scanner.nextInt();
            }
        }
        int considered = scanner.nextInt();
        int[] rules = new int[considered];
        for (int i = 0; i < rules.length; i++) {
            rules[i] = scanner.nextInt();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < students; i++) ans.add(i);
        ans.sort((o1, o2) -> {
            for (int rule : rules) {
                if (marks[o1][rule - 1] == marks[o2][rule - 1]) continue;
                if (marks[o1][rule - 1] > marks[o2][rule - 1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 1;
        });
//        System.out.println(ans);
        System.out.println(ans.get(0) + 1);

    }
}
