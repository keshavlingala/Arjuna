package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class ImageRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] img = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                img[j][i] = scanner.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(img));
    }

}
