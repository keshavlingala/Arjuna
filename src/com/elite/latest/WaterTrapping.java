package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class WaterTrapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] heights = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];
        for (int i = 0; i < heights.length; i++)
            leftMax[i] = i == 0 ? heights[0] : Math.max(leftMax[i - 1], heights[i]);
        for (int i = heights.length - 1; i >= 0; i--)
            rightMax[i] = i == heights.length - 1 ? heights[heights.length - 1] : Math.max(rightMax[i + 1], heights[i]);
        for (int i = 0; i < heights.length; i++) {
            max += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMax));
        System.out.println(max);
    }
}
