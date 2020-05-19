package com.elite.online.oral;

import java.util.Arrays;
import java.util.Scanner;

public class ThrowMango {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] people = new int[n];
        for (int i = 0; i < n; i++) people[i] = scanner.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            int left = people[i] + 1;
            int right = people[i] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (left > 0) {
                    left -= people[j];
                    scores[j]++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (right > 0) {
                    scores[j]++;
                    right -= people[j];
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(scores));
    }
}
